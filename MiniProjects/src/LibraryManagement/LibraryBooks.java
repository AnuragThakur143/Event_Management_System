package LibraryManagement;

public class LibraryBooks {
	
	private String bookTitle;
	private String authorName;
	private int numberOfPages;
	private boolean isBorrowed;
	
	public LibraryBooks(String title, String author, int numberOfPages) {
		this.bookTitle = title;
	    this.authorName = author;
	    this.numberOfPages = numberOfPages;
	    this.isBorrowed = false;
	    }
	
	public void borrowBook(int daysBorrowed) {
		if (!isBorrowed) {
			isBorrowed = true;
	        System.out.println("The book has been borrowed for " + daysBorrowed + " days.");
	        double lateFee = calculateLateFee(daysBorrowed);
	        System.out.println("Estimated late fee: $" + lateFee);
	        }
		else {
			System.out.println("Already borrowed.");
			}
		}
	
	public void returnBook() {
		if (isBorrowed) {
			isBorrowed = false;
			System.out.println("The book is returned.");
	        }
		else {
			System.out.println("The book wasn't borrowed.");
			}
		}
	public void read(int currentPage, int pagesToRead) {
		if (currentPage + pagesToRead <= numberOfPages) {
			System.out.println("You read " + pagesToRead + " pages from page " + currentPage + ".");
	        }
		else {
			System.out.println("You've reached the end.");
			}
		}
	
	private double calculateLateFee(int daysBorrowed) {
		double feePerDay = 0.50;
		return daysBorrowed * feePerDay;
		}
	
	public void displayBookDetails() {
		System.out.println("Title Name: " + bookTitle);
	    System.out.println("Author Name: " + authorName);
	    System.out.println("No. of Pages: " + numberOfPages);
	    System.out.println("Is borrowed: " + isBorrowed);
	    }
	
	public static void main(String[] args) {
		
		LibraryBooks book = new LibraryBooks("The Alchemist", "Paulo Coelho", 224);
		
		book.displayBookDetails();
		
		book.borrowBook(6);
		
		book.read(50, 70);
		
		book.returnBook();
		
		book.displayBookDetails();
		}
	}
