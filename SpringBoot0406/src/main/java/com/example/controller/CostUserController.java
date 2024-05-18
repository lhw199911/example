package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.aop.WebLog;
import com.example.common.ResultJson;
import com.example.entity.CostUser;
import com.example.service.CostUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lhw199911
 * @since 2024-04-08
 */
@RestController
@RequestMapping("/costUser")
public class CostUserController {
    @Resource
    private CostUserService costUserService;

    @WebLog("查询列表接口")
    @GetMapping("/list")
    @ResponseBody
    public ResultJson list(int pageFrom, int pageNum, String likeVal){
        Page<CostUser> page = costUserService.likePageList(pageFrom, pageNum, likeVal);
        return ResultJson.success(page);
    }

    @PostMapping("/add")
    public ResultJson add(String name, String phone, String email, MultipartFile icon, String password) {
        System.out.println(icon.getOriginalFilename());
        System.out.println(icon.getSize());
        System.out.println(icon.getContentType());
//        costUserService.addUser(new CostUser(name, phone, email, "icon.getBytes()", password));
        return ResultJson.success("添加用户成功");
    }


}
