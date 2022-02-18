package com.hunko.email.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "primaryEmail")
        },
        indexes = {
                @Index(name = "user_email_password_index",
                        columnList = "primaryEmail, password")
        }
)
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
