package com.kilic.hrproject.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "candidate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long id;

    @Column(name = "candidate_name")
    private String name;

    @Column(name = "candidate_surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "job_experiance")
    private int jobExperiance;

    @Column(name = "applied")
    private boolean applied;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "application_list",joinColumns = @JoinColumn(name = "candidate_id"),
                            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private List<JobAdvertisement> jobAdvertisements;




}
