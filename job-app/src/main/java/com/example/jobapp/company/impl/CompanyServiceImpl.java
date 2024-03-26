package com.example.jobapp.company.impl;

import com.example.jobapp.company.Company;
import com.example.jobapp.company.CompanyRepository;
import com.example.jobapp.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() {
        return null;
    }

    @Override
    public Company getCompanyById(int companyId) {
        return null;
    }

    @Override
    public void createCompany(Company company) {

    }

    @Override
    public Company updateCompany(int companyId, Company updatedCompany) {
        return null;
    }

    @Override
    public Company deleteCompanyById(int companyId) {
        return null;
    }
}
