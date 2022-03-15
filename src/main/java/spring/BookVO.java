package spring;

public class BookVO {
	private int num;
	private String isbn;
	private String name;
	private String author;
	private String publisher;
	private int price;
	private String image;
	private String introduction;

	
	public BookVO(String isbn, String name, String author, String publisher, int price, String image,
			String introduction) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.image = image;
		this.introduction = introduction;
	}
	
	public BookVO() {
		super();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
}
