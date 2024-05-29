package com.example.Project_3.constant.sql.supplier;

public class SQLSupplier {

    public static final String GET_LIST_SUPPLIER =
            "SELECT s.\"id\" as id , s.\"name\" as \"name\" , s.phone_number as phoneNumber , \n" +
                    "s.address as address , s.email as email , s.representative_name as representativeName, \n" +
                    "s.tax_code as taxCode FROM supplier as s \n" +
                    "WHERE (:name = '' or  s.\"name\" ILIKE ('%' || :name || '%') ) AND " +
                    " (:taxCode = '' or s.tax_code = :taxCode )";


    public static final String GET_LIST_ID_TAXCODE_NAME =
            "SELECT s.\"id\" as id, s.\"name\" as name , s.tax_code as taxCode FROM \"supplier\" as s ORDER BY id";
}
