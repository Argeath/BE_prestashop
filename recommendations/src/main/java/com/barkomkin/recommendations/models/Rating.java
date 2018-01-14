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
@Table(name = "ps_product_comment")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product_comment;

    @NonNull
    private int id_product;

    @NonNull
    private int id_customer;

    @NonNull
    private String title = ".";

    @NonNull
    private String content = ".";

    @NonNull
    private String customer_name;

    @NonNull
    private float grade;

    @NonNull
    private int validate = 0;

    @NonNull
    private int deleted = 0;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_add = new Date();
}
