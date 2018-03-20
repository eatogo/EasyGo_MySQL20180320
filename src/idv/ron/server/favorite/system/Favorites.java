package idv.ron.server.favorite.system;

public class Favorites {
	private int favorite_id;
	private int favorite_food;
	private int favorite_user;

	public Favorites() {

		super();
	}

	public Favorites(int favorite_id, int favorite_food, int favorite_user) {
		super();
		this.favorite_id = favorite_id;
		this.favorite_food = favorite_food;
		this.favorite_user = favorite_user;
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

	@Override
	public String toString() {
		return "Favorites [favorite_id=" + favorite_id + ", favorite_food=" + favorite_food + ", favorite_user="
				+ favorite_user + "]";
	}
	
}
