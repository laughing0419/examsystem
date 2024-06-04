package com.cx.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component //把这个加到IOC容器中让spring托管 加了这个之后mybatis就会自动识别处理  一定不要忘记
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入的时候的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("star insert......");
        //设置字段的值  MetaObjectHandler setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
    //更新的时候的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("star update......");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
