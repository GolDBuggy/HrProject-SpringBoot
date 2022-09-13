package com.kilic.hrproject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "profile_image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @Column(name = "image_id")
    private String id;

    @Column(name = "image_path")
    private String path;

    @OneToOne(mappedBy = "image")
    private Profile profile;
}
