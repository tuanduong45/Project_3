package com.example.Project_3.sevice.user.impl;


import com.example.Project_3.constant.message.errorKey.ErrorKey;
import com.example.Project_3.constant.message.messageConst.MessageConst;
import com.example.Project_3.dtos.user.IGetListUser;
import com.example.Project_3.dtos.user.UserCreateDTO;
import com.example.Project_3.dtos.user.UserUpdateDTO;
import com.example.Project_3.entities.department.Department;
import com.example.Project_3.entities.importReceipt.ImportReceipt;
import com.example.Project_3.entities.requestReceipt.RequestReceipt;
import com.example.Project_3.entities.role.Role;
import com.example.Project_3.entities.users.User;
import com.example.Project_3.entities.users.UserRole;
import com.example.Project_3.enums.identityType.IdentityTypeEnum;
import com.example.Project_3.enums.user.UserStatusEnum;
import com.example.Project_3.exceptions.exceptionFactory.ExceptionFactory;
import com.example.Project_3.repositories.department.DepartmentRepository;
import com.example.Project_3.repositories.role.RoleRepository;
import com.example.Project_3.repositories.user.UserRepository;
import com.example.Project_3.repositories.userRole.UserRoleRepository;
import com.example.Project_3.sevice.user.UserService;

import com.example.Project_3.utils.auth.AuthUtils;
import com.example.Project_3.utils.auth.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
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

    @Autowired
    private  PasswordEncoder passwordEncoder;
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
        IdentityTypeEnum identityTypeEnum = IdentityTypeEnum.typeOf(userCreateDTO.getIdentityTypeName());
        if(identityTypeEnum != null){
            int value = identityTypeEnum.getValue();
            user.setIdentityType(value);
        }
        Optional<Department> department = departmentRepository.findById(userCreateDTO.getDepartmentID());
        user.setDepartment(department.get());
        user.setStatus(UserStatusEnum.ACTIVE.getStatus());
        generateUserNamePassword(user);
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

    public void generateUserNamePassword(User user){
        StringBuilder userNameBuilder = new StringBuilder();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String[] firstNameArr = firstName.split(" ");
        if(firstNameArr.length > 0) {
           userNameBuilder.append(StringUtils.convertVietnameseToEng(lastName).toLowerCase());
           for(int i = 0 ; i < firstNameArr.length  ; i++){
               userNameBuilder.append(StringUtils.convertVietnameseToEng(firstNameArr[i]).toLowerCase().toLowerCase().charAt(0));
           }
        }
        Integer userLikeExisted = userRepository.countByUserName(userNameBuilder.toString());
        userNameBuilder.append(userLikeExisted == 0 ? "" : String.valueOf(userLikeExisted+1));
        user.setUserName(userNameBuilder.toString());
        String password =user.getUserName() + "@";
        user.setPassword(passwordEncoder.encode(password));

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
        // cập nhật identityType
        IdentityTypeEnum identityTypeEnum = IdentityTypeEnum.typeOf(updateDTO.getIdentityTypeName());
        if(identityTypeEnum != null){
            int value = identityTypeEnum.getValue();
            user.get().setIdentityType(value);
        }
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
        if(user.isPresent()){
            for(RequestReceipt requestReceipt : user.get().getRequestReceipts()){
                requestReceipt.setUser(null);
            }
            user.get().getRequestReceipts().clear();
            for(ImportReceipt importReceipt : user.get().getImportReceipts()){
                importReceipt.setUser(null);
            }
            user.get().getImportReceipts().clear();
            userRepository.deleteById(user.get().getId());
        }
    }

    @Override
    public List<IGetListUser> getListUser(String code, String name,String phoneNumber,
                                          String email, Long departmentId, Long roleId) {

        return userRepository.getListUser(code,name,phoneNumber,email,departmentId,roleId);

    }

    @Override
    public void switchUserStatus(Long userId) {
        userRepository.switchUserStatus(userId);

    }

    @Override
    public User getCurrentUser() {
        return AuthUtils.getCurrentUser();
    }


}


