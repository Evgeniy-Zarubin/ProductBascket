package org.skypro.skyshop.Article;

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
    public String toString() {
        return "Название статьи " + nameArticle + "\n" + "Текст статьи: " + textArticle;
    }
}
