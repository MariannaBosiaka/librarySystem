package librarySystem;

public class Books {

	private String title;
	private String author;
	private String pubMonth;
	private String pubYear;
	private String publisher;
	
	
	public Books() {
		
	}
	
	public Books(String title, String author, String pubMonth, String pubYear, String publisher) {
		
		title = this.title;
		author = this.author;
		pubMonth = this.pubMonth;
		pubYear = this.pubYear;
		publisher = this.publisher;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPubMonth() {
		return pubMonth;
	}

	public void setPubMonth(String pubMonth) {
		this.pubMonth = pubMonth;
	}

	public String getPubYear() {
		return pubYear;
	}

	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void printDetailsOfBook() {
		
		System.out.println("-------------------------------------");
		System.out.println("|Title: " + title + "               |");
		System.out.println("|Author: " + author + "             |");
		System.out.println("|Publication month: " +pubMonth + " |");
		System.out.println("|Publication year: "+pubYear + "    |");
		System.out.println("|Publisher: "+publisher + "         |");
		System.out.println("-------------------------------------");
		System.out.println();
	}

}


