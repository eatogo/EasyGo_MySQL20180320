package idv.ron.server.favorite.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class favoritesDAO {
	DataSource ds = null;
	
	
	
	
	
	public favoritesDAO(){
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
			
		}catch (NamingException e) {
			e.printStackTrace();;
		}
		
	}
	
	
	private static final String SELECT_BY_ID="Select favorite_id ,favorite_food ,favorite_user  from FAVORITES where favorite_id=?";
	
	
	public Favorites select(String id) {
		Favorites result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rest = null;
		try {
			conn=  ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setString(1,id);
			rest= stmt.executeQuery();
			if(rest.next()) {
				result=new Favorites();
				result.setFavorite_id(rest.getInt("favorite_id"));
				result.setFavorite_food(rest.getInt("favorite_food"));
				result.setFavorite_user(rest.getInt("favorite_user"));				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (rest != null) {
				try {
					rest.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		}
		
		
	private static final String INSERT = "Insert into FAVORITES (favorite_id ,favorite_food ,favorite_user) values (?, ?, ?)";

	public Favorites insertMember(Favorites bean) throws SQLException {
		Favorites result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(INSERT);

			stmt.setInt(1, bean.getFavorite_id());
			stmt.setInt(2, bean.getFavorite_food());
			stmt.setInt(3, bean.getFavorite_user());					
		

		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		
		
	}

	private static final String DELETE = "Delete from FAVORITES where favorite_id=?";

	public int delete(int favorite_id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(DELETE);

			stmt.setInt(1, favorite_id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	
	
	
	
	
	}
}



