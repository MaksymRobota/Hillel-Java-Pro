package app.parser_h11;

import java.util.Scanner;

public class UserInputHandler {
    public String getBookNameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the book (with extension, e.g., book.txt):");
        return scanner.nextLine();
    }
}
