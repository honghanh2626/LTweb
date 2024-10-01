package vn.iotstar.services.impl;

import java.sql.Date;

import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.UserService;

public class UserServiceImpl implements UserService {
	UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		// TODO Auto-generated method stub
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		userDao.insert(user);

	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {
		// TODO Auto-generated method stub
		if (userDao.checkExistUsername(username)) {
			return false;
		}

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		double randomDouble = 0;
		for (int i = 0; i < 5; i++) {
			double randomNumber = Math.random();
			randomDouble += randomNumber * 100 + 1;
		}
		userDao.insert(new UserModel((int) randomDouble, email, username, fullname, password, null, 2, phone, date));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.checkExistPhone(phone);

	}
}
