package search;

import java.util.ArrayList;
import java.util.HashMap;

public interface SearchStrategy {
    void searchPerson(ArrayList<Person> persons, HashMap<String, ArrayList<Integer>> indexOfPerson, String dataToSearch);
}
