package com.example.Project_3.utils.auth;


import com.example.Project_3.entities.users.User;
import com.example.Project_3.enums.role.RoleEnum;

import com.sun.security.auth.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class AuthUtils {
    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };

//    public static String getIpAddress(HttpServletRequest request){
//        for(String header : HEADERS_TO_TRY){
//            String ipAddress = request.getHeader(header);
//            if(Objects.nonNull(ipAddress) && StringUtils.hasText(ipAddress) && !"unknown".equalsIgnoreCase(ipAddress)){
//                return ipAddress;
//            }
//        }
//        return request.getRemoteAddr();
//    }
     public static Boolean isHospitalManager(){
         try {
             UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
             return userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                     .collect(Collectors.toList()).contains(RoleEnum.HOSPITAL_MANAGER.getRoleName());
         } catch (Exception ex){
             ex.printStackTrace();
             log.error("Check departmentManager error");
             return false;
         }

     }
     // get current user
    public static User getCurrentUser() {
        try {
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception ex) {
            log.error("Get current user error");
            return null;
        }
    }

    // get current user id
    public static Long getCurrentUserId() {
        try {
            User currentUser = getCurrentUser();
            return Objects.nonNull(currentUser) ? currentUser.getId() : null;
        } catch (Exception ex) {
            log.error("Get current user id error");
            return null;
        }
    }

}
