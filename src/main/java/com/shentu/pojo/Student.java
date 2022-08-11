/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/4
 * Time: 20:00
 * Describe: 动态SQL的类
 */

package com.shentu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -11L;
    private Integer id;
    private String name;
    private String password;
}
