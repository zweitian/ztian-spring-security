package com.ztian.entity;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

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
	@ApiModelProperty(value = "用户名")
	private String userName;

	@JsonView(UserDetailView.class)
	@NotBlank(message = "密码不能为空")
	private String password;

	@JsonView(UserSimpleView.class)
	private Date birthday;

	@JsonView(UserSimpleView.class)
	private LocalDateTime birthday2;
}
