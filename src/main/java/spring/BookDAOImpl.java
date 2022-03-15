package spring;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class BookDAOImpl implements BookDAO{
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BookDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void insert(BookVO bookVO) {
		sqlSessionTemplate.insert("insert", bookVO);
	}

	@Override
	public List<BookVO> selectAll() {
		return sqlSessionTemplate.selectList("list");
	}
	
	@Override
	public BookVO selectByNum(int num) {
		return sqlSessionTemplate.selectOne("selectByNum", num);
	}
	
	@Override
	public Object selectByIsbn(String isbn) {
		return sqlSessionTemplate.selectOne("selectByIsbn", isbn);
	}
	
	@Override
	public List<BookVO> selectBySearch(String keyword, String searchType) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		System.out.println(map.get("searchType"));
		System.out.println(map.get("keyword"));
		List<BookVO> list = sqlSessionTemplate.selectList("selectBySearch", map);
		return list;
	}
}