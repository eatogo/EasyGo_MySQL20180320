package idv.ron.server.favorite.system;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idv.ron.server.members.Member;
import idv.ron.server.members.MemberDao;
import idv.ron.server.members.MemberDaoMySqlImpl;

import com.google.gson.*;
@WebServlet("/favoriteSysyem")
public class favoriteSysyem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String CONTENT_TYPE = "text/html; charset=UTF-8";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		request.setCharacterEncoding("UTF-8");
		
		Gson gson = new Gson();
		BufferedReader br = request.getReader();
		StringBuilder jsonIn = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			jsonIn.append(line);
		}
		System.out.println(jsonIn);
			
		br.close();
//	
		
//		
		JsonObject jsonObject = gson.fromJson(jsonIn.toString(),
				JsonObject.class);
		FavoritesDao Dao = new FavoritesDaoimpl();
		String action = jsonObject.get("action").getAsString();
		System.out.println("action: " + action);
		if (action.equals("Favoriteinsert")) {
			String user_cellphone = jsonObject.get("user_cellphone").getAsString();
			int favorite_food = jsonObject.get("favorite_food").getAsInt();
			System.out.println("user_cellphone: " + user_cellphone);
			FavoritesBean bean = new FavoritesBean();
			bean=Dao.QueryUserId(user_cellphone);
			bean.setFavorite_food(favorite_food);
			//String user_id = bean.getUser_id();
			//System.out.println("user_id " + user_id);
			System.out.println(bean);
			writeText(response, String.valueOf( Dao.insertMember(bean)));
		} else if (action.equals("delete")) {
			
			//writeText(response, String.valueOf(memberDao.update(bean)));
		}
	
		//for (FavoritesBean fs : list) {
		//System.out.println(fs.toString());	
		//	favorites.show();
		//}
	

	response.getWriter().write("");
	}
		
		
	
	private void writeText(HttpServletResponse response, String outText)
			throws IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		System.out.println("outText: " + outText);
		out.print(outText);
	}
}
		
		

	
	
	
	
	


