package com.example.jobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping(path = "/jobs/{jobId}")
    public Job getJobById(@PathVariable(name = "jobId") int jobId){
        Job job = jobService.getJobById(jobId);
        return job != null ? job : new Job();
    }

    @GetMapping(path = "/jobs")
    public List<Job> getAll(){
        return jobService.findAllJobs();
    }

    @PostMapping(path = "/jobs")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully";
    }
}
