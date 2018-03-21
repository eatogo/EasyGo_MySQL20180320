package idv.ron.server.favorite.system;

public class FavoritesBean {
	private int favorite_id;
	private int favorite_food;
	private int favorite_user;
	private String user_id;
	private String user_cellphone;
	
	public FavoritesBean() {

		super();
	}

	public FavoritesBean(int favorite_id, String user_id) {
		super();
		this.favorite_id = favorite_id;
		this.user_id = user_id;
	}

	public FavoritesBean(int favorite_id, int favorite_food, int favorite_user, String user_id, String user_cellphone) {
		super();
		this.favorite_id = favorite_id;
		this.favorite_food = favorite_food;
		this.favorite_user = favorite_user;
		this.user_id = user_id;
		this.user_cellphone = user_cellphone;
	}

	public int getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}

	public int getFavorite_food() {
		return favorite_food;
	}

	public void setFavorite_food(int favorite_food) {
		this.favorite_food = favorite_food;
	}

	public int getFavorite_user() {
		return favorite_user;
	}

	public void setFavorite_user(int favorite_user) {
		this.favorite_user = favorite_user;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_cellphone() {
		return user_cellphone;
	}

	public void setUser_cellphone(String user_cellphone) {
		this.user_cellphone = user_cellphone;
	}

	@Override
	public String toString() {
		return "FavoritesBean [favorite_id=" + favorite_id + ", favorite_food=" + favorite_food + ", favorite_user="
				+ favorite_user + ", user_id=" + user_id + ", user_cellphone=" + user_cellphone + "]";
	}

	
}
