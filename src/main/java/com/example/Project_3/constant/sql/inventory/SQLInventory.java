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


    public static final String GET_LIST_DRUG_BE_WARNED =
            "SELECT (CAST (i.expiry_date as DATE) - CURRENT_DATE) as totalDay, d.\"name\" as drugName , i.drug_id as drugId,  \n" +
                    "dw.produce_batch_number as produceBatchNumber\n" +
                    " FROM inventory as i JOIN drug_warning as dw ON dw.produce_batch_number = i.produce_batch_number \n" +
                    "JOIN  drug as d on d.id = i.drug_id\n" +
                    "\tWHERE (CAST(i.expiry_date as DATE) - CURRENT_DATE ) <= dw.expiry_before_day";

    public static final String GET_DRUG_MIN_EXPIRY_MAX_QUANTITY =
            "SELECT id , quantity,produce_batch_number as produceBatchNumber " +
                    "FROM inventory  WHERE (drug_id = :id) ORDER BY expiry_date , quantity DESC";

    public static final String GET_REPORT_INVENTORY =
            "SELECT dg.drug_group_name as drugGroupName , SUM(i.quantity) as quantity FROM inventory as i \n" +
                    "JOIN drug as d ON i.drug_id = d.id\n" +
                    "JOIN drug_group as dg ON d.drug_group_id = dg.id\n" +
                    "     WHERE CAST(i.expiry_date as DATE) > CURRENT_DATE \n" +
                    "GROUP BY dg.drug_group_name\n" +
                    "ORDER BY quantity";

    public static final String GET_SUMMARIZE_REPORT =
            "SELECT SUM(dir.quantity) AS importQuantity, SUM(rrd.quantity) AS exportQuantity , SUM(i.drug_id) as inventoryQuantity , d.name AS drugName ,d.id AS drugId, u.unit_name as unitName,\n" +
                    "SUM(dir.total_amount) as total\n" +
                    "FROM drug as d \n" +
                    "JOIN drug_import_receipt as dir ON d.id = dir.drug_id \n" +
                    "JOIN request_receipt_drug as rrd ON rrd.drug_id = d.id\n" +
                    "JOIN inventory as i ON i.drug_id = d.id \n" +
                    "JOIN import_receipt as ir ON dir.import_receipt_id = ir.id\n" +
                    "JOIN request_receipt as rr ON rr.id = rrd.request_receipt_id\n" +
                    "JOIN unit as u ON u.\"id\" = d.unit_id\n" +
                    "WHERE " +
                    " (CAST(ir.import_date AS DATE) >= :startDate OR :startDate = CAST ('1970-01-01' as DATE))\n" +
                    " AND (CAST(ir.import_date AS DATE) <= :endDate OR :endDate = CAST ('1970-01-01' as DATE))\n" +
                    " AND (CAST(rr.request_date AS DATE) >= :startDate OR :startDate = CAST ('1970-01-01' as DATE))\n" +
                    " AND (CAST(rr.request_date AS DATE) <= :endDate OR :endDate = CAST ('1970-01-01' as DATE))" +
                    " AND rr.request_status = 3\n" +
                    "AND i.expiry_date >= CURRENT_DATE\n" +
                    "GROUP BY  d.name,d.id , u.unit_name\n" +
                    "ORDER BY d.name";






}
