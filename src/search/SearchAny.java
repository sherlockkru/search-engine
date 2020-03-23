package search;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchAny implements SearchStrategy {
    ArrayList<Person> toPrint = new ArrayList<>();

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
            System.out.println(person);
        }
    }
}
