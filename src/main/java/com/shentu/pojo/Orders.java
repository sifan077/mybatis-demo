/*
 * Created by IntelliJ IDEA.
 * User: 思凡
 * Date: 2022/5/5
 * Time: 17:16
 * Describe:
 */

package com.shentu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {
    private final static long serialVersionUID = 1L;
    private Integer oid;
    private String oname;
    private Customer customer;
}
