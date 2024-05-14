package com.example.Project_3.repositories.department;

import com.example.Project_3.constant.sql.department.SQLDepartment;
import com.example.Project_3.dtos.department.GetListDepartment;
import com.example.Project_3.dtos.department.IGetListDepartment;
import com.example.Project_3.entities.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DepartmentRepository extends JpaRepository<Department , Long> {



    @Query(nativeQuery = true , value = SQLDepartment.GET_LIST_DEPARTMENT)
    List<IGetListDepartment> getListDepartment(@Param("id") Long id ,@Param("code") String code,
                                               @Param("email") String email,
                                               @Param("name") String name,
                                               @Param("phoneNumber") String phoneNumber);


    Boolean existsByCode(String code);




}
