package projettutore.cestino.UI.listAchat_produit;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import projettutore.cestino.UI.ListShopping.essai.ListeCourseListFragment;

/**
 * Created by Lenovo on 17/11/2016.
 */

public class IndicListe extends ListeProduitMesAchats {

    public IndicListe() {}
    private static final String KEY_ID ="KEY_ID" ;

    public static ListeProduitMesAchats newInstance(String text) {

        ListeProduitMesAchats f = new ListeProduitMesAchats() {
            @Override
            public Query getQuery(DatabaseReference databaseReference) {
                return null;
            }
        };
        Bundle b = new Bundle();
        b.putString(KEY_ID, text);


        f.setArguments(b);

        Log.v("bb",text);
        cache=text;
        Log.v("cc",cache);
        return f;
    }

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("listCourse_produit").child(cache)  ;
    }
}