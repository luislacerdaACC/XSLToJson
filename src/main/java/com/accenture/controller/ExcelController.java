package com.accenture.controller;

import com.accenture.service.ExcelService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/excelToJson")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping
    public String test() {
        return "Ois";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> convertExcelToJson(@RequestParam("file") MultipartFile multipartFile) {
        try {
            InputStream inputStream = multipartFile.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            List<Map<String, String>> rows = excelService.getXLSToJson(sheet);

            workbook.close();
            return ResponseEntity.ok().body(rows);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
