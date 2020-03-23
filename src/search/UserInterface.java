package search;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private SearchEngine searchEngine;

    public UserInterface(Scanner scanner, SearchEngine searchEngine) {
        this.scanner = scanner;
        this.searchEngine = new SearchEngine(scanner);
    }

    public String commandLineArgs(String[] args) {
        String file = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--data")) {
                file = args[i + 1];
            }
        }
        return file;
    }

    public void start(String[] args) {
        searchEngine.fileToArraylist(this.commandLineArgs(args));
        searchEngine.toHashMap();
        boolean exit = false;
        while (exit == false) {
            System.out.println("");
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person.");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            int command = Integer.valueOf(scanner.nextLine());

            switch (command) {
                case 1:
                    searchEngine.findAPerson();
                    break;
                case 2:
                    searchEngine.printAllPeople();
                    break;
                case 0:
                    exit = true;
                    System.out.println("");
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        }
    }
}
