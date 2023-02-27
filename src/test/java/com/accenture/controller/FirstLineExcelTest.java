package com.accenture.controller;

import com.accenture.util.FileUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FirstLineExcelTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void test1() throws Exception {
        execute("Test1.xlsx", "test1.json");
    }

    @Test
    public void test2() throws Exception {
        execute("Test2.xlsx", "test2.json");
    }

    @Test
    public void test3() throws Exception {
        execute("Test3.xlsx", "test3.json");
    }

    @Test
    public void test4() throws Exception {
        execute("Test4.xlsx", "test4.json");
    }

    private void execute(String inputFileName, String outputFileName) throws Exception {
        byte[] input = FileUtil.readFromFile("/exampleTests/%s".formatted(inputFileName));
        String expectedResponse = FileUtil.readFromFileToString("/expectedResults/%s".formatted(outputFileName));

        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                inputFileName,
                "application/x-xls",
                input
        );

        mvc.perform(MockMvcRequestBuilders
                        .multipart("/excelToJson")
                        .file(file))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }
}
