package org.skypro.skyshop.Article;

import org.skypro.skyshop.product.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchableItems;

    public SearchEngine() {
        searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public TreeSet<Searchable> search(String searchTerm) {
        TreeSet<Searchable> result = new TreeSet<>(new SearchableComparator());

        for (Searchable item : searchableItems) {
                if (item.getSearchTerm().contains(searchTerm)) {
                    result.add(item);
                    System.out.println(item.getStringRepresentation());
                }
        }
        return result;
    }

    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return o1.getName().compareTo(o2.getName());
        }
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
