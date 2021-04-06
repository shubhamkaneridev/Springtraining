package com.roytuts.spring.mvc.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.spring.mvc.jdbc.model.UserDetail;

public class UserDetailRowMapper implements RowMapper<UserDetail> {

	public UserDetail mapRow(ResultSet rs, int row) throws SQLException {
		UserDetail userDetail = new UserDetail();
		userDetail.setId(rs.getInt("id"));
		userDetail.setFirstName(rs.getString("first_name"));
		userDetail.setLastName(rs.getString("last_name"));
		userDetail.setEmail(rs.getString("email"));

		/*
		 * Date date = new Date(); SimpleDateFormat formatter = new
		 * SimpleDateFormat("MM/dd/yyyy"); String strDate = formatter.format(date);
		 * System.out.println("Date Format with MM/dd/yyyy : "+strDate);
		 */

		/*
		 * Date s = rs.getDate("dob");
		 * 
		 * DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		 * dateFormat.parse(s);
		 */

		/*
		 * SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		 * 
		 * String strDate = sm.format();
		 * 
		 * Date dt = null; try { dt = (Date) sm.parse(strDate); } catch (ParseException
		 * e) { e.printStackTrace(); } System.out.println(strDate);
		 */

		userDetail.setDob(rs.getDate("dob"));

		return userDetail;
	}

}
