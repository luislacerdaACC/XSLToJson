package com.accenture.service;

import com.accenture.model.TransformationMode;
import com.accenture.strategy.TransformationStrategy;
import com.accenture.strategy.TransformationStrategyFactory;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExcelService {

    @Autowired
    private TransformationStrategyFactory strategyFactory;

    public List<Map<String, String>> getXLSToJson(Sheet sheet) {
        TransformationStrategy strategy = strategyFactory.get(TransformationMode.FIRST_LINE);
        return strategy.getRows(sheet);
    }
}
