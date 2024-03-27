package com.example.jobapp.company;

import com.example.jobapp.job.Job;
import com.example.jobapp.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    private String name;
    private String description;
    @OneToMany
    private List<Job> jobs;
    @OneToMany
    private List<Review> reviews;
}
