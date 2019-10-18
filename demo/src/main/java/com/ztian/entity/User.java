package com.ztian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ztian
 * @date 2019/10/19
 */
@Data
@AllArgsConstructor
public class User {
	private Integer id;
	private String userName;
	private String password;
}
