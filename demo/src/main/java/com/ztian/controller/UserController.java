package com.ztian.controller;

import com.google.common.collect.Lists;
import com.ztian.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ztian
 * @date 2019/10/16
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	public List<User> listUser() {
		User user1 = new User(1, "张三", "");
		User user2 = new User(2, "李四", "");
		return Lists.newArrayList(user1, user2);
	}

	@GetMapping("{id:\\d+}")
	public User getUser(@PathVariable("id") Integer id) {
		return new User(id, "张三", "");
	}
}
