package com.atguigu.mpdemo1010.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:53 2021/10/30
 * @Modified By:
 */

/**
 * 自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //使用mp实现添加操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(), metaObject);  //metaObject   元数据，数据库中的数据
        this.setFieldValByName("updateTime",new Date(), metaObject);  //metaObject   元数据，数据库中的数据
        this.setFieldValByName("version",1 , metaObject);  //metaObject   元数据，数据库中的数据, 乐观锁
    }

    //使用mp实现更新操作，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
