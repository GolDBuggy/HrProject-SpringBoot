package com.kilic.hrproject.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "members")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member{

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

    @Column(name = "roles")
    private String roles;

    @Column(name = "active")
    private boolean active;

    @OneToOne(mappedBy = "member")
    private Profile profile;



}
