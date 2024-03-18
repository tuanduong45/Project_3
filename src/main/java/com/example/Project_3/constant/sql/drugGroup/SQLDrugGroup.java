package com.example.Project_3.constant.sql.drugGroup;

public class SQLDrugGroup {
    public static final String GET_DRUG_GROUP_NAME_BY_ID =
            "SELECT dg.drug_group_name  FROM drug_group dg WHERE (:drugGroupId = -1 OR dg.\"id\"= :drugGroupId) ";
}
