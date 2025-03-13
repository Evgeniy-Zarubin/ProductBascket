package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public Set<Searchable> search(String searchTerm) {
        Supplier<TreeSet<Searchable>> supplier = () -> new TreeSet<>(new SearchableComparator());

        return searchableItems.stream()
                .filter(item -> item.getSearchTerm().contains(searchTerm))
                .peek(item -> System.out.println(item.getStringRepresentation()))
                .collect(Collectors.toCollection(supplier));
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (searchableItems.isEmpty() || search == null || search.isEmpty()) {
            throw new BestResultNotFound("Поисковая строка пуста или список объектов пуст");
        }
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable sit : searchableItems) {
            int occurrences = countOccurrences(sit.getSearchTerm(), search);
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = sit;
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
