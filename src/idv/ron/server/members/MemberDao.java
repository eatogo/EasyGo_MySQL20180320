package idv.ron.server.members;

import java.util.List;

public interface MemberDao {
	boolean memberExist(String userId, String password);

	boolean memberIdExist(String userId);

	int insert(Member member);

	int update(Member member);

	int delete(String id);

	Member findById(String id);

	List<Member> getAll();
}
