package com.example.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import com.example.model.SysScholarism;

import com.example.service.SysScholarismService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class ScholarismListener extends AnalysisEventListener<SysScholarism> {

    @Autowired
    private SysScholarismService sysScholarismService;


    private List<SysScholarism> list = new ArrayList<>();
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ScholarismListener(SysScholarismService sysScholarismService) {
        this.sysScholarismService = sysScholarismService;
    }


    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(SysScholarism sysScholarism, AnalysisContext analysisContext) {
        // 数据存储到 datas，供批量处理，或后续自己业务逻辑处理。
        list.add(sysScholarism);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 datas
            list.clear();
        }

    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();//确保所有数据都能入库
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        for (SysScholarism sysScholarism : list) {
            sysScholarismService.saveScholarism(sysScholarism);
        }
        log.info("导入数据库成功");
    }
}