package com.shen.drug.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shen.drug.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

/**
 * 供应商表的增删改查Mapper
 */
@Mapper
public interface SupplierMapper extends BaseMapper<Supplier> {
}
