package vn.iotstar.services;


import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;


public class UserServiceImpl implements UserService{
	UserDaoImpl userDao = new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel get(String username) {
		return userDao.get(username);
	}



	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changePassword(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean compUser(String s1, String s2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}
	
}
