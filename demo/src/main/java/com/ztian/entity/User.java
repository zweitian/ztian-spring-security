package com.ztian.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ztian
 * @date 2019/10/19
 */
@Data
@AllArgsConstructor
public class User {
	public interface UserSimpleView {};
	public interface UserDetailView extends UserSimpleView {};

	@JsonView(UserSimpleView.class)
	private Integer id;

	@JsonView(UserSimpleView.class)
	private String userName;

	@JsonView(UserDetailView.class)
	private String password;

	@JsonView(UserSimpleView.class)
	private Date birthday;

	@JsonView(UserSimpleView.class)
	private LocalDateTime birthday2;
}
