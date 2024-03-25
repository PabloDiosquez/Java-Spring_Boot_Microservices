package com.example.jobapp.job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    private final List<Job> jobs = new ArrayList<>();

    public List<Job> findAllJobs(){
        return jobs;
    }

    public void createJob(Job job){
        jobs.add(job);
    }
}
