package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.CostUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lhw199911
 * @since 2024-04-08
 */
public interface CostUserService extends IService<CostUser> {

    /**
     * 分页模糊查询
     **/
    public Page<CostUser> likePageList(int pageFrom, int pageNum, String likeVal);

    /**
     * 添加用户
     * **/
    public boolean addUser(CostUser user);
}
