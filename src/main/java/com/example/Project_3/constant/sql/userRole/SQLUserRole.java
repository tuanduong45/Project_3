package com.example.Project_3.constant.sql.userRole;

public class SQLUserRole {
    // lấy danh sách UserId từ bảng uses-roles bằng roleId
    public static final String GET_LIST_USER_ID =
            "SELECT ur.user_id FROM \"users-roles\" AS ur " +
                    "WHERE (ur.role_id IN :lstRoleId)";
}
