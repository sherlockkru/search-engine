package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchEngine searchEngine = new SearchEngine(scanner);
        UserInterface userInterface = new UserInterface(scanner, searchEngine);
        userInterface.start(args);
    }
}