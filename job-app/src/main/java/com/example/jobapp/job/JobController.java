package com.example.jobapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/jobs/")
public class JobController {
    @Autowired
    private JobService jobService;

    //@RequestMapping(value = "/{jobId}", method = RequestMethod.GET)
    @GetMapping(path = "/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable(name = "jobId") int jobId){
        Job job = jobService.getJobById(jobId);
        return job.getJobId() != -1 ? new ResponseEntity<>(job, HttpStatus.OK) :
                new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAll(){
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{jobId}")
    public ResponseEntity<String> deleteJobById(@PathVariable(name = "jobId") int jobId){
        Job job = jobService.deleteJobById(jobId);
        return job.getJobId() != -1 ? new ResponseEntity<>("Job deleted successfully", HttpStatus.OK)
                : new ResponseEntity<>("Job NOT Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable(name = "jobId") int jobId, @RequestBody Job updatedJob){
        return jobService.updateJob(jobId, updatedJob) ? new ResponseEntity<>("Jod updated successfully", HttpStatus.OK)
                : new ResponseEntity<>("Job NOT Found", HttpStatus.NOT_FOUND);
    }
}
