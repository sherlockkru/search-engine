package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SearchAll implements SearchStrategy {
    ArrayList<Person> toPrint = new ArrayList<>();
    ArrayList<Person> noPrint = new ArrayList<>();
    @Override
    public void searchPerson(ArrayList<Person> persons, HashMap<String, ArrayList<Integer>> indexOfPerson, String dataToSearch) {

        String[] keywords = dataToSearch.split(" ");
        for (int i = 0; i < keywords.length; i++) {
            if (indexOfPerson.containsKey(keywords[i])) {
                for (Integer num : indexOfPerson.get(keywords[i])) {
                    if (!toPrint.contains(persons.get(num))) {
                        toPrint.add(persons.get(num));
                    }
                }
            }
        }
        for (Person person : toPrint) {
            for (int i = 0; i < keywords.length; i++) {
                if (!person.getFirstName().equals(keywords[i].toLowerCase()) && !person.getLastName().equals(keywords[i].toLowerCase()) && !person.getEmail().equals(keywords[i].toLowerCase())){
                    noPrint.add(person);
                }
            }
        }
        for (Person person : toPrint) {
            if (!noPrint.contains(person)){
                System.out.println(person);
            }
        }
    }
}