package com.example.jobapp.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private final List<Job> jobs = new ArrayList<>();

    @GetMapping(path = "/jobs")
    public List<Job> getAll(){
        return jobs;
    }

    @PostMapping(path = "/jobs")
    public String saveJob(@RequestBody Job job){
        jobs.add(job);
        return "OK";
    }
}
