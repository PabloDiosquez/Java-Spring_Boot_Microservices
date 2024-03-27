package com.example.jobapp.company.impl;

import com.example.jobapp.company.Company;
import com.example.jobapp.company.CompanyRepository;
import com.example.jobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(int companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Override
    public void addCompany(Company company) {
        assert company != null;
        companyRepository.save(company);
    }

    @Override
    public Company updateCompany(int companyId, Company updatedCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if(optionalCompany.isPresent()){
            updatedCompany.setCompanyId(companyId);
            companyRepository.save(updatedCompany);
            return updatedCompany;
        }
        return null;
    }

    @Override
    public Company deleteCompanyById(int companyId) {
        if(companyRepository.existsById(companyId)){
            Company company = getCompanyById(companyId);
            companyRepository.deleteById(companyId);
            return company;
        }
        return null;
    }
}
