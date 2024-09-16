package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface UserService {
	UserModel login (String username, String password);
	UserModel get(String username);
	void insert(UserModel user);
	boolean register(String email, String password, String username, String
	fullname, String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	void changePassword(String username, String password);
	boolean compUser(String s1, String s2);
}
