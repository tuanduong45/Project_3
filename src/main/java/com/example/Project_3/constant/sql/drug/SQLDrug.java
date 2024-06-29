package com.example.Project_3.constant.sql.drug;

public  class SQLDrug {
    public static final String GET_LIST_DRUG =
            "SELECT  d.id as id , dg.drug_group_name as drugGroupName ,d.active_substance aS activeSubstance ,d.code as code,d.\"name\" as name\n" +
                    ",d.registration_number aS registrationNumber ,d.\"usage\" aS usage ,d.price aS price ," +
                    "d.produce_country aS produceCountry,d.dosage_form as dosageForm , u.unit_name as unitName , " +
                    "d.dosage as dosage , d.expiry_date as expiryDate , d.\"content\" as content , " +
                    "d.packing as packing , d.drug_interaction as drugInteraction , d.contraindication as contraindication , " +
                    "CASE \n" +
                    "\tWHEN d.status = 0 THEN 'Đang hoạt động'\n" +
                    "\tWHEN d.status = 1 THEN 'Không hoạt động'\n" +
                    "\tWHEN d.status = 2 THEN 'Hết hạn sử dụng'\n" +
                    "\tWHEN d.status = 3 THEN 'Hết hàng' \n" +
                    "\tELSE ''\n" +
                    "END AS drugStatus " +
                    "FROM drug aS d " +
                    "RIGHT JOIN drug_group as dg ON  dg.\"id\"= d.drug_group_id \n" +
                    "LEFT JOIN unit u ON d.unit_id = u.\"id\"\n" +
                    "WHERE (:drugGroupId = -1 OR d.drug_group_id = :drugGroupId) AND " +
                    "(:name = '' OR d.\"name\" ILIKE ('%' || :name || '%'))\n" +
                    "ORDER BY dg.drug_group_name ";

    public static final String GET_LIST_DRUG_ID_CODE_NAME =
            "SELECT d.id as id , d.code as code , d.\"name\" as name FROM drug as d ORDER BY id";


}
