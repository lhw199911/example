package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.CostUser;
import com.example.mapper.CostUserMapper;
import com.example.service.CostUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lhw199911
 * @since 2024-04-08
 */
@Service
public class CostUserServiceImpl extends ServiceImpl<CostUserMapper, CostUser> implements CostUserService {
    @Resource
    private CostUserMapper costUserMapper;

    // 解密密码
    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public Page<CostUser> likePageList(int pageFrom, int pageNum, String likeVal) {
        QueryWrapper<CostUser> costUserQueryWrapper = new QueryWrapper<>();
        costUserQueryWrapper.like("name", likeVal);
        costUserQueryWrapper.orderByDesc("id");
        return this.page(new Page<>(pageFrom, pageNum), costUserQueryWrapper);
    }

    @Override
    public boolean addUser(CostUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.save(user);
    }
}
