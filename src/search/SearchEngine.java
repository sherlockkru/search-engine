package search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchEngine {
    private ArrayList<Person> persons;
    private Scanner scanner;
    private HashMap<String, ArrayList<Integer>> indexOfPerson;
    private Search searchStrategy;

    public SearchEngine(Scanner scanner) {
        this.persons = new ArrayList<>();
        this.scanner = scanner;
        this.indexOfPerson = new HashMap<>();
    }

    public void fileToArraylist(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                String words[] = word.split(" ");
                String firstName = words[0];
                if (words.length == 1) {
                    persons.add(new Person(firstName));
                }
                if (words.length == 2) {
                    String lastName = words[1];
                    persons.add(new Person(firstName, lastName));
                }
                if (words.length == 3) {
                    String lastName = words[1];
                    String email = words[2];
                    persons.add(new Person(firstName, lastName, email));
                }
            }
        } catch (IOException e) {
            System.out.println("Cannon read file:" + e.getMessage());
        }
    }

    public void toHashMap() {
        for (Person person : persons) {
            indexOfPerson.putIfAbsent(person.getFirstName().toLowerCase(), new ArrayList<Integer>());
            indexOfPerson.get(person.getFirstName().toLowerCase()).add(persons.indexOf(person));
            indexOfPerson.putIfAbsent(person.getLastName().toLowerCase(), new ArrayList<Integer>());
            indexOfPerson.get(person.getLastName().toLowerCase()).add(persons.indexOf(person));
            if (!person.getEmail().equals("")) {
                indexOfPerson.putIfAbsent(person.getEmail().toLowerCase(), new ArrayList<Integer>());
                indexOfPerson.get(person.getEmail().toLowerCase()).add(persons.indexOf(person));
            }
        }
    }

    public void findAPerson() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategyType = scanner.nextLine();
        switch (strategyType) {
            case "ALL":
                searchStrategy = new Search(new SearchAll());
                break;
            case "ANY":
                searchStrategy = new Search(new SearchAny());
                break;
            case "NONE":
                searchStrategy = new Search(new SearchNone());
                break;
            default:
                break;
        }
        if (searchStrategy == null) {
            System.out.println("Unknown strategy type passed.");
        }
        System.out.println("Enter a name or email to search all suitable people.");
        String dataToSearch = scanner.nextLine().toLowerCase();
        searchStrategy.find(persons, indexOfPerson, dataToSearch);
    }

    public void printAllPeople() {
        System.out.println("");
        System.out.println("=== List of people ===");
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}