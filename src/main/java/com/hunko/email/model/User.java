package com.hunko.email.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "primaryEmail", unique = true, nullable = false)
    private String primaryEmail;
    @Column(name = "password", nullable = false)
    private char[] password;
}
