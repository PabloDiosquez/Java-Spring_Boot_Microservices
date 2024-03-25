package com.example.jobapp.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Job {
    private int jobId;
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;

}
