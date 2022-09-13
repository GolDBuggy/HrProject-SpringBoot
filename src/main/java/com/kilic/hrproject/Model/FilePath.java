package com.kilic.hrproject.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "file_path")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilePath {

    @Id
    @Column(name = "file_id")
    private String id;

    @Column(name = "cv_path")
    private String path;

    @OneToOne(mappedBy = "path")
    private Candidate candidate;
}
