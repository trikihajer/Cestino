package projettutore.cestino.UI.ListShopping.essai;

import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.Query;

public class OtherListShopping  extends ListeCourseListFragment {

    public OtherListShopping() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("demanders_users_ListeCourse").child(getUid())   ;
    }
}
