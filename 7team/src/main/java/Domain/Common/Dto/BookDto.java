package Domain.Common.Dto;

public class BookDto {

	private String bookcode;
	private String bookname;
	private String author;
	private String publisher;
	private int pubdate;
	
	public BookDto() {}

	@Override
	public String toString() {
		return "BookDto [bookcode=" + bookcode + ", bookname=" + bookname + ", author=" + author + ", publisher="
				+ publisher + ", pubdate=" + pubdate + "]";
	}

	public BookDto(String bookcode, String bookname, String author, String publisher, int pubdate) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.author = author;
		this.publisher = publisher;
		this.pubdate = pubdate;
	}

	public String getBookcode() {
		return bookcode;
	}

	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
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

	public int getPubdate() {
		return pubdate;
	}

	public void setPubdate(int pubdate) {
		this.pubdate = pubdate;
	}

	
}
