package com.ztian.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;

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
}
