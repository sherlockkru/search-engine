package search;

import java.util.ArrayList;
import java.util.HashMap;

public class Search {
    private SearchStrategy searchStrategy;

    public Search(SearchStrategy strategy){
        this.searchStrategy = strategy;
    }

    public void find(ArrayList<Person> persons, HashMap<String, ArrayList<Integer>> indexOfPerson, String dataToSearch){
        searchStrategy.searchPerson(persons, indexOfPerson, dataToSearch);
    }
}
