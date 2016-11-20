package projettutore.cestino.Model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAJEUR on 24/09/2016.
 */
@IgnoreExtraProperties
public class ListeCourse {

     String id;
     String titreListeAchat;
     String sender;
     String date;
     String reciever;
    String image;
    public static Map<String, Boolean> stars = new HashMap<>();

    public ListeCourse() {
    }

    public ListeCourse(String id, String titreListeAchat, String sender, String date, String reciever,String image) {
        this.id = id;
        this.titreListeAchat = titreListeAchat;
        this.sender=sender;
        this.date = date;
        this.reciever=reciever;
        this.image=image;
    }

    public String getIamge() {
        return image;
    }

    public void setIamge(String iamge) {
        this.image = iamge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitreListeAchat() {
        return titreListeAchat;
    }

    public void setTitreListeAchat(String titreListeAchat) {
        this.titreListeAchat = titreListeAchat;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }
    // [START post_to_map]
    @Exclude
    public  Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("sender", sender);
        result.put("reciever", reciever);
        result.put("titreListeAchat", titreListeAchat);
        result.put("date", date);

        return result;
    }
}