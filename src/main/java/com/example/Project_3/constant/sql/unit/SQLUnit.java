package com.example.Project_3.constant.sql.unit;

public class SQLUnit {

    public static final String GET_LIST_UNIT =
            "SELECT u.\"id\" , u.unit_name as unitName , conversion_rule as conversionRule FROM unit as u ORDER BY id";
}
