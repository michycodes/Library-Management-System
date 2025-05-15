public class Book {
    String title;
    String author;
    int Id;
    boolean isBorrowed;

    //constructor
    public Book(String title, String author, int Id){
        this.title = title;
        this.author = author;
        this.Id = Id;
    }
    //borrow books
    public void borrow(){
        isBorrowed = true;
    }
    //return books
    public void returnBook(){
        isBorrowed = false;
    }
    // turn into a string
    public String toString(){
        return Id + " - " + title + " by " + author + (isBorrowed ? " [BORROWED]" : " [AVAILABLE]");
    }
}
