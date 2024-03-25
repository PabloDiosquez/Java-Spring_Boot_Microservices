package com.example.jobapp.job;

import java.util.List;
public interface JobService {
    List<Job> findAllJobs();

    Job getJobById(int jobId);
    void createJob(Job job);
}
