package com.example.jobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAll(){
        return new ResponseEntity<>(companyService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable(name = "companyId") int companyId){
        Company company = companyService.getCompanyById(companyId);
        return company!= null
                ? new ResponseEntity<>(company, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        try {
            companyService.createCompany(company);
            return new ResponseEntity<>("Company added successfully", HttpStatus.OK);
        } catch (AssertionError ex){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable(name = "companyId") int companyId, @RequestBody Company updatedCompany){
        Company company = companyService.getCompanyById(companyId);
        return company != null
                ? new ResponseEntity<>(companyService.updateCompany(companyId, updatedCompany), HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{companyId}")
    public ResponseEntity<Company> deleteCompanyById(@PathVariable int companyId){
        Company company = companyService.getCompanyById(companyId);
        return company != null
                ? new ResponseEntity<>(companyService.deleteCompanyById(companyId), HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
