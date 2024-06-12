package com.example.Project_3.constant.sql.requestReceipt;

public class SQLRequestReceipt {

    public static final String GET_LIST_REQUEST_RECEIPT =
            "SELECT rr.id as id,rr.request_receipt_code as requestReceiptCode , CAST(rr.request_date as DATE) as requestDate, \n" +
                    "concat(u.first_name,' ', u.last_name) as creatorName , d.name as departmentName,\n" +
                    "CASE \n" +
                    "\tWHEN rr.request_status = 1 THEN 'Chờ xác nhận'\n" +
                    "  WHEN rr.request_status = 2 THEN 'Đã hủy'\n" +
                    "\tWHEN rr.request_status = 3 THEN 'Đã xác nhận' \n" +
                    "ELSE '' \n" +
                    "END as requestStatus \n" +
                    "FROM request_receipt as rr \n" +
                    "JOIN users as u ON rr.user_id = u.id \n" +
                    "JOIN department as d ON u.department_id = d.id \n" +
                    "WHERE \n" +
                    "(rr.request_status = :status OR :status = -1 )\n" +
                    "AND (rr.request_receipt_code = :code OR :code = '' )\n" +
                    "AND (CAST(rr.request_date as DATE) >= :startDate OR :startDate = CAST ('1970-01-01' as DATE) ) \n" +
                    "AND (CAST(rr.request_date as DATE) <= :endDate OR :endDate = CAST ('1970-01-01' as DATE)) ";


    public static final String GET_LIST_DRUG_BY_REQUEST_RECEIPT_ID =
            "SELECT d.code as drugCode , d.name as drugName , CAST(d.expiry_date as DATE) as expiryDate  \n" +
                    ", un.unit_name as unitName , rrd.quantity as quantity  \n" +
                    "FROM request_receipt_drug as rrd \n" +
                    "     JOIN request_receipt as rr ON rr.\"id\" = rrd.request_receipt_id \n" +
                    "     JOIN drug as d ON d.\"id\" = rrd.drug_id \n" +
                    "     JOIN unit as un ON d.unit_id = un.id\n" +
                    "     WHERE (rrd.request_receipt_id = :id or :id = -1 )";

    public static final String GET_LIST_DRUG_FROM_INVENTORY =
            "SELECT DISTINCT inventory.drug_id as id , drug.\"name\" as name,drug.code as code " +
                    " FROM inventory  JOIN drug ON drug.id = inventory.drug_id " +
                    "ORDER BY drug_id";

    public static final String GET_DRUG_ID_AND_QUANTITY =
            "SELECT drug_id as drugId , quantity as quantity FROM request_receipt_drug WHERE (request_receipt_id = :id)";
}
