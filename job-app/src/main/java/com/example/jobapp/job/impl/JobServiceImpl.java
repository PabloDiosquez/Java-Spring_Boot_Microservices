package com.example.jobapp.job.impl;

import com.example.jobapp.job.Job;
import com.example.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final List<Job> jobs = new ArrayList<>();
    private int nextId = 1;

    public List<Job> findAllJobs(){
        return jobs;
    }

    public void createJob(Job job){
        assert job != null;
        job.setJobId(nextId++);
        jobs.add(job);
    }

}
