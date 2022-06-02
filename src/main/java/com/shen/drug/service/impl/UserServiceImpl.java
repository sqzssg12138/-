package com.shen.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shen.drug.entity.User;
import com.shen.drug.mapper.UserMapper;
import com.shen.drug.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户service实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    /**
     * 根据用户名查询用户对象
     *
     * @param user
     */
    @Override
    public User queryUserByUsername(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        return userMapper.selectOne(wrapper);
    }

    @Override
    public int addUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        Integer count = userMapper.selectCount(wrapper);
        if (count == 0){
            userMapper.insert(user);
        }
        return count;
    }
}
