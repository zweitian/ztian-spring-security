package com.ztian.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import com.ztian.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author ztian
 * @date 2019/10/16
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> listUser() {
		User user1 = new User(1, "张三", "123", new Date(), LocalDateTime.now());
		User user2 = new User(2, "李四", "123", new Date(), LocalDateTime.now());
		return Lists.newArrayList(user1, user2);
	}

	@GetMapping("{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getUser(@PathVariable("id") Integer id) {
		return new User(id, "张三", "123", new Date(), LocalDateTime.now());
	}

	/**
	 * 只有@Valid直接抛出异常
	 * 同时存在@Valid 和 BindingResult bindingResult 则会进入请求方法
	 */
	@PostMapping()
	public User saveUser(@Valid @RequestBody User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				log.warn("{}", objectError);
			}
		}
		user.setId(1);
		return user;
	}

	/**
	 * 只有@Valid直接抛出异常
	 * 同时存在@Valid 和 BindingResult bindingResult 则会进入请求方法
	 */
	@DeleteMapping("{id:\\d+}")
	public void deleteById(@PathVariable("id") Integer id) {
		log.info("{}删除成功", id);
	}


	@GetMapping("exception")
	@JsonView(User.UserDetailView.class)
	public User exception() {
		throw new RuntimeException("异常测试");
	}
}
