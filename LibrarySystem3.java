import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LibrarySystem3 {
	static void PrintLinkedList(LinkedList<book> LibraryBookDatabase) {
		int i;
		
		for(i = 0; i < LibraryBookDatabase.size(); ++i){
		LibraryBookDatabase.get(i).printInfo(); System.out.println();
	
		
		}
		
		
		
	}
	

	

	public static void main(String[] args) {
		
		String fileName = "LibraryBooks";
		int choice;
		LinkedList <book> LibraryBookDatabase = new LinkedList<>();
		int count = 0;
		Scanner userInput = new Scanner(System.in);

		try {
			
			File file = new File (fileName);
			Scanner filereader = new Scanner(file);
			
			
			while(filereader.hasNextLine()) {
				String bookName = filereader.nextLine();
				String genre = filereader.nextLine();
				String author = filereader.nextLine();
				String status = filereader.nextLine();
				
				book temp = new book(bookName, genre, author, status);
				
				LibraryBookDatabase.add(temp);
				count++;
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		
			

		} //end of file input
		
		
		//////////////////////////////////////////////////////////////////////////////
		
		do {
			choice = LibrarySystemOptions();
			switch (choice) {
			
			case 1:	System.out.println("Displaying all books in the System");
					PrintLinkedList(LibraryBookDatabase);
					break;
					
					////////////////////////////////////////////////////////////////////////////
					
			case 2: System.out.println("--------------------SEARCH BY BOOKNAME----------------");
					
					int indexFound1 = 0;
					boolean bookFound = false;
					
					do {
						
						System.out.println("Enter the Book name you want to search:");
						
						String userBookName = userInput.next();
					
						for (int j = 0; j < LibraryBookDatabase.size(); j++) {
							if(LibraryBookDatabase.get(j).getBookName().equals(userBookName)) {
							indexFound1 = j;
							bookFound = true;
							
							
							}
						
							if(bookFound) 
							{
							System.out.println("Here are the results:\n");
							System.out.println("Book name: " + LibraryBookDatabase.get(indexFound1).getBookName());
							System.out.println("Genre: " + LibraryBookDatabase.get(indexFound1).getGenre());
							System.out.println("Author: " + LibraryBookDatabase.get(indexFound1).getAuthor());
							System.out.println("Status: " + LibraryBookDatabase.get(indexFound1).getStatus());
							break;							
							}
						
							else if (!bookFound) 
							{
								System.out.println("Book not Found\n");
								break;
								//Should go back to "Enter the Book" again
							
							}
					}
					
					
					}while(bookFound != true);
					
					break;
					
					///////////////////////////////////////////////////////////////////////////////
					
			case 3: System.out.println("----------------------SEARCH BY GENRE-------------------");
					int indexFound2 = 0;
					boolean genreFound = false;
					
					do {
						
						System.out.println("Enter the Genre you want to search:");
						String userGenre = userInput.next();
						
						for (int g = 0; g < LibraryBookDatabase.size(); g++) {
							if(LibraryBookDatabase.get(g).getGenre().equals(userGenre)) {
								indexFound2 = g;
								genreFound = true;
								
							}
							
							if(genreFound)
							{
								System.out.println("Here are the results:\n");
								System.out.println("Book Name: " + LibraryBookDatabase.get(g).getBookName());
								System.out.println("Genre: " + LibraryBookDatabase.get(g).getGenre());
								System.out.println("Author: " + LibraryBookDatabase.get(g).getAuthor());
								break;
							}
							else if(!genreFound) {
								System.out.println("Genre not Found\n");
								break;
							}
						}
					}while(genreFound != true);
					
					break;
					
					/////////////////////////////////////////////////////////////////////////////////
					
			case 4: System.out.println("-------------------SEARCH BY AUTHOR--------------------");
					int indexFound3 = 0;
					boolean authorFound = false;
					
					do {
						
						System.out.println("Enter the Author you want to search:\n");
						String userAuthor = userInput.next();
						
						for(int a = 0; a < LibraryBookDatabase.size(); a++) {
							if (LibraryBookDatabase.get(a).getAuthor().equals(userAuthor)) {
								indexFound3 = a;
								authorFound = true;
							}
							
							if(authorFound) 
							{
								System.out.println("Here are the results");
								System.out.println("Book Name: " + LibraryBookDatabase.get(a).getBookName());
								System.out.println("Genre: " + LibraryBookDatabase.get(a).getGenre());
								System.out.println("Author: " + LibraryBookDatabase.get(a).getAuthor());
							}
						}
						
					}while(authorFound != true);
					
					
					break;
					
					/////////////////////////////////////////////////////////////////////////
					
			case 5: System.out.println("--------------------ADD A BOOK--------------------");
					String newBookName = "";
					String newGenre = "";
					String newAuthor = "";
					String newStatus = "";
					boolean newGenreExists = false;
					boolean bookExist = false;
					
					int indexFound4 =0;
					
					do {
						System.out.println("Enter the name of the new book:");
						newBookName = userInput.next();
						
						for(int x = 0; x < LibraryBookDatabase.size(); x++) {
							if(newBookName.equals(LibraryBookDatabase.get(x).getBookName())) {
								System.out.println("Book already exists in the Database!");
								bookExist = true;
							}
							
							
					}
						
						if(!bookExist) {
							System.out.println("Enter the genre of the book:");
							newGenre = userInput.next();
							newGenreExists = true;
							
							
							
						}
						
						//checks if a new genre is inputed, supposed stop double print out of requested inputs from user
						if(newGenreExists) {
							System.out.println("Enter the author of the author:");
							newAuthor = userInput.next();
							newStatus = "Checked In";
							break;
						}
						
							
						
					}while(bookExist != true);
				
					
					book temp = new book(newBookName,newGenre,newAuthor, newStatus);
					
					LibraryBookDatabase.add(temp);//writes new book to file
					
					break;
					/////////////////////////////////////////////////////////////////
			
			case 6: System.out.println("-------------REMOVE A BOOK--------------------");
			
					String removeBook = "";
					boolean existedBook = false;
					
			
					do {
						
						System.out.println("Enter the title of the book you want to remove:");
						removeBook = userInput.next();
						
						for (int r = 0; r < LibraryBookDatabase.size(); r++) {
							if (removeBook.equals(LibraryBookDatabase.get(r).getBookName())) {
								existedBook = true;
							}
							
							if(existedBook) {
								System.out.println("Removing from the Database:");
								System.out.println("Book Name: " + LibraryBookDatabase.get(r).getBookName());
								System.out.println("Genre:" + LibraryBookDatabase.get(r).getGenre());
								System.out.println("Author: " + LibraryBookDatabase.get(r).getAuthor());
								
								LibraryBookDatabase.remove(LibraryBookDatabase.get(r));
								break;
							}
							
							if(!existedBook) {
								System.out.println("The Book does not exist in the Database");
								System.out.println("\n Going to back to Library Menu");
								
								break;
								
							}
							
						}
						
						
					}while(existedBook != true);
					
					break;
			
					/////////////////////////////////////////////////////////////////
					
			case 7: System.out.println("-------------------CHECK OUT A BOOK------------------------");
			
					String checkOutBook = "";
					boolean alreadyCheckedOut = false;
					boolean alreadyCheckedIn = false;
					boolean alreadyReserved = false;
					int indexFound7;
					boolean checkout = false;
					
					for (int out = 0; out < LibraryBookDatabase.size(); out++) {
						
						if(checkOutBook.equals(LibraryBookDatabase.get(out).getBookName())) {
							indexFound7 = out;
							
							
						}
					}
					
					
					
					
					/////////////////////////////////////////////////////////////////////
					
			case 10: System.out.println("------------------SAVING DATABASE -----------------------");
				
					System.out.println("Library Book System Exiting");
			
			
					try {
						PrintWriter writer = new PrintWriter("LibraryBooks");
						for (int w = 0; w < LibraryBookDatabase.size(); w++) {
							writer.println(LibraryBookDatabase.get(w).getBookName());
							writer.println(LibraryBookDatabase.get(w).getGenre());
							writer.println(LibraryBookDatabase.get(w).getAuthor());
							writer.println(LibraryBookDatabase.get(w).getStatus());
						}
						
						writer.close();
					}
					catch (FileNotFoundException e)
					{
						System.out.println("Error opening the file " + fileName);
						
						System.exit(0);
					}
					catch (IOException e) {
						
						e.printStackTrace();
					}
					
					
					System.exit(0);
					break;
					
			case 11: System.exit(0);
			
			}
		}while(choice != 11);
		
		
		
	}
		
///////////////////////////////////////////////////////////
	static int LibrarySystemOptions() {
		
		int ch = 0;;
		
		
		boolean invalidChoice;
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.println("\n--------------------------\n");
			System.out.println("1.Print all Books in the System");
			System.out.println("2.Search by Book Name");
			System.out.println("3.Search by genre");
			System.out.println("4.Search by author");
			System.out.println("5.Add a book to the Database");
			System.out.println("6.Remove a book fromt the Database");
			System.out.println("7.Check out a Book");
			System.out.println("8.Check in a Book");
			System.out.println("9.Reserve a Book");
			System.out.println("10.Save and exit");
			System.out.println("11.System exit"); //without saving the system
			
			System.out.println("Choice (1-11):");
			ch = keyboard.nextInt();
			
			invalidChoice = (ch < 1 || ch > 11);
			
			if(invalidChoice ) {
				System.out.println("INVALID CHOICE! Please try again! (1-8)");
				
			}
		}while(invalidChoice);
	
		
		return ch;
	}
}
