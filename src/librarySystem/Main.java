package librarySystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	private ArrayList<Books> booksList = new ArrayList<Books>();
	private ArrayList<People> peopleList = new ArrayList<People>();
	private Scanner consoleIn = new Scanner(System.in);

	private char ansBookAdd;	
	private char ansMemberAdd;
	private int count = 0;
	private ObjectOutputStream dataBase;

	public static void main(String[] args) {
		
		//creating a main instance
		Main mainProg = new Main();
		mainProg.menu1();
		

	}
	
	public Main() {
		//here are the main's methods for execution
		//menu();
	}
	public void menu1(){
		
		//int count = 0;

		System.out.println("----------------------------------");
		System.out.println("| WELCOME TO MARIANNA'S LIBRARY! |");
		System.out.println("----------------------------------");
		System.out.println();
		System.out.println("             - MENU -             ");
		System.out.println();
		System.out.println("             Log in               ");
		System.out.println();
		
		do {
		System.out.println("        To log in press x         ");
		char answer = consoleIn.next().charAt(0);
		
		switch(answer) {
			case 'x':
				logInLib();
				break;
			default:
				System.out.println("Enter a valid number: ");
				count++;
			}
		}while(count!=0);
	}
	//after the log in of the librarians this menu will appear
	public void menu2() {
		
		System.out.println("             - MENU -             ");
		System.out.println();
		System.out.println("    1.  Create new base           ");
		System.out.println("    2.  Members                   ");
		System.out.println("    3.  Librarians                ");
		System.out.println("    4.  Books                     ");
		System.out.println();
		
		do {
			System.out.println("    Insert your choice (1 to 4):  ");
			int numChoice2 = consoleIn.nextInt();
						
			switch(numChoice2) {
				case 1:
					createDataBase();
					break;
				case 2:
					membersListMenu();
					break;
				case 3:
					librariansListMenu();
					break;
				case 4:
					bookListMenu();
					break;
				default:
					System.out.println("Enter a valid number..");
					count++;
				}
			}while(count!=0);
		}
	
	//method for the 4th option of menu2() method
	public void bookListMenu() {
		
		System.out.println("             - MENU -             ");
		System.out.println();
		System.out.println("    1.  Add a book                ");
		System.out.println("    2.  Search for a book/books   ");
		System.out.println("    3.  List of books         ");
		System.out.println();
		
		do {
			System.out.println("    Insert your choice (1 to 3):  ");
			int numChoice3 = consoleIn.nextInt();
			
			
			switch(numChoice3) {
				case 1:
					addBookToList();
					break;
				case 2:
					System.out.println("PLEASE LET THIS WORK");
					break;
				case 3:
					printListOfBooks();
					break;
				default:
					System.out.println("Enter a valid number..");
					count++;
				}
			}while(count!=0);
	}
	
	public void membersListMenu() {
		
		System.out.println("             - MENU -             ");
		System.out.println();
		System.out.println("    1.  Add a member               ");
		System.out.println("    2.  List of members            ");
		
		do {
			System.out.println("    Insert your choice (1 or 2):  ");
			int numChoice4 = consoleIn.nextInt();
			
			
			switch(numChoice4) {
				case 1:
					addMemberToList();
					break;
				case 2:
					printListOfPeople();
					break;
				default:
					System.out.println("Enter a valid number..");
					count++;
				}
			}while(count!=0);
		
	}
	
	public void librariansListMenu() {
		
		System.out.println("             - MENU -             ");
		System.out.println();
		System.out.println("    1.  Add a librarian               ");
		System.out.println("    2.  List of librarians            ");
		
		do {
			System.out.println("    Insert your choice (1 or 2):  ");
			int numChoice4 = consoleIn.nextInt();
			
			
			switch(numChoice4) {
				case 1:
					addLibrarianToList();
					break;
				case 2:
					printListOfPeople();
					break;
				default:
					System.out.println("Enter a valid number..");
					count++;
				}
			}while(count!=0);
	}
	
	public void createDataBase() {
		
		try {
			File fileCheck = new File("C:\\Users\\Ìבסיב\\eclipse-workspace\\librarySystem");
			String[] allFiles = fileCheck.list();
			for(String fileZ : allFiles) {
				if(fileZ.endsWith(".mg")){
					System.out.println("You have a data base already created!");	
				}
				else {
					System.out.println("Enter a name for your new file: ");
					System.out.println("Example: mybase (without an ending)");
					String fileName = consoleIn.next();
					
					FileOutputStream f = new FileOutputStream(new File(fileName + ".mg"));
					dataBase = new ObjectOutputStream(f);
					System.out.println("Base was successfully created!");
				}
					
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	//log in method for the librarians
	//missing if else to check existence
	public void logInLib() {
		
		System.out.println("\t-- LOG IN (librarians) --\t");
		System.out.println();
		
		System.out.print("\t   Enter your username:");
		String userName = consoleIn.next();
		System.out.println();
		
		System.out.print("\t   Enter your password:");
		String passwrd = consoleIn.next();
		System.out.println();
		
		menu2();
				
	}
	
public void addBookToList() {
		
		Books tmpBook = new Books();
		
		while(ansBookAdd != 'n') {
			
			System.out.print("Enter the book title: ");
			tmpBook.setTitle(consoleIn.next()); 
			System.out.print("Enter the author: ");
			tmpBook.setAuthor(consoleIn.next());
			System.out.print("Enter the publication month: ");
			tmpBook.setPubMonth(consoleIn.next()); 
			System.out.print("Enter the publication year: ");
			tmpBook.setPubYear(consoleIn.next());
			System.out.print("Enter the publisher: ");
			tmpBook.setPublisher(consoleIn.next());
			
			booksList.add(tmpBook);
			
			System.out.println("Do you wish to continue adding books? ");
			System.out.print("Press y or n: ");
			ansBookAdd = consoleIn.next().charAt(0);
	
		}
		
//		try {
//			System.out.println("Enter the name of the file you want to save the list to: ");
//			String fileName = consoleIn.next();
//			
//			
//		}
//		catch(IOException e){
//			
//			e.printStackTrace();
//			
//		}
		
		bookListMenu();
		
	}

public void addMemberToList() {
	
	while(ansMemberAdd != 'n') {
		
		Members tmpMember = new Members();
		
		System.out.print("Enter the member's name: ");
		tmpMember.setName(consoleIn.next());
		System.out.print("Enter the age: ");
		tmpMember.setAge(consoleIn.nextInt()); 
		System.out.print("Enter the address: ");
		tmpMember.setAddress(consoleIn.next()); 
		System.out.print("Enter the phone number: ");
		tmpMember.setPhoneNum(consoleIn.nextLong());
		
		peopleList.add(tmpMember);
		
		System.out.println("Do you wish to continue adding members? ");
		System.out.print("Press y or n: ");
		ansMemberAdd = consoleIn.next().charAt(0);
		
	}
	
	membersListMenu();
	
}

public void addLibrarianToList() {

	while(ansMemberAdd != 'n') {
		
		Librarians tmpLibrarian = new Librarians();
		
		System.out.print("Enter the Librarian's name: ");
		tmpLibrarian.setName(consoleIn.next());
		System.out.print("Enter the age: ");
		tmpLibrarian.setAge(consoleIn.nextInt()); 
		System.out.print("Enter the address: ");
		tmpLibrarian.setAddress(consoleIn.next()); 
		System.out.print("Enter the phone number: ");
		tmpLibrarian.setPhoneNum(consoleIn.nextLong());
		
		peopleList.add(tmpLibrarian);
		
		System.out.println("Do you wish to continue adding members? ");
		System.out.print("Press y or n: ");
		ansMemberAdd = consoleIn.next().charAt(0);
		
		}
	
		librariansListMenu();
	}
	

public void printListOfBooks() {

	 for (Books books : booksList) {
		 
		 books.printDetailsOfBook();
		
	 	}
	
	}
public void printListOfPeople() {

	 for (People people : peopleList) {
		 
		 people.printDetailsOfPerson();
		 
	 	}
	
	}
}
