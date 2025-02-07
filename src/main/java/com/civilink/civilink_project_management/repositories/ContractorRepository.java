package com.civilink.civilink_project_management.repositories;

import com.civilink.civilink_project_management.entities.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}
