package com.example.Project_3.constant.sql.importReceipt;

public class SQLImportReceipt {

    public static final String GET_LST_IMPORT_RECEIPT =
            "SELECT ir.id as id ,ir.import_receipt_code as importReceiptCode,CAST(ir.import_date AS DATE ) as importDate ,\n" +
                    "concat(us.first_name , '',us.last_name) as createdBy , \n" +
                    "CASE \n" +
                    "\tWHEN ir.status = 1 THEN 'Đã xuất kho'\n" +
                    "\tWHEN ir.status = 0 THEN 'Đã hủy'\n" +
                    "\tWHEN ir.status = -1 THEN 'Bản nháp'\n" +
                    "\tWHEN ir.status = 2 THEN 'Chờ xác nhận'\n" +
                    "\tELSE ''\n" +
                    "END as statusText\n" +
                    " FROM import_receipt as ir \n" +
                    " JOIN users as us ON ir.user_id = us.\"id\" \n" +
                    " WHERE (:code = '' OR ir.import_receipt_code = :code)\t\n" +
                    " AND (:startDate = CAST ('1970-01-01' as DATE) OR CAST(ir.import_date AS DATE) >= :startDate) \n" +
                    " AND (:endDate = CAST ('1970-01-01' as DATE) OR CAST(ir.import_date AS DATE)  <= :endDate ) \n" +
                    " ORDER BY id ";


    public static final String GET_LST_IMPORT_RECEIPT_DETAIL =
            "SELECT d.id as drugId,d.code as drugCode , d.\"name\" as drugName, s.\"name\" as supplierName, " +
                    "dir.produce_batch_number as produceBatchNumber , CAST(d.expiry_date as DATE) as expiryDate\n" +
                    ",dir.quantity as quantity, dir.price as price , dir.total_amount as totalAmount , " +
                    "u.unit_name as unitName\tFROM drug_import_receipt as dir \n" +
                    " JOIN drug as d ON dir.drug_id = d.\"id\"\n" +
                    " JOIN unit as u ON u.\"id\" = d.unit_id \n" +
                    " JOIN supplier as s ON dir.supplier_id = s.\"id\"\n" +
                    " WHERE (:id = -1 OR dir.import_receipt_id = :id) \t" ;


}
