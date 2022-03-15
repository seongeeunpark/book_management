package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AlreadyExistingBookException;
import spring.BookVO;
import spring.BookRegisterService;
import spring.RegisterRequest;

@Controller
@RequestMapping("/add")
public class RegisterController {
	private BookRegisterService bookRegisterService;
	public void setBookRegisterService(BookRegisterService bookRegisterService) {
		this.bookRegisterService = bookRegisterService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String handle1(@ModelAttribute("formData") BookVO bookVO) {
		return "/book_reg_form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String handle2(@ModelAttribute("formData") RegisterRequest regReq, HttpServletRequest request, Errors errors) throws Exception {
		new RegisterValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
			return "/book_reg_form";
		}
		
		try {
			bookRegisterService.regist(regReq, request);
			return "redirect:/list";
			
		} catch(AlreadyExistingBookException e) {
			e.printStackTrace();
			return "/book_reg_form";
		}
		
	}
}
