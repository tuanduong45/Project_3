package com.example.Project_3.repositories.drugGroup;

import com.example.Project_3.entities.drugGroup.DrugGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugGroupRepository extends JpaRepository<DrugGroup,Long> {
}
