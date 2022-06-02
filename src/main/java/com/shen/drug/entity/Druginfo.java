package com.shen.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shen.drug.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "druginfo")
public class Druginfo implements Serializable {

    /*����*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /*ҩƷ����*/
    private String name;

    /*��Ӧ������*/
    private String supplier;

    /*����ʱ��*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producttime;

    /*�����ڣ��£�*/
    private String warrenty;

    /*ҩƷ����*/
    private String number;

    /*�۸�*/
    private Float price;

    /*���*/
    private Integer stock;

    /*����ʱ��ת����������*/
    public String getProducttimeStr(){
        return DateUtil.dateConvert(producttime);
    }
}
