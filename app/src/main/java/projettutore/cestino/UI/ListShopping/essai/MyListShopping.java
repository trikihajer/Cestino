package projettutore.cestino.UI.ListShopping.essai;

/**
 * Created by Lenovo on 14/11/2016.
 */
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class MyListShopping  extends ListeCourseListFragment {

    public MyListShopping() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("users_ListeCourse").child(getUid())  ;
    }
}
