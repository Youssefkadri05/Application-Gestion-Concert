package dao_gestion_concert;

import jpa_gestion_concert.*;
import java.util.ArrayList;
import java.util.List;
public class DAO_Photo {

    private final MongoCollection<Photo> collection;

    public DAO_Photo() {
        // se connecter à la base de données
        MongoDatabase database = MongoClients.create().getDatabase("zamriib00");

        // obtenir une référence à la collection "t_photos_pho"
        collection = database.getCollection("t_photos_pho", Photo.class);
    }

    public void insertPhoto(Photo photo) {
        collection.insertOne(photo);
    }

    public ArrayList<Object> findPhotosByAuthor(String author) {
        return collection.find(Filters.eq("pho_auteur", author)).into(new ArrayList<Object>());
    }

    public ArrayList<Object> findLatestPhotos(int limit) {
        return collection.find().sort(Sorts.descending("pho_date")).limit(limit).into(new ArrayList<Object>());
    }

    public void deletePhoto(ObjectId id) {
        collection.deleteOne(Filters.eq("_id", id));
    }
}
