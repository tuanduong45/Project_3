package com.example.Project_3.sevice.inventory;

import com.example.Project_3.dtos.inventory.DrugWarningDTO;
import com.example.Project_3.dtos.inventory.DrugWarningListDTO;
import javafx.scene.chart.XYChart;
import org.springframework.stereotype.Service;

@Service
public interface DrugWarningService {

    // thêm cảnh báo thuốc

    void addDrugWarning(DrugWarningListDTO drugWarningListDTO);
}
