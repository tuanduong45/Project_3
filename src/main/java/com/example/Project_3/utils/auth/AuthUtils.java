package com.example.Project_3.utils.auth;


import com.example.Project_3.enums.role.RoleEnum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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
}
