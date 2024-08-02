package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.college;

public class collegeservice {

	private Connection conn;

	public collegeservice(Connection conn) {

		super();

		this.conn = conn;
	}

	public boolean addcollege(college clg) {

		boolean b = false;

		try {

			String sql = "insert into college (name,branch,email) values(?,?,?)";

			PreparedStatement pmst = conn.prepareStatement(sql);

			pmst.setString(1, clg.getName());

			pmst.setString(2, clg.getEmail());

			pmst.setString(3, clg.getBranch());

			int i = pmst.executeUpdate();

			if (i > 0) {

				b = true;

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return b;

	}

	public List<college> fetchall() {

		List<college> cl = new ArrayList<college>();

		college c = null;

		try {

			String sql = "select * from college";

			PreparedStatement pmst = conn.prepareStatement(sql);

			ResultSet rs = pmst.executeQuery();

			while (rs.next()) {

				c = new college();

				c.setId(rs.getInt(1));

				c.setName(rs.getString(2));

				c.setBranch(rs.getString(3));

				c.setEmail(rs.getString(4));
				
				cl.add(c);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return cl;
	}

	public college getbyid(int id) {

		college c = null;

		try {

			String sql = "select * from college where id = ? ";

			PreparedStatement pmst = conn.prepareStatement(sql);

			pmst.setInt(1, id);

			ResultSet rs = pmst.executeQuery();

			while (rs.next()) {
				
				c = new college();

				c.setId(rs.getInt(1));

				c.setName(rs.getString(2));

				c.setBranch(rs.getString(3));

				c.setEmail(rs.getString(4));

			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}

		return c;
	}

	public boolean deletebyid(int id) {

		boolean f = false;

		try {

			String sql = "delete from college where id = ? ";

			PreparedStatement pmst = conn.prepareStatement(sql);

			pmst.setInt(1, id);

			int i = pmst.executeUpdate();

			if (i > 0) {

				f = true;

			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return f;
	}

	public boolean updatecollege(college clg) {

		boolean f = false;

		try {

			String sql = "update college set name = ?,branch = ?,email = ? where id = ?"; //number = ?

			PreparedStatement pmst = conn.prepareStatement(sql);

			pmst.setString(1, clg.getName());

			pmst.setString(2, clg.getBranch());

			pmst.setString(3, clg.getEmail());

			int i = pmst.executeUpdate();

			if (i > 0) {

				f = true;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return f;
	}
}

