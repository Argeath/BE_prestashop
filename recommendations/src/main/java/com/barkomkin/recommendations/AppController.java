package com.barkomkin.recommendations;

import com.barkomkin.recommendations.models.*;
import com.google.common.collect.Lists;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.GenericItemSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.Preference;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class AppController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private ProductDetailsRepository productDetailsRepository;
    @Autowired private RatingRepository ratingRepository;

    @PostMapping("/fake-accounts")
    public @ResponseBody String addCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();

        for(int i = 1; i <= 500; i++) {
            String email = "test" + i + "@barkomkin.pl";

            if(findCustomerByEmail(customers, email) != null) { // do not create duplicates
                continue;
            }

            // Create an account
            Customer c = new Customer(RandomDataGenerator.randomName(), RandomDataGenerator.randomSurname(), email);
            customerRepository.save(c);

            System.out.println("Created " + email);
        }

        return "created";
    }

    @PostMapping("/fake-ratings")
    public @ResponseBody String addRatings() {

        Iterable<Product> products = productRepository.findAll();
        Iterable<Rating> ratings = ratingRepository.findAll();
        Iterable<Customer> customers = customerRepository.findAll();

        for(int i = 0; i <= 500; i++) {
            String email = "test" + i + "@barkomkin.pl";

            Customer account = findCustomerByEmail(customers, email);

            if(account == null)
                continue;

            for(Product p: products) {
                if(ThreadLocalRandom.current().nextInt(100) < 3) { // 3%
                    if(findCustomerRatingByProduct(ratings, account, p) != null) // only 1 rating per product per customer
                        continue;

                    Rating r = new Rating(p.getId_product(),
                                          account.getId_customer(),
                                          account.getFirstname() + " " + account.getLastname(),
                                          ThreadLocalRandom.current().nextInt(5) + 1);
                    ratingRepository.save(r);

                    System.out.println(email + " rated " + p.getId_product() + " for " + r.getGrade());
                }
            }
        }

        return "created";
    }

    @GetMapping("/recommendForUser/{id}")
    public @ResponseBody List<RecommendedItem> recommend(@PathVariable("id") int id) throws TasteException {
        DataModel model = new GenericDataModel(getRatingMap());
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.3, similarity, model);
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        return recommender.recommend(id, 10);
    }

    @GetMapping("/recommendForItems/{ids}/{amount}")
    public @ResponseBody List<RecommendedItem> recommend(@PathVariable("ids") String id, @PathVariable("amount") int amount) throws TasteException {
        List<RecommendedItem> items;
        long[] ids = Arrays.stream(id.split(",")).mapToLong(Long::parseLong).toArray();
        int attempts = ids.length > 1 ? ids.length : 1;
        boolean firstTry = true;

        do {
            if(!firstTry && ids.length >= 2) {
                ids = Arrays.copyOf(ids, ids.length-1);
            }

            DataModel model = new GenericDataModel(getRatingMap());

            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
            ItemBasedRecommender recommender = new GenericItemBasedRecommender(model, similarity);

            items = recommender.mostSimilarItems(ids, amount > 20 ? 20 : amount);
            firstTry = false;
        } while(items.size() == 0 || --attempts > 0);

        return items;
    }

    @GetMapping("/customers")
    public @ResponseBody Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/products")
    public @ResponseBody Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
    
    @GetMapping("/ratings")
    public @ResponseBody Iterable<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    private Customer findCustomerByEmail(Iterable<Customer> customers, String email) {
        for(Customer c: customers) {
            if(c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }

        return null;
    }

    private Rating findCustomerRatingByProduct(Iterable<Rating> ratings, Customer customer, Product product) {
        for(Rating r: ratings) {
            if(r.getId_customer() == customer.getId_customer() && r.getId_product() == product.getId_product()) {
                return r;
            }
        }

        return null;
    }

    private FastByIDMap<PreferenceArray> getRatingMap() {
        Iterable<Rating> ratings = ratingRepository.findAll();
        List<Rating> ratingList = Lists.newArrayList(ratings);

        FastByIDMap<PreferenceArray> map = new FastByIDMap<>();

        ratingList.stream().collect(Collectors.groupingBy(Rating::getId_customer)).forEach((index, list) -> {
            List<Preference> prefs = new ArrayList<>();

            list.forEach(r -> prefs.add(new GenericPreference(r.getId_customer(), r.getId_product(), r.getGrade())));

            map.put(index, new GenericUserPreferenceArray(prefs));
        });

        return map;
    }

    private List<ProductDetails> wrapWithProductDetails(List<RecommendedItem> items) {
        List<ProductDetails> details = new ArrayList<>();

        items.forEach(item -> details.add(productDetailsRepository.findOne((int)item.getItemID())));

        return details;
    }
}
