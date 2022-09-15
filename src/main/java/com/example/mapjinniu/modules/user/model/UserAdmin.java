package com.example.mapjinniu.modules.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lly
 * @since 2022-09-04
 */
@Getter
@Setter
@TableName("user_admin")

public class UserAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String tel;

    private String vx;

    private String title;

    private String location;

    private Date createTime;

    private Date updateTime;

    private Integer fenceId;

    private String street;

    private String role;

    private String permission;

    private String name;

}
