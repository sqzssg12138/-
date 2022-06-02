package com.shen.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shen.drug.entity.Druginfo;
import com.shen.drug.entity.Owinfo;
import com.shen.drug.mapper.DruginfoMapper;
import com.shen.drug.mapper.OwinfoMapper;
import com.shen.drug.service.IOwinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 药品出入库service实现类
 */
@Service
public class OwinfoServiceImpl extends ServiceImpl<OwinfoMapper, Owinfo> implements IOwinfoService {

    @Resource
    private OwinfoMapper owinfoMapper;

    @Resource
    private DruginfoMapper druginfoMapper;
    //分页查询药品出入库数据
    @Override
    public IPage<Owinfo> selectOwinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Owinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Owinfo> page = new Page<>(pageNum,pageSize);
        return owinfoMapper.selectPage(page,queryWrapper);
    }

    //新增一条药品出入库信息
    @Override
    public int addOwinfo(Owinfo owinfo) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", owinfo.getDname());
        Druginfo druginfo = druginfoMapper.selectOne(queryWrapper);
        String type = owinfo.getType();
        if ("出库".equals(type)){
            int num = druginfo.getStock() - owinfo.getCount();
            System.out.println(num);
            System.out.println(num);
            druginfo.setStock(num);
            druginfoMapper.updateById(druginfo);
        }

        if ("入库".equals(type)){
            int num = druginfo.getStock() + owinfo.getCount();
            System.out.println(num);
            druginfo.setStock(num);
            druginfoMapper.updateById(druginfo);
        }
        return owinfoMapper.insert(owinfo);
    }

    /**
     * 修改一条药品出入库信息
     *
     * @param owinfo
     */
    @Override
    public int editOwinfo(Owinfo owinfo) {
        return owinfoMapper.updateById(owinfo);
    }

    //根据主键id查询一个药品出入库对象
    @Override
    public Owinfo queryOwinfoById(Integer id) {
        return owinfoMapper.selectById(id);
    }

    //根据主键id删除一个药品出入库对象
    @Override
    public int delOwinfoById(Integer id) {
        Owinfo owinfo = owinfoMapper.selectById(id);
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", owinfo.getDname());
        Druginfo druginfo = druginfoMapper.selectOne(queryWrapper);
        String type = owinfo.getType();
        if ("出库".equals(type)){
            int num = druginfo.getStock() + owinfo.getCount();
            System.out.println(num);
            System.out.println(num);
            druginfo.setStock(num);
            druginfoMapper.updateById(druginfo);
        }

        if ("入库".equals(type)){
            int num = druginfo.getStock() - owinfo.getCount();
            System.out.println(num);
            druginfo.setStock(num);
            druginfoMapper.updateById(druginfo);
        }
        return owinfoMapper.deleteById(id);
    }

}
