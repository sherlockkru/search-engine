package search;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchNone implements SearchStrategy {
    ArrayList<Person> noPrint = new ArrayList<>();

    @Override
    public void searchPerson(ArrayList<Person> persons, HashMap<String, ArrayList<Integer>> indexOfPerson, String dataToSearch) {
        String[] keywords = dataToSearch.split(" ");
        for (int i = 0; i < keywords.length; i++) {
            if (indexOfPerson.containsKey(keywords[i])) {
                for (Integer num : indexOfPerson.get(keywords[i])) {
                    if (!noPrint.contains(persons.get(num))) {
                        noPrint.add(persons.get(num));
                    }
                }
            }
        }
        for (Person person: persons) {
            if (!noPrint.contains(person)){
                System.out.println(person);
            }
        }
    }
}
