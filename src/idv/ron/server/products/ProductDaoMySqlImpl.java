package idv.ron.server.products;

import idv.ron.server.main.Common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoMySqlImpl implements ProductDao {

	public ProductDaoMySqlImpl() {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Foods product) {
		return 0;
	}

	@Override
	public int update(Foods product) {
		return 0;
	}

	@Override
	public int delete(int id) {
		return 0;
	}

	@Override
	public byte[] getImage(int id) {
		String sql = "SELECT food_pic_mdpi FROM Foods WHERE food_id=?;";
		Connection connection = null;
		PreparedStatement ps = null;
		byte[] image = null;
		try {
			connection = DriverManager.getConnection(Common.URL, Common.USER,
					Common.PASSWORD);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				image = rs.getBytes(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					// When a Statement object is closed,
					// its current ResultSet object is also closed
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return image;
	}

	@Override
	public Foods findById(int id) {
		String sql = "SELECT food_name, food_price "
				+ "FROM Foods WHERE food_id = ?;";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(Common.URL, Common.USER,
					Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString(1);
				Integer price = rs.getInt(2);
				Foods product = new Foods(id, name, price);
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Foods> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
//			String sql = "SELECT food_id, food_name, food_price FROM Foods;";
			String sql = "SELECT food_id, food_name, food_price FROM Foods;";
			conn = DriverManager.getConnection(Common.URL, Common.USER,
					Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Foods> productList = new ArrayList<Foods>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Integer price = rs.getInt(3);
				Foods food = new Foods(id, name, price);
				productList.add(food);
			}
			return productList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
