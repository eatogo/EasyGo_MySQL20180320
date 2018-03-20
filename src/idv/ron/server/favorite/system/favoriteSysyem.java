package idv.ron.server.favorite.system;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

import org.json.JSONArray;
import org.json.JSONObject;


@WebServlet("/favoriteSysyem")
public class favoriteSysyem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("text/html; charset=UTF-8");
		String info=request.getParameter("name");//APP 帳戶的名子 (Input標籤的 name)
		
		if(info == null) {
			System.out.println("please Sign in first");
		} 
		
		String acceptjson="";
		
		BufferedReader br = new BufferedReader(new  InputStreamReader(
				request.getInputStream(),"utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while((temp=br.readLine())!=null ) {
			sb.append(temp);
			
		}
			
		br.close();
//		acceptjson=sb.toString();
//		if(acceptjson !="") {
//			 JSONObject jo = JSONObject.fromObject(acceptjson);  
//             JSONArray imgArray = jo.getJSONArray("Images");  
//             JSONArray infArray = jo.getJSONArray("Info");
//             
//             for(int i = 0 ; imgArray.size(); i++) {
//            	  JSONObject imgObject = JSONObject.fromObject(imgArray  
//                          .get(i));  
//                  System.out.println(imgObject.get("PartsImg"));  
//             }
//             JSONObject infObject = JSONObject.fromObject(infArray.get(0));  
//             System.out.println(infObject.get("favorite_id"));  
//             System.out.println(infObject.get("favorite_food"));  
//             System.out.println(infObject.get("favorite_user"));  
//         
//             System.out.println(jo.toString());  
		
	


		// List to JSON
//		jsonStr = new JSONArray("???").toString();
//		System.out.println("List to JSON: " + jsonStr);
		// JSON to List
		
		
		String jsonStr = "{['favorite_id':'1','favorite_food':'1','favorite_user':'1'],['favorite_id':'2','favorite_food':'2','favorite_user':'2'],['favorite_id':'3','favorite_food':'3','favorite_user':'3']}";
		List<Favorites> list = new ArrayList<Favorites>();
		JSONArray jsonArray = new JSONArray(jsonStr);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject json_favorites = jsonArray.getJSONObject(i);
			int favorite_id = json_favorites.getInt("favorite_id");
			int favorite_food = json_favorites.getInt("favorite_food");
			int favorite_user = json_favorites.getInt("favorite_user");
			Favorites favorites = new Favorites(1,2,3);
			list.add(favorites);
		}
		for (Favorites fs : list) {
		System.out.println(fs.toString());	
		//	favorites.show();
		}
		System.out.println();

	response.getWriter().write("");
		}
		
		
	}
		
		

	
	
	
	
	


