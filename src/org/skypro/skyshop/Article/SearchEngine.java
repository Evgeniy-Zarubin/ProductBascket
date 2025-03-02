package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchableItems;

    public SearchEngine() {
       searchableItems = new ArrayList<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> result = new ArrayList<>();

        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().contains(searchTerm)) {
                result.add(item);
                System.out.println(item.getStringRepresentation());
            }
        }
        return result;
    }

    public Searchable findBestMatch (String search) throws BestResultNotFound {
         if (searchableItems.isEmpty() || search == null || search.isEmpty()) {
            throw new BestResultNotFound("Поисковая строка пуста или список объектов пуст");
        }
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : searchableItems) {
            if (item != null){
                int occurrences = countOccurrences(item.getSearchTerm(),search);
                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    bestMatch = item;
                }

            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено совпадений для строки '" + search + "'");
        }
        return bestMatch;

    }

    private int countOccurrences (String text, String search) {
        int index = 0;
        int count = 0;
        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }
        return count;
    }

}
