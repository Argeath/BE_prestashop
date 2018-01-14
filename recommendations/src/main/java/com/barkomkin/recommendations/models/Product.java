package com.barkomkin.recommendations.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "ps_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;

    private int id_supplier = 0;

    private int id_manufacturer = 0;

    @NonNull
    private int id_category_default;

    private int id_shop_default = 1;

    private int id_tax_rules_group = 1;

    private int on_sale = 0;

    private int online_only = 0;

    @NonNull
    private int quantity;

    private int minimal_quantity = 1;

    @NonNull
    private double price;

    private double wholesale_price;

    @NonNull
    private boolean active;

    @NonNull
    private String redirect_type = "404";

    @NonNull
    private int pack_stock_type = 3;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_add = new Date();

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_upd = new Date();
}
