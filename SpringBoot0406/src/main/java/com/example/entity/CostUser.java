package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lhw199911
 * @since 2024-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CostUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public CostUser(String name, String phone, String email, String icon, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.icon = icon;
        this.password = password;
    }

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String icon;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 是否活跃
     */
    private Boolean active;


}
