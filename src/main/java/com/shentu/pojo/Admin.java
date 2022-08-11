/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/3
 * Time: 23:11
 * Describe: mybatis 注解类
 */

package com.shentu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = -9085348675682985L;
    private Integer id;
    private String name;
    private Integer age;
}
