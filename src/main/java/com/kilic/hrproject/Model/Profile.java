package com.kilic.hrproject.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name = "graduation")
    private String graduation;

    @Column(name = "school")
    private String school;

    @Column(name = "department")
    private String department;

    @Column(name = "certificate")
    private String certificate;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
