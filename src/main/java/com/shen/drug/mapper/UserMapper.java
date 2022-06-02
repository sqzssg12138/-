package com.shen.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shen.drug.entity.User;
import org.apache.ibatis.annotations.Mapper;

    /**
     * 用户表的增删改查Mapper
     */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

