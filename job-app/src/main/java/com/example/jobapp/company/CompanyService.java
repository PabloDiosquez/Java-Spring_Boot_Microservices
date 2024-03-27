package com.example.jobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company getCompanyById(int companyId);

    void addCompany(Company company);

    Company updateCompany(int companyId, Company updatedCompany);

    Company deleteCompanyById(int companyId);
}
