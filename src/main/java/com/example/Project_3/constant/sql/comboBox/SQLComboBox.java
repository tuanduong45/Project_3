package com.example.Project_3.constant.sql.comboBox;

public class SQLComboBox {
    public static final String GET_COMBOBOX_DEPARTMENT =
            "SELECT id as id , code as code , name as name FROM department as d   ORDER BY id" ;

    public static final String GET_COMBOBOX_ROLE =
            "SELECT id as id , name as name , code as code FROM \"role\" ORDER BY \"id\" ";

}
