package spring;

import java.util.List;

public interface BookDAO {
	
	public void insert(BookVO bookVO);
	public List<BookVO> selectAll();
	public BookVO selectByNum(int num);
	public Object selectByIsbn(String isbn);
	public List<BookVO> selectBySearch(String keyword, String searchType);
	
}
