package com.accenture.strategy;

import com.accenture.model.FirstLineHeader;
import com.accenture.model.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.*;

public class FirstLineStrategy implements TransformationStrategy {
    @Override
    public List<Map<String, String>> getRows(Sheet sheet) {
        List<Map<String, String>> rows = new ArrayList<>();
        Header header = new FirstLineHeader(sheet.getRow(0));

        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            rows.add(createRow(row, header));
        }
        return rows;
    }
}
