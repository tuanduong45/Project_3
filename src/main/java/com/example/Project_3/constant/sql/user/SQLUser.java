package com.example.Project_3.constant.sql.user;

public class SQLUser {
    public static final String GET_LIST_USER =
            "SELECT DISTINCT u.\"id\" as id , u.code , concat(u.first_name , ' ', u.last_name ) as name, " +
                    "u.birth_date AS birthDate ,u.phone_number AS phoneNumber,u.email , \n" +
                    "CASE \n" +
                    "\tWHEN u.identity_type = 0 THEN 'Chứng minh nhân dân'\n" +
                    "\tWHEN u.identity_type = 1 THEN 'Căn cước công dân'\n" +
                    "\tWHEN u.identity_type = 2 THEN 'Hộ chiếu'\n" +
                    "\tELSE ''\n" +
                    "END AS identityType,\n" +
                    "u.identification_number as identificationNumber\n" +
                    " ,d.\"name\" AS departmentName, r.\"name\" as roleName\n" +
                    "\n" +
                    " FROM \"users\" AS u \n" +
                    " LEFT JOIN department AS d ON  u.department_id = d.id \n" +
                    " JOIN \"users-roles\" AS ur ON ur.user_id = u.\"id\" \n" +
                    " JOIN \"role\" AS r ON r.\"id\" = ur.role_id\n" +
                    " WHERE (:name = '' OR concat(u.first_name,' ',u.last_name) ILIKE ('%' || :name || '%'))" +
                    " AND (:code =  '' OR u.code = :code ) \n" +
                    " AND (:phone = '' OR u.phone_number = :phone )\n" +
                    " AND (:email = '' OR u.email ILIKE ('%' || :email || '%')) " +
                    " AND (:departmentId = -1 OR u.department_id = :departmentId) " +
                    " AND (:roleId = -1 OR ur.role_id = :roleId)";
}
