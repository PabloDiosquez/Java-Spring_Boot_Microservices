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

    private final Job NOT_FOUND = new Job(
            -1,
            "Error",
            "Error",
            -1,
            -1,
            "Error"
    );

    public List<Job> findAllJobs(){
        return jobs;
    }

    @Override
    public Job getJobById(int jobId) {
        Job jobFound = null;
        for (Job job: jobs) {
            if(job.getJobId() == jobId){
                jobFound = job;
            }
        }
        return jobFound != null ? jobFound : NOT_FOUND;
    }

    public void createJob(Job job){
        assert job != null;
        job.setJobId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job deleteJobById(int jobId) {
        int index = jobs.indexOf(getJobById(jobId));
        return index != -1 ? jobs.remove(index) : NOT_FOUND;
    }

    @Override
    public boolean updateJob(int jobId, Job job) {
        int index = jobs.indexOf(getJobById(jobId));
        if(index != -1){
            job.setJobId(jobId);
            jobs.set(index, job);
            return true;
        }
        return false;
    }

}
