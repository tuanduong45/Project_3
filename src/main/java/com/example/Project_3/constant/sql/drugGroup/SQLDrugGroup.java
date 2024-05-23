package com.example.Project_3.constant.sql.drugGroup;

public class SQLDrugGroup {
    public static final String GET_DRUG_GROUP_NAME_BY_ID =
            "SELECT dg.drug_group_name  FROM drug_group dg WHERE (:drugGroupId = -1 OR dg.\"id\"= :drugGroupId) ";

    public static final String GET_ID_FROM_DRUG_GROUP_NAME =
            "SELECT id  FROM drug_group as dg WHERE (:drugGroupName = '' or dg.drug_group_name = TRIM(:drugGroupName ))" ;

    public static final String GET_DRUG_GROUP_DESCRIBE_FROM_NAME =
            "SELECT drug_group_describe  FROM drug_group as dg WHERE (:drugGroupName = '' or dg.drug_group_name = TRIM(:drugGroupName))";
}
