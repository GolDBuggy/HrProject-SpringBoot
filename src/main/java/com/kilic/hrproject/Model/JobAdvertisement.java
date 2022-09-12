package com.kilic.hrproject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "job_advertisement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long id;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "job_grade")
    private String jobGrade;

    @Column(name = "expected_salary")
    private String expectedSalary;

    @Column(name = "application_deadline")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "application_list",joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id"))
    private List<Candidate> candidates;
}
