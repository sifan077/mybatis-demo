/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/5
 * Time: 17:15
 * Describe:
 */

package com.shentu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private final static long serialVersionUID = 1L;
    private Integer cid;
    private String cname;
    private String cpassword;
    private List<Orders> ordersList;

}
