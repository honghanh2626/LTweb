package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.JDBCUtil;
import vn.iotstar.models.UserModel;

public class UserDaoImpl implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public UserModel get(String username) {
		String sql = "SELECT * FROM user WHERE username = ? ";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user; 
			}
		} catch (Exception e) {e.printStackTrace(); }
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO user(email, username, fullname, password, avatar, roleid,phone,createddate) VALUES (?,?,?,?,?,?,?,?)";
				try {
					conn = new JDBCUtil().getConnection();
					ps = conn.prepareStatement(sql);
					ps.setString(1, user.getEmail());
					ps.setString(2, user.getUserName());
					ps.setString(3, user.getFullName());
					ps.setString(4, user.getPassWord());
					ps.setString(5, user.getAvatar());
					ps.setInt(6,user.getRoleid());
					ps.setString(7,user.getPhone());
					ps.setDate(8, user.getCreatedDate());
					ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	@Override
	public boolean checkExistEmail(String email) {
			boolean duplicate = false;
			String query = "select * from users where email = ?";
			try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
			duplicate = true;
			}
			ps.close();
			conn.close();
			} catch (Exception ex) {}
			return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where username = ?";
		try {
			conn = new JDBCUtil().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
		if (rs.next()) {
			duplicate = true;
		}
			ps.close();
			conn.close();
		} catch (Exception ex) {}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return false;
	}
	@Override
	public boolean updatePassword(String username, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE username = ?";
        try {
            conn = new JDBCUtil().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);    
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; 
    }

	

	
}