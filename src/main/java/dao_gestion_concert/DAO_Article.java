package dao_gestion_concert;

import java.util.ArrayList;

import org.bson.types.ObjectId;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

import jpa_gestion_concert.Article;

public class DAO_Article {

    private final MongoCollection<Article> collection;

    public DAO_Article() {
        // se connecter à la base de données
        MongoDatabase database = MongoClients.create().getDatabase("zamriib00");

        // obtenir une référence à la collection "t_article_art"
        collection = database.getCollection("t_article_art", Article.class);
    }

    public void insertArticle(Article article) {
        collection.insertOne(article);
    }

    public ArrayList<Object> findArticlesByAuthor(String author) {
        return collection.find(Filters.eq("art_auteur", author)).into(new ArrayList<Object>());
    }

    public ArrayList<Object> findLatestArticles(int limit) {
        return collection.find().sort(Sorts.descending("art_date")).limit(limit).into(new ArrayList<Object>());
    }

    public void deleteArticle(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
    }
}
