package com.example.Project_3.constant.sql.requestReceipt;

public class SQLRequestReceipt {

    public static final String GET_LIST_REQUEST_RECEIPT =
            "SELECT rr.request_receipt_code as requestReceiptCode , CAST(rr.request_date as DATE ) as requestDate \n" +
                    ",concat(u.first_name,' ',u.last_name) AS creatorName , d.\"name\" as departmentName ,\n" +
                    " CASE \n" +
                    " WHEN rr.request_status = 1 THEN 'Đang xử lý' \n" +
                    " WHEN rr.request_status = 2 THEN 'Đã hủy' \n" +
                    " WHEN rr.request_status = 3 THEN 'Hoàn thành' \n" +
                    " ELSE '' END as requestStatus , dr.\"name\" as drugName, rrd.quantity as quantity , un.unit_name as unitName\n" +
                    " FROM request_receipt as rr \n" +
                    " LEFT JOIN request_receipt_drug as rrd ON rr.\"id\" = rrd.request_receipt_id\n" +
                    " JOIN users as u ON rr.user_id = u.\"id\" \n" +
                    " JOIN department as d ON d.\"id\" = u.department_id\n" +
                    " JOIN drug as dr ON dr.\"id\" = rrd.drug_id \n" +
                    " JOIN unit as un ON un.\"id\" = dr.unit_id\n" +
                    " WHERE \n" +
                    " (:code = '' OR :code = rr.request_receipt_code ) \n" +
                    " AND (:startDate = CAST ('1970-01-01' as DATE) OR :startDate <= CAST(rr.request_date as DATE)) \n" +
                    " AND (:endDate = CAST('1970-01-01' as DATE) OR :endDate >= CAST(rr.request_date as DATE)) \n" +
                    " AND (:name = '' OR :name = d.name ) \n" +
                    " AND (:status = -1 OR :status = rr.request_status) \n" +
                    "ORDER BY d.name , rr.request_receipt_code";


    public static final String GET_REQUEST_RECEIPT_CODE =
            "SELECT rr.request_receipt_code as requestReceiptCode , CAST(rr.request_date as DATE ) as requestDate \n" +
                    ",concat(u.first_name,' ',u.last_name) AS creatorName , d.name as departmentName ,\n" +
                    "CASE \n" +
                    "  WHEN rr.request_status = 1 THEN 'Đang xử lý'\n" +
                    "  WHEN rr.request_status = 2 THEN 'Đã hủy'\n" +
                    "  WHEN rr.request_status = 3 THEN 'Hoàn thành' \n" +
                    "ELSE '' \n" +
                    " END as requestStatus FROM request_receipt as rr \n" +
                    " JOIN users AS u ON u.id = rr.user_id \n" +
                    " JOIN department AS d ON d.id = u.department_id";
}
