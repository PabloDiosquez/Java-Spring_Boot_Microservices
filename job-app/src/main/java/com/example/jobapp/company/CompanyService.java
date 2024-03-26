package com.example.jobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();

    Company getCompanyById(int companyId);

    void createCompany(Company company);

    Company updateCompany(int companyId, Company updatedCompany);

    Company deleteCompanyById(int companyId);
}
