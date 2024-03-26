package com.example.jobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAll(){
        return companyService.getAll();
    }

    @GetMapping(path = "/{companyId}")
    public Company getCompanyById(@PathVariable(name = "companyId") int companyId){
        return companyService.getCompanyById(companyId);
    }

    @PostMapping
    public String createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return "OK!";
    }

    @PutMapping(path = "/{companyId}")
    public Company updateCompany(@PathVariable(name = "companyId") int companyId, @RequestBody Company updatedCompany){
        return companyService.updateCompany(companyId, updatedCompany);
    }

    @DeleteMapping(path = "/{companyId}")
    public Company deleteCompanyById(@PathVariable int companyId){
        return companyService.deleteCompanyById(companyId);
    }
}
