package com.atguigu.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:06 2021/10/30
 * @Modified By:
 */
@Data
public class User {
//    @TableId(type = IdType.AUTO)
//    @TableId(type = IdType.UUID)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)                       //自动填充，自动更新插入时间和更新时间
    private Date createTime;            //数据库中字段的合适是下划线在实体类中要转为驼峰式
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    private Integer deleted;
}