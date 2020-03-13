package com.example.authentication.dto;/**
 * @author: ait
 * @date: 2020/3/13 20:30
 * @description:
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project   : authentication
 * @className : User
 * @author    : ait
 * @time      : 2020年03月13日 20:30
 * @desc      : TODO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String userName;
    private String passWord;
}
