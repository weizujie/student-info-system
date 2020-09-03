package com.example.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.entity.Obtain;
import com.example.service.IObtainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class ObtainListener extends AnalysisEventListener<Obtain> {

    @Autowired
    private IObtainService obtainService;


    private List<Obtain> list = new ArrayList<>();
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;


    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     */
    public ObtainListener(IObtainService obtainService) {
        this.obtainService = obtainService;
    }


    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(Obtain Obtain, AnalysisContext analysisContext) {
        // 数据存储到datas，供批量处理，或后续自己业务逻辑处理。
        list.add(Obtain);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理datas
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
        for (Obtain obtain : list) {
            obtainService.addObtain(obtain);
        }
        log.info("导入数据库成功");
    }
}