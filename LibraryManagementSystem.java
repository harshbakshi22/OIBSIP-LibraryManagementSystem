import java.util.*;

class Book {
    String title;
    boolean isIssued;

    Book(String title) {
        this.title = title;
        this.isIssued = false;
    }
}

public class LibraryManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("📚 Welcome to Digital Library Management System");

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Remove Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addBook(); break;
                case 2: displayBooks(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5: removeBook(); break;
                case 6:
                    System.out.println("👋 Exiting Library. Thank you!");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }

    public static void addBook() {
        System.out.print("Enter book title to add: ");
        String title = sc.nextLine();
        books.add(new Book(title));
        System.out.println("✅ Book added successfully.");
    }

    public static void displayBooks() {
        System.out.println("📖 Available Books:");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book b : books) {
                System.out.println("- " + b.title + (b.isIssued ? " (Issued)" : " (Available)"));
            }
        }
    }

    public static void issueBook() {
        System.out.print("Enter book title to issue: ");
        String title = sc.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("✅ Book issued successfully.");
                    return;
                } else {
                    System.out.println("❌ Book already issued.");
                    return;
                }
            }
        }
        System.out.println("❌ Book not found.");
    }

    public static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = sc.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("✅ Book returned successfully.");
                    return;
                } else {
                    System.out.println("❌ This book was not issued.");
                    return;
                }
            }
        }
        System.out.println("❌ Book not found.");
    }

    public static void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = sc.nextLine();
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.title.equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("🗑️ Book removed successfully.");
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }
}