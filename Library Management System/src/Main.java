import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        String filename = "books.txt";

        //loading existing books
        try {
            library.loadFromFile(filename);
            System.out.println("Books loaded");
        } catch (Exception e) {
            System.out.println("No saved file found. Starting with empty library.");
        }

        // Main menu loop
        while (true) {
            System.out.println("\n === Library Menu ===");
            System.out.println("1. Show all books");
            System.out.println("2. Add a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Save & Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.addBook(new Book(title, author, id));
                    System.out.println("Book added.");
                    break;

                case 3:
                    System.out.print("Enter book id to borrow: ");
                    int borrowId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.borrowBook(borrowId);
                    break;

                case 4:
                    System.out.print("Enter book id to return: ");
                    int returnId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.returnBook(returnId);
                    break;

                case 5:
                    try {
                        library.saveToFile(filename);
                        System.out.println("library saved");
                    } catch (Exception e) {
                        System.out.println("error saving library");
                    }
                    return;

                default:
                    System.out.println("invalid option");
            }
        }
    }
}
