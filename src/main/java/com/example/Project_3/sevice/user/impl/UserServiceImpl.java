package com.example.Project_3.sevice.user.impl;


import com.example.Project_3.constant.message.errorKey.ErrorKey;
import com.example.Project_3.constant.message.messageConst.MessageConst;
import com.example.Project_3.dtos.user.IGetListUser;
import com.example.Project_3.dtos.user.UserCreateDTO;
import com.example.Project_3.dtos.user.UserUpdateDTO;
import com.example.Project_3.entities.department.Department;
import com.example.Project_3.entities.role.Role;
import com.example.Project_3.entities.users.User;
import com.example.Project_3.entities.users.UserRole;
import com.example.Project_3.exceptions.exceptionFactory.ExceptionFactory;
import com.example.Project_3.repositories.department.DepartmentRepository;
import com.example.Project_3.repositories.role.RoleRepository;
import com.example.Project_3.repositories.user.UserRepository;
import com.example.Project_3.repositories.userRole.UserRoleRepository;
import com.example.Project_3.sevice.user.UserService;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DepartmentRepository departmentRepository ;
    @Autowired
    private ExceptionFactory exceptionFactory ;
    @Autowired
    private UserRoleRepository userRoleRepository ;
    private final Set<Role> roleSet = new HashSet<>();

    @Override
    public void addRoleToUser(String userName, String roleName) {
        Optional<User> user = userRepository.findByUserName(userName);
        Role role = roleRepository.findByName(roleName);
        user.get().getRoles().add(role);
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void encoderPassword(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        user.get().setPassword(BCrypt.hashpw(user.get().getPassword(), BCrypt.gensalt()));
    }

    @Override
    public void createUser(UserCreateDTO userCreateDTO) {
        if(!departmentRepository.existsById(userCreateDTO.getDepartmentID())){
            throw exceptionFactory.resourceNotFoundException(ErrorKey.Department.NOT_FOUND_ERROR_CODE, MessageConst.RESOURCE_NOT_FOUND,
                    MessageConst.Resources.DEPARTMENT,ErrorKey.Department.ID);
        }
        User user = new User();
        BeanUtils.copyProperties(userCreateDTO,user);
        user.setCode(generateUserCode());
        user.setIdentityType(userCreateDTO.getIdentityTypeName().getValue());
        Optional<Department> department = departmentRepository.findById(userCreateDTO.getDepartmentID());
        user.setDepartment(department.get());
        Long userId = userRepository.save(user).getId();
        List<UserRole> lstUserRole = userCreateDTO.getLstRoleId().stream().map(roleId -> new UserRole(userId, roleId)).toList();
        userRoleRepository.saveAll(lstUserRole);

    }

    @Override
    public String generateUserCode() {
        String baseCode = "USR";
        Random random = new Random();
        String generatedCode = baseCode + (random.nextInt(100000) + 100000);
        while (userRepository.existsByCode(generatedCode)){
            generatedCode = baseCode + (random.nextInt(100000) + 100000);
        }
        return generatedCode;

    }

    @Override
    @Transactional
    public void updateUser(UserUpdateDTO updateDTO, Long id) {
        if(!userRepository.existsById(id)){
            throw exceptionFactory.resourceNotFoundException(ErrorKey.User.NOT_FOUND_ERROR_CODE
                    ,MessageConst.RESOURCE_NOT_FOUND,
                    MessageConst.Resources.DEPARTMENT ,ErrorKey.User.ID);
        }
        Optional<User> user = userRepository.findById(id);
        BeanUtils.copyProperties(updateDTO,user.get());
        // cập nhật department
        Optional<Department> department = departmentRepository.findById(updateDTO.getDepartmentID());
        user.get().setDepartment(department.get());
        userRepository.save(user.get());

        // cập nhật user role
        List<UserRole> lstCurrentUserRoles = userRoleRepository.findAllByUserId(id);
        userRoleRepository.deleteAll(lstCurrentUserRoles);
        List<UserRole> lstNewUserRoles = updateDTO.getLstRoleId().stream().map(roleId->new UserRole(id,roleId)).toList();
        userRoleRepository.saveAll(lstNewUserRoles);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
    }

    @Override
    public List<IGetListUser> getListUser(String code, String name,String phoneNumber,
                                          String email, Long departmentId, Long roleId) {

        return userRepository.getListUser(code,name,phoneNumber,email,departmentId,roleId);

    }


}


