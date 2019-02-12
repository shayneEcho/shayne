package com.example.demo.example1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * 〈〉
 *
 * @author 二中回音哥
 * @create 2019/1/19
 * @since 1.0.0
 */
@Entity
@Table(name = "user")
@Data
@ApiModel(value = "用户对象",description = "用户对象user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键 id", required = true, name = "id")
    private Long Id;
    @Column(length = 50)
    @ApiModelProperty(value = "用户名", required = false, name = "name")
    private String name;
    @Column(length = 255)
    @ApiModelProperty(value = "邮箱", required = false, name = "email")
    private String email;
}
