package projettutore.cestino.UI.ListProduit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projettutore.cestino.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFrag_add_categorie extends Fragment {


    public DialogFrag_add_categorie() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_frag_add_categorie, container, false);
    }

}
