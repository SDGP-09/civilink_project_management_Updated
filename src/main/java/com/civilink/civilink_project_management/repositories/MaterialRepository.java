package com.civilink.civilink_project_management.repositories;

import com.civilink.civilink_project_management.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {
}
