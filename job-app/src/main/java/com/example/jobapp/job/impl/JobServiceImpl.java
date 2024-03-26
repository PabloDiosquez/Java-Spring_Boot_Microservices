package com.example.jobapp.job.impl;

import com.example.jobapp.job.Job;
import com.example.jobapp.job.JobRepository;
import com.example.jobapp.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    private final List<Job> jobs = new ArrayList<>();
    private final Job NOT_FOUND = new Job(
            -1,
            "Error",
            "Error",
            -1,
            -1,
            "Error"
    );

    public List<Job> findAllJobs(){
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(int jobId) {
        return jobRepository.findById(jobId).orElse(NOT_FOUND);
    }

    public void createJob(Job job){
        assert job != null;
        jobRepository.save(job);
    }

    @Override
    public Job deleteJobById(int jobId) {
        Job deletedJob = getJobById(jobId);
        jobRepository.deleteById(jobId);
        return deletedJob;
    }

    @Override
    public boolean updateJob(int jobId, Job job) {
        Job oldJob = getJobById(jobId);
        if(oldJob.getJobId() != -1){
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}
