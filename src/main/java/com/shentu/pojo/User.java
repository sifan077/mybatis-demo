/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/1
 * Time: 20:21
 * Describe: lombok创建类   mybatis XML类
 */

package com.shentu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data // 包含getter、setter、equals、hashCode、toString
@AllArgsConstructor // 包含全参构造器
@NoArgsConstructor // 包含无参构造器
public class User implements Serializable {
    private static final long serialVersionUID = -1L;
    private Integer id;
    private String name;
    private String password;
}
