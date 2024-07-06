package com.example.Project_3.sevice.user;

import com.example.Project_3.dtos.user.IGetListUser;
import com.example.Project_3.dtos.user.UserCreateDTO;
import com.example.Project_3.dtos.user.UserUpdateDTO;
import com.example.Project_3.entities.users.User;
import com.example.Project_3.enums.user.UserStatusEnum;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public interface UserService {
//    Set<String> getLstUserFeaturesByRoles(Set<String> roles);
    void addRoleToUser(String userName , String roleName);
    User saveUser(User user);

    void encoderPassword(String userName);
    void createUser(UserCreateDTO userCreateDTO);

    String generateUserCode();
    void updateUser(UserUpdateDTO updateDTO , Long id);
    void deleteUser(Long id);
    List<IGetListUser> getListUser( String code , String name, String phoneNumber,
                                   String email, Long departmentId , Long roleId);

    void switchUserStatus(Long userId);

    User getCurrentUser();

    

}
