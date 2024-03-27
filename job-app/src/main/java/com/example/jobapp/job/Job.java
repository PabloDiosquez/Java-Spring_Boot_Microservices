package com.example.jobapp.job;

import com.example.jobapp.company.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
//@Table(name = "job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;
    @ManyToOne
    private Company company;

}
