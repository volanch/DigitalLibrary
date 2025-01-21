import Controller.BookController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final BookController controller;
    private final Scanner scanner;

    public App(BookController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Book Management System");
        while (true) {
            System.out.println();
            System.out.println("Please enter your choice:");
            System.out.println("1. Add a new book");
            System.out.println("2. Update book");
            System.out.println("3. Delete book");
            System.out.println("4. Get all books");
            System.out.println("5. Get book by id");
            System.out.println("6. Exit");
            System.out.println();

            try{
                int choice = scanner.nextInt();
                if (choice == 1) {
                    createBookMenu();
                } else if (choice == 2) {
                    updateBookMenu();
                }else if (choice == 3) {
                    deleteBookMenu();
                } else if (choice == 4) {
                    getAllBooksMenu();
                } else if (choice == 5) {
                    getBookMenu();
                } else{
                    break;
                }
                } catch (InputMismatchException e) {
                System.out.println("Please enter a valid choice");
                scanner.nextInt();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void createBookMenu() {
        System.out.println("Please enter the title of the book");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Please enter the author of the book");
        String author = scanner.nextLine();
        System.out.println("Please enter the year of the book");
        int year = scanner.nextInt();

        String response = controller.createBook(title, author, year);
        System.out.println(response);
    }

    public void getAllBooksMenu() {
        String response = controller.getAllBooks();
        System.out.println(response);
    }

    public void getBookMenu() {
        System.out.println("Please enter the id of the book");
        int id = scanner.nextInt();
        String response = controller.getBook(id);
        System.out.println(response);
    }

    public void updateBookMenu() {
        System.out.println("Please enter the id of the book and the real title of the book");
        int id = scanner.nextInt();
        String title = scanner.nextLine();
        String response = controller.updateBook(id, title);
        System.out.println(response);
    }

    public void deleteBookMenu() {
        System.out.println("Please enter the id of the book");
        int id = scanner.nextInt();
        String response = controller.deleteBook(id);
        System.out.println(response);
    }
}
