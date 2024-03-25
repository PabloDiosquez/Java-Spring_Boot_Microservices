package com.example.jobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping(path = "/jobs/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable(name = "jobId") int jobId){
        Job job = jobService.getJobById(jobId);
        return job.getJobId() != -1 ? new ResponseEntity<>(job, HttpStatus.OK) :
                new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/jobs")
    public ResponseEntity<List<Job>> getAll(){
        return new ResponseEntity<>(jobService.findAllJobs(), HttpStatus.OK);
    }

    @PostMapping(path = "/jobs")
    public ResponseEntity<HttpStatus> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
