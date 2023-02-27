package com.accenture.model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.Optional;

public class FirstLineHeader extends Header {

    private final Row row;

    public FirstLineHeader(Row row) {
        this.row = row;
    }

    @Override
    protected String getValue(int position) {
        return Optional.ofNullable(row.getCell(position))
                .map(Cell::getStringCellValue)
                .orElseGet(() -> String.format("field%d", position));
    }
}
