package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.BookVO;
import spring.BookDAO;

@Controller
public class DetailController {
	private BookDAO bookDAO;
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	@RequestMapping("/detail/{num}")
	public String detail(@PathVariable("num") int num, Model model) {
		BookVO bookVO = bookDAO.selectByNum(num);
		if(bookVO == null) {
			
		}
		model.addAttribute("book", bookVO);
		return "book_detail";
	}
}
