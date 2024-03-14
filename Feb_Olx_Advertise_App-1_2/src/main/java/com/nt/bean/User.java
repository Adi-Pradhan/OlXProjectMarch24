package com.nt.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Embeddable
public class User {

	@Column(name = "Olx_User_Id")
	private Integer userID;
	@NonNull
	private String userName;
	@NonNull
	private String userPswd;
	@NonNull
	private String roles;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String email;
	@NonNull
	private String phoneNumber;
	@NonNull
	private Active statusUser;

}
