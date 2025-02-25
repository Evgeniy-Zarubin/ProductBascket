package org.skypro.skyshop.Article;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int quantity;

    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
        quantity = 0;
    }

    public void add(Searchable item) {
        if (quantity < searchableItems.length) {
            searchableItems[quantity] = item;
            quantity++;
        } else {
            Searchable[] newArray = new Searchable[searchableItems.length * 2];
            System.arraycopy(searchableItems, 0, newArray, 0, searchableItems.length);
            searchableItems = newArray;
            searchableItems[quantity] = item;
            quantity++;
        }
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] result = new Searchable[5];
        int count = 0;

        for (int i = 0; i < quantity; i++) {
            if (searchableItems[i].getSearchTerm().contains(searchTerm)) {
                result[count] = searchableItems[i];
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
        Searchable [] resultTrimmed = Arrays.copyOf(result,count);

        for (Searchable item : resultTrimmed ) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            }
        }
       return resultTrimmed;
    }

}
