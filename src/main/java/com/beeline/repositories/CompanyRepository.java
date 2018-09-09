package com.beeline.repositories;

import com.beeline.models.Company;
import com.beeline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
