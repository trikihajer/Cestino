package projettutore.cestino.UI.ListShopping.essai;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;

import projettutore.cestino.Controller.ItemClickListener;
import projettutore.cestino.Model.ListeCourse;
import projettutore.cestino.R;
import projettutore.cestino.UI.listAchat_produit.IndicListe;
import projettutore.cestino.UI.listAchat_produit.ListeProduitMesAchats;
import projettutore.cestino.UI.listAchat_produit.ModifierArticleMesListes;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class ListeCourseListFragment extends Fragment  {
    private static final String TAG = "PostListFragment";
    private static final String KEY_ID ="KEY_ID" ;

    // [START define_database_reference]
    private DatabaseReference mDatabase;
    // [END define_database_reference]

    private FirebaseRecyclerAdapter<ListeCourse, ListeCourseViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    TextView cachetv;
    public ListeCourseListFragment() {
        // Required empty public constructor
    }

    TextView t;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {  // [START create_database_reference]
        View rootView=inflater.inflate(R.layout.fragment_list_shopping_list, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END create_database_reference]

         t=(TextView) rootView.findViewById(R.id.cacheID);
        mRecycler = (RecyclerView) rootView.findViewById(R.id.messages_list);
        mRecycler.setHasFixedSize(true);




        // Inflate the layout for this fragment
        return rootView;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("gérer ma liste d'achat");
        menu.add(0,0,0,"gerer articles de ma liste");
        menu.add(0,1,0,"modifier ma liste");
        menu.add(0,2,0,"supprimer ma liste");
        menu.add(0,3,0,"archiver ma liste");
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Set up Layout Manager, reverse layout
        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        // Set up FirebaseRecyclerAdapter with the Query
        Query postsQuery = getQuery(mDatabase);
        mAdapter = new FirebaseRecyclerAdapter<ListeCourse, ListeCourseViewHolder>(ListeCourse.class, R.layout.cards_layout_mes_liste_achat,
                ListeCourseViewHolder.class, postsQuery) {
            @Override
            protected void populateViewHolder(final ListeCourseViewHolder viewHolder, final ListeCourse model, final int position) {
                final DatabaseReference postRef = getRef(position);

                // Set click listener for the whole post view
                final String postKey = postRef.getKey();

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     // Launch PostDetailActivity
                  /*      Intent intent = new Intent(getActivity(), PostDetailActivity.class);
                        intent.putExtra(PostDetailActivity.EXTRA_POST_KEY, postKey);
                        startActivity(intent);
*/

                    //    cachetv.setText(postKey);
                        Log.v("bbbbbbbbbbbbb",postKey);
              //          ListeProduitMesAchats.newInstance(Integer.parseInt(postKey));

                        ListeProduitMesAchats fragment = new IndicListe();
                        Bundle args = new Bundle();
                        args.putInt(KEY_ID, Integer.parseInt(postKey));
                        fragment.setArguments(args);
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.addToBackStack(null);
                       ft.replace(R.id.container_drawer, new IndicListe());

                        fragment.newInstance(postKey);
                        ft.commit();



                        // Replace whatever is in the fragment_container view with this fragment,
                        // and add the transaction to the back stack so the user can navigate back

                        // Commit the transaction
                    }
                });


                // Bind Post to ViewHolder, setting OnClickListener for the star button
                viewHolder.bindToPost(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View starView) {
                        // Need to write to both places the post is stored
                        DatabaseReference globalPostRef = mDatabase.child("ListeCourse");
                     //   DatabaseReference userPostRef = mDatabase.child("users_ListeCourse").child(model.getid()).child(postRef.getKey());

                        // Run two transactions
                        onStarClicked(globalPostRef);
                       // onStarClicked(userPostRef);
                    }
                });
            }
        };
        mRecycler.setAdapter(mAdapter);
    }

    // [START post_stars_transaction]
    private void onStarClicked(DatabaseReference postRef) {
        postRef.runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                ListeCourse p = mutableData.getValue(ListeCourse.class);
                if (p == null) {
                    return Transaction.success(mutableData);
                }

        /*        if (p.stars.containsKey(getUid())) {
                    // Unstar the post and remove self from stars
                    p.starCount = p.starCount - 1;
                    p.stars.remove(getUid());
                } else {
                    // Star the post and add self to stars
                    p.starCount = p.starCount + 1;
                    p.stars.put(getUid(), true);
                }
*/
                // Set value and report transaction success
                mutableData.setValue(p);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b,
                                   DataSnapshot dataSnapshot) {
                // Transaction completed
                Log.d(TAG, "postTransaction:onComplete:" + databaseError);
            }
        });
    }
    // [END post_stars_transaction]

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mAdapter != null) {
            mAdapter.cleanup();
        }
    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public abstract Query getQuery(DatabaseReference databaseReference);


}
