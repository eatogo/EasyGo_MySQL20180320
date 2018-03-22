package idv.ron.server.favorite.system;

public interface FavoritesDao {
	 FavoritesBean select(String id);
	 FavoritesBean insertMember(FavoritesBean bean);
	int delete(int favorite_id);
	FavoritesBean QueryUserId(String user_cellphone);
	FavoritesBean QueryAllFavo(String user_cellphone);
	
}
