package com.shen.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shen.drug.entity.Supplier;
import com.shen.drug.mapper.SupplierMapper;
import com.shen.drug.service.ISupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 供应商service实现类
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    //分页查询供应商信息
    @Override
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Supplier> page = new Page<>(pageNum,pageSize);
        return supplierMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    @Override
    public int editSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    @Override
    public Supplier querySupplierById(Integer id) {
        return supplierMapper.selectById(id);
    }

    @Override
    public int delSupplierById(Integer id) {
        return supplierMapper.deleteById(id);
    }

    @Override
    public List<Supplier> querySupplierList() {
        return supplierMapper.selectList(null);
    }
}
