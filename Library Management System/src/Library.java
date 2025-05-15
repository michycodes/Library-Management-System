//in order to use the io library, we have to import this
import java.io.*;
//in order to use the array, we have to import this
import java.util.*;

public class Library {
    List<Book> books = new ArrayList<>();
    //add books

    public void addBook(Book book) {
        books.add(book);
    }

    //show books(this loops through the books and prints it)
    public void showBooks() {
        books.forEach(System.out::println);//short way of writing it
    }

    //find books by Id
    public Book findBookById(int Id){
        for (Book book : books){
            if(book.Id == Id){
                return book;
            }
        }
        return null;
    }

    //borrow books

    public void borrowBook(int Id) {
        Book book = findBookById(Id);
        if (book != null && !book.isBorrowed){// check if books exists and is not borrowed
            book.borrow();
            System.out.println("you borrowed: "+ book.title);
        }
        else{
            System.out.println("book not found or was already borrowed");
        }
    }

    //return books
    public void returnBook(int Id) {
        Book book = findBookById(Id);
        if (book != null && book.isBorrowed){// if the book exists and if it has been boorwed
            book.returnBook();
            System.out.println("you returned: "+ book.title);
        }
        else{
            System.out.println("book not found or wasn't borrowed");
        }
    }
    //save to file

    public void saveToFile(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(filename);// printer writer is used to write formatted text into files easily
        for (Book book :books) {
            writer.println(book.Id + ";" + book.title + ";" + book.author + ";" + book.isBorrowed);
        }
        writer.close();
    }

    //load from file
    public void loadFromFile(String filename) throws IOException {
        books.clear();// removes any books in the list
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(";");
            if (parts.length == 4) {//ensures it has 4 parts(id, title,author,status)
                Book book = new Book(parts[1], parts[2], Integer.parseInt(parts[0]));
                if (Boolean.parseBoolean(parts[3])) {
                    book.borrow();
                }
                books.add(book);
            }
        }
        scanner.close();
    }
}
