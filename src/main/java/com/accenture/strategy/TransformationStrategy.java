package com.accenture.strategy;

import com.accenture.model.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TransformationStrategy {
    List<Map<String, String>> getRows(Sheet sheet);

    default Map<String, String> createRow(Row row, Header header) {
        Map<String, String> map = new HashMap<>();
        for (int j = 0; j < row.getLastCellNum(); j++) {
            var title = header.get(j) ;//sheet.getRow(0).getCell(j).getStringCellValue();
            Optional.ofNullable(row.getCell(j))
                    .ifPresent(cell -> map.put(title, cell.getStringCellValue()));
        }
        return map;
    }
}
