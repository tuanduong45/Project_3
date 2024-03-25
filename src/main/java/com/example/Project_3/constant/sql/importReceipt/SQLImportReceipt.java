package com.example.Project_3.constant.sql.importReceipt;

public class SQLImportReceipt {
    public static final String GET_LIST_IMPORT_RECEIPT =
            "SELECT DISTINCT ir.import_receipt_code as importReceiptCode ," +
                    " ir.import_person_name as import_person_name \n" +
                    ", ir.status as status,ir.import_date as importDate " +
                    "FROM import_receipt AS ir " +
                    "JOIN drug_import_receipt as dir ON ir.\"id\" = dir.import_receipt_id " +
                    "ORDER BY import_receipt_code ASC";

    public static final String GET_LIST_IMPORT_RECEIPT_DETAIL =
            "SELECT CAST(ir.import_date AS DATE) as importDate , ir.import_person_name as importPersonName, " +
                    "ir.import_receipt_code as importReceiptCode , ir.status as status , " +
                    "d.\"name\" as drugName , s.\"name\" as supplierName , dir.produce_batch_number as produceBatchName, " +
                    "CAST(dir.expiry_date AS DATE) as expiryDate, dir.quantity AS quantity ,u.unit_name as unitName ," +
                    " d.price as price , dir.total_amount as totalAmount FROM import_receipt as ir \n" +
                    "LEFT JOIN drug_import_receipt dir ON ir.\"id\" = dir.import_receipt_id \n" +
                    "JOIN drug as d ON dir.drug_id = d.\"id\" \n" +
                    "JOIN supplier as s on dir.supplier_id = s.\"id\"\n" +
                    "JOIN unit as u ON dir.unit_id = u.\"id\"\n" +
                    "WHERE " +
                    "(:code = '' OR ir.import_receipt_code = :code) \n" +
                    "AND (:date = CAST('1970-01-01' AS DATE) OR :date = CAST(ir.import_date AS DATE)) " +
                    "AND (:status = '' OR ir.status = :status) \n" +
                    "ORDER BY ir.import_receipt_code ASC\n" ;


}
