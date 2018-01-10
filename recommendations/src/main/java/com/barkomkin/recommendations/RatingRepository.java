package com.barkomkin.recommendations;

import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> { }
