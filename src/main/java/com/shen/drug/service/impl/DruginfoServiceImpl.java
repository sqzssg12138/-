package com.shen.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shen.drug.entity.Druginfo;
import com.shen.drug.mapper.DruginfoMapper;
import com.shen.drug.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 药品service实现类
 */
@Service
public class DruginfoServiceImpl extends ServiceImpl<DruginfoMapper, Druginfo> implements IDruginfoService {

    @Resource
    private DruginfoMapper druginfoMapper;

   //分页查询药品数据
    @Override
    public IPage<Druginfo> selectDruginfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Druginfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Druginfo> page = new Page<>(pageNum,pageSize);
        return druginfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条药品信息
     *
     * @param druginfo
     */
    @Override
    public int addDruginfo(Druginfo druginfo) {
        return druginfoMapper.insert(druginfo);
    }

    /**
     * 修改一条药品信息
     *
     * @param druginfo
     */
    @Override
    public int editDruginfo(Druginfo druginfo) {
        return druginfoMapper.updateById(druginfo);
    }

    /**
     * 根据主键id查询一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public Druginfo queryDruginfoById(Integer id) {
        return druginfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个药品对象
     *
     * @param id
     * @return
     */
    @Override
    public int delDruginfoById(Integer id) {
        return druginfoMapper.deleteById(id);
    }

    /**
     * 查询所有药品
     *
     * @return
     */
    @Override
    public List<Druginfo> queryDruginfoList() {
        return druginfoMapper.selectList(null);
    }
}
