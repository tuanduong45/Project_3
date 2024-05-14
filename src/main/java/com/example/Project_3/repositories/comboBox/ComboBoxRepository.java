package com.example.Project_3.repositories.comboBox;

import com.example.Project_3.constant.sql.comboBox.SQLComboBox;
import com.example.Project_3.dtos.common.ICommonIdCodeName;
import com.example.Project_3.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComboBoxRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,value = SQLComboBox.GET_COMBOBOX_DEPARTMENT)
    List<ICommonIdCodeName> getComboBoxDepartment();

    @Query(nativeQuery = true,value = SQLComboBox.GET_COMBOBOX_ROLE)
    List<ICommonIdCodeName> getComboBoxRole();
}
