package org.skypro.skyshop.Article;

import java.util.Objects;

public class Article implements Searchable {
    private final String nameArticle;
    private final String textArticle;

    public Article (String nameArticle, String textArticle){
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
    }
    @Override
    public String getSearchTerm(){
        return toString();
    }

    @Override
    public String getContentType(){
        return "Article";
    }


    @Override
    public String getName(){
        return nameArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle) && Objects.equals(textArticle, article.textArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameArticle, textArticle);
    }

    @Override
    public String toString() {
        return "Название статьи " + nameArticle + "\n" + "Текст статьи: " + textArticle;
    }
}
