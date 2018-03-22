package idv.ron.server.favorite.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import idv.ron.server.main.Common;
import idv.ron.server.products.Foods;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FavoritesDaoimpl implements FavoritesDao{
	DataSource ds = null;
	
	
	
	
	
	public FavoritesDaoimpl(){
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		try {
//			Context context = new InitialContext();
//			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
//			
//		}catch (NamingException e) {
//			e.printStackTrace();;
//		}
		
	}
	
	
	private static final String SELECT_BY_ID="Select favorite_id ,favorite_food ,favorite_user  from FAVORITES where favorite_id=?";
	
	@Override
	public FavoritesBean select(String id) {
		FavoritesBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rest = null;
		try {
			conn = DriverManager.getConnection(Common.URL, Common.USER,
					Common.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setString(1,id);
			rest= stmt.executeQuery();
			if(rest.next()) {
				result=new FavoritesBean();
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
		
		
	private static final String INSERT = "Insert into FAVORITES (favorite_food ,favorite_user) values ( ?, ?)";
	@Override
	public FavoritesBean insertMember(FavoritesBean bean) {
		FavoritesBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		int count = 0;
		try {
			conn = DriverManager.getConnection(Common.URL, Common.USER,
					Common.PASSWORD);
			stmt = conn.prepareStatement(INSERT);	
			stmt.setInt(1, bean.getFavorite_food());
			stmt.setInt(2, bean.getFavorite_user());					
			count = stmt.executeUpdate();
			}catch(Exception e){
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

	private static final String DELETE = "Delete from FAVORITES where favorite_id=?";
	@Override
	public int delete(int favorite_id) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(Common.URL, Common.USER,
					Common.PASSWORD);
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
	
	private static final String SELECT_BY_USER_ID="SELECT user_id FROM Users WHERE user_cellphone = ?";	
@Override
	public FavoritesBean QueryUserId(String user_cellphone) {
		FavoritesBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rest = null;
		try {
			conn = DriverManager.getConnection(Common.URL, Common.USER,
					Common.PASSWORD);
			stmt = conn.prepareStatement(SELECT_BY_USER_ID);
			stmt.setString(1,user_cellphone);
			rest= stmt.executeQuery();
			if(rest.next()) {
				result=new FavoritesBean();
				result.setFavorite_user(rest.getInt("user_id"));
								
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

private static final String SELECT_Favo_BY_USER_ID="SELECT a.food_id, a.food_name, a.food_price "
		+ "FROM foods  where favorite_user=?;";	
@Override
	public FavoritesBean QueryAllFavo(String favorite_user) {
		FavoritesBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rest = null;
		try {
			conn = DriverManager.getConnection(Common.URL, Common.USER,
					Common.PASSWORD);
			stmt = conn.prepareStatement(SELECT_Favo_BY_USER_ID);
			stmt.setString(1,favorite_user);
			rest= stmt.executeQuery();
			List<FavoritesBean> productList = new ArrayList<FavoritesBean>();
			while(rest.next()) {
				int id = rest.getInt("food_id");
				String name =(rest.getString("food_name"));
				Integer price=(rest.getInt("food_price"));
			FavoritesBean bean = new FavoritesBean();
			bean.setFavorite_id(id);
			bean.setFavorite_name(name);
			bean.setFavorite_price(price);
			productList.add(bean);
			System.out.println(bean);
				
			}
		}catch (SQLException e) {
			e.getMessage();
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




}



