
public class book {

	private String bookName;
	private String genre;
	private String author;
	private String status; //1-Checked Out, 2-Checked In, 3-Reserved
	
	
	
	public book(String bookName, String genre, String author, String status) {
		this.bookName = bookName;
		this.genre = genre;
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public String getGenre() {
		return genre;
	}

	public String getAuthor() {
		return author;
	}
	
	public String getStatus() {
		return status;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public void printInfo() {
		System.out.println("Book Name: " + getBookName());
		System.out.println("Genre: " + getGenre());
		System.out.println("Author: " + getAuthor());
		System.out.println("Status: ");
		
		
		switch(status) {
		
		case 1: System.out.println("Checked Out");
				break;
				
		case 2: System.out.println("Checked In");
				break;
				
		case 3: System.out.println("Reserved");
				break;
			
		}
		
	}
	
	
}
