package com.example.Project_3.constant.sql.department;

public class SQLDepartment {
    public static final String GET_LIST_DEPARTMENT =
            "SELECT d.id as id , d.code as code , d.\"name\" AS \"name\" , " +
                    "d.email AS email , " + "d.phone_number as phoneNumber FROM \"department\" AS d \n" +
                    "WHERE (d.id = :id OR :id = -1) " +
                    "AND (d.code = :code OR :code = '') " +
                    "AND (d.\"name\" = :name OR :name ='') " +
                    "AND (d.email= :email OR :email ='')\n" +
                    "AND (d.phone_number= :phoneNumber OR :phoneNumber='')";


}
