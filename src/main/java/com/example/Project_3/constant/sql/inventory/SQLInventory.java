package com.example.Project_3.constant.sql.inventory;



public class SQLInventory {
    public static final String GET_LIST_INVENTORY =
            "SELECT d.code as code, d.\"name\" as name , SUM(i.quantity) as totalQuantity,u.unit_name as unitName ," +
                    " i.drug_id as drugId  FROM drug as d \n" +
                    "JOIN inventory as i ON d.\"id\" = i.drug_id \n" +
                    "JOIN unit as u ON u.\"id\" = d.unit_id\n" +
                    "WHERE (:name = '' OR d.\"name\" ILIKE ('%' || :name || '%')) " +
                    "AND (:code = '' OR d.code = :code) \n" +
                    "GROUP BY code,\"name\",unit_name,drugId";

    public static final String GET_LIST_INVENTORY_DETAIL =

        "SELECT i.produce_batch_number as produceBatchNumber , d.expiry_date as expiryDate" +
                ",i.quantity as quantity , d.price as price FROM inventory as i " +
                "LEFT JOIN drug as d ON i.drug_id = d.id " +
                "WHERE (:id = -1 OR i.drug_id = :id )" ;
}
