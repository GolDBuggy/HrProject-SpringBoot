package com.kilic.hrproject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "members")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_surname")
    private String surname;

    @Column(name = "member_password")
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "roles")
    private String roles;

    @Column(name = "active")
    private boolean active;

}
