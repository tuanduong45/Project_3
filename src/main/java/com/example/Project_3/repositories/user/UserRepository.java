package com.example.Project_3.repositories.user;

import com.example.Project_3.constant.sql.user.SQLUser;
import com.example.Project_3.dtos.user.IGetListUser;
import com.example.Project_3.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Boolean existsByCode(String code);
    @Query(nativeQuery = true , value = SQLUser.GET_LIST_USER)
    List<IGetListUser> getListUser(@Param("code") String code, @Param("name") String name,
                                   @Param("phone") String phoneNumber, @Param("email") String email,
                                    @Param("departmentId") Long departmentId, @Param("roleId") Long roleId);


}
