package com.example.Project_3.constant.sql.drug;

public  class SQLDrug {
    public static final String GET_LIST_DRUG =
            "SELECT dg.drug_group_name as drugGroupName , d.active_substance as activeSubstance ,d.code as code," +
                    "d.\"name\" as name\n" +
                    ",d.registration_number aS registrationNumber ,d.\"usage\" aS usage ,d.price aS price " +
                    ",d.produce_country aS produceCountry\n" +
                    ", dg.drug_group_code as drugGroupCode , u.unit_name as unitName FROM drug aS d \n" +
                    "RIGHT JOIN drug_group as dg ON  dg.\"id\"= d.drug_group_id \n" +
                    "LEFT JOIN unit u ON d.unit_id = u.\"id\"\n" +
                    "WHERE (:drugGroupId = -1 OR d.drug_group_id = :drugGroupId) AND " +
                    "(:name = '' OR d.\"name\" ILIKE ('%' || :name || '%'))\n" +
                    "ORDER BY dg.drug_group_name ";
}
