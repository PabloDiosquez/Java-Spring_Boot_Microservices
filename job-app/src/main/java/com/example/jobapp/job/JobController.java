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
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    @PostMapping(path = "/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping(path = "jobs/delete/{jobId}")
    public ResponseEntity<Job> deleteJobById(@PathVariable(name = "jobId") int jobId){
        return new ResponseEntity<>(jobService.deleteJobById(jobId), HttpStatus.NO_CONTENT);
    }
}
