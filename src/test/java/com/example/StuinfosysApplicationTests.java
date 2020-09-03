package com.example;

import com.alibaba.excel.EasyExcel;
import com.example.entity.Obtain;
import com.example.service.IObtainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StuinfosysApplicationTests {

    @Autowired
    private IObtainService obtainService;

    public List<Obtain> data() {
        List<Obtain> obtains = obtainService.findAll();
        return obtains;
    }

    @Test
    public void simpleWrite() {
        String filename = "D://demo.xlsx";
        EasyExcel.write(filename, Obtain.class).sheet("Obtain").doWrite(data());
    }

}
