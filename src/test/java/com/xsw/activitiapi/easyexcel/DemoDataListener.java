package com.xsw.activitiapi.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xueshengwen
 * @since 2020/12/16 10:17
 */
@Slf4j
public class DemoDataListener extends AnalysisEventListener<ImportData> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 10;
    List<ImportData> list = new ArrayList<>();

    private DemoDAO demoDAO;

    public DemoDataListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
        demoDAO = new DemoDAO();
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param importData      one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param analysisContext
     */
    @Override
    public void invoke(ImportData importData, AnalysisContext analysisContext) {
        log.info("解析到一条数据：{}", JSON.toJSONString(importData));
        list.add(importData);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            batchSaveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    private void batchSaveData() {
        log.info("开始入库[{}]条数据", list.size());
        demoDAO.save(list);
        log.info("入库[{}]条数据成功！", list.size());
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        batchSaveData();
        log.info("所有数据解析完成！");
    }
}
