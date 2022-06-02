package com.shen.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shen.drug.entity.Supplier;

import java.util.List;

/**
 * 用户表的service接口
 */
public interface ISupplierService  extends IService<Supplier> {

    /**
     * 分页查询供应商数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-供应商名称
     * @return
     */
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param);

    //新增一条供应商信息
    public int addSupplier(Supplier supplier);

    //修改一条供应商信息
    public int editSupplier(Supplier supplier);

    //根据id查询一个供应商对象
    public Supplier querySupplierById(Integer id);

    //根据id删除一个供应商对象
    public int delSupplierById(Integer id);

    //查询所有供应商
    public List<Supplier> querySupplierList();
}
