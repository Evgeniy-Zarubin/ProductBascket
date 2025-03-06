package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private final TreeMap<String, List<Searchable>> searchableItems;

    public SearchEngine() {
        searchableItems = new TreeMap<>();
    }

    public void add(Searchable item) {
        String name = item.getName();
        if (!searchableItems.containsKey(name)) {
            searchableItems.put(name, new ArrayList<>());
        }
        searchableItems.get(name).add(item);
    }

    public TreeMap<String, Searchable> search(String searchTerm) {
        TreeMap<String, Searchable> result = new TreeMap<>();

        for (List<Searchable> item : searchableItems.values()) {
            for (Searchable sit : item) {
                if (sit.getSearchTerm().contains(searchTerm)) {
                    result.put(sit.getName(), sit);
                    System.out.println(sit.getStringRepresentation());
                }
            }
        }
        return result;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (searchableItems.isEmpty() || search == null || search.isEmpty()) {
            throw new BestResultNotFound("Поисковая строка пуста или список объектов пуст");
        }
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (List<Searchable> sit : searchableItems.values()) {
            for (Searchable item : sit) {
                int occurrences = countOccurrences(item.getSearchTerm(), search);
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

    private int countOccurrences(String text, String search) {
        int index = 0;
        int count = 0;
        if (text == null) {
            return 0;
        } else {
            while ((index = text.indexOf(search, index)) != -1) {
                count++;
                index += search.length();
            }
        }
        return count;
    }

}
