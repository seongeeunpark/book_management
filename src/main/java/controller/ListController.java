package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.BookVO;
import spring.BookDAO;

@Controller
public class ListController {
	private BookDAO bookDAO;
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		List<BookVO> book = bookDAO.selectAll();
		model.addAttribute("book", book);
		return "/book_list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String list(@ModelAttribute("condition")ListCommand listCommand , Model model) {
		if(listCommand.getKeyword() != null) {
			List<BookVO> book = bookDAO.selectBySearch(listCommand.getKeyword(),listCommand.getSearchType());
			System.out.println(listCommand.toString());
			model.addAttribute("book", book);
			System.out.println(model.toString());
			return "book_list";
		}
		return "book_list";
	}
}
