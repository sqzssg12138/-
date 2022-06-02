package com.shen.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供货商
 */
@Data
@TableName(value = "supplier")
public class Supplier implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /*供货商名*/
    private String name;

    /*供货商描述*/
    private String content;

    /*创建时间*/
    private Date createtime;
}
