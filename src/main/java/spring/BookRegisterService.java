package spring;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class BookRegisterService {
	private BookDAO bookDAO;
	
	public BookRegisterService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public void regist(RegisterRequest req, HttpServletRequest request) throws IllegalStateException, IOException {
		BookVO bookVO = (BookVO) bookDAO.selectByIsbn(req.getIsbn());
		if(bookVO != null) {
			throw new AlreadyExistingBookException("dup isbn" + req.getIsbn());
		}
		
		String filename = null;
		MultipartFile image = req.getImage();
		
		if(!image.isEmpty()) {
			String originalFileName = image.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);
			String realpath = request.getSession().getServletContext().getRealPath("/");
			String webpath = "/upload";
			UUID uuid = UUID.randomUUID();
			
			
			filename = uuid + "." + ext;
			
			
			File makeFolder = new File(realpath + webpath);
			if(!makeFolder.exists()) {
				makeFolder.mkdir();
			}
			
			System.out.println(realpath + webpath + filename);
			
			image.transferTo(new File(realpath + webpath +"/"+ filename));
		}
		
		req.setUploadFile(filename);
		
		BookVO bookVo = new BookVO(req.getIsbn(), req.getName(), req.getAuthor(), req.getPublisher(),
				req.getPrice(), req.getUploadFile(), req.getIntroduction());
		bookDAO.insert(bookVo);
	}
	
}
