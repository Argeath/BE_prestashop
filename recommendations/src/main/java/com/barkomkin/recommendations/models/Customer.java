package com.barkomkin.recommendations.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "ps_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_customer;

    private int id_gender = 1;

    private int id_default_group = 3;

    private int id_lang = 1;

    private int id_risk = 0;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    @NonNull
    private String email;

    @NonNull
    private String passwd = "555fd209288b8226400dbe8d1761571e";

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_add = new Date();

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_upd = new Date();

}
