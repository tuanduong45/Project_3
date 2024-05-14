package com.example.Project_3.repositories.userRole;

import com.example.Project_3.constant.sql.user.SQLUser;
import com.example.Project_3.constant.sql.userRole.SQLUserRole;
import com.example.Project_3.dtos.user.IGetListUser;
import com.example.Project_3.entities.users.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    List<UserRole> findAllByUserId(Long id);
    @Query(nativeQuery = true , value = SQLUserRole.GET_LIST_USER_ID)
    Set<Long> getUserIdByRoleId(@Param("lstRoleId") Set<Long> lstRoleId);


}
