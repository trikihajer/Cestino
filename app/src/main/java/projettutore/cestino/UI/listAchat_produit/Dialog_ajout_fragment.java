package projettutore.cestino.UI.listAchat_produit;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projettutore.cestino.R;
import projettutore.cestino.UI.ListProduit.AddNewProdFragment;
import projettutore.cestino.UI.ListProduit.CodeBarreActivity;
import projettutore.cestino.UI.ListShopping.Add_list_shopping;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dialog_ajout_fragment extends DialogFragment {
public static String cache2="";
    private static final String KEY_ID ="KEY_ID" ;

    public static Dialog_ajout_fragment newInstance(String num) {

        Dialog_ajout_fragment dialogFragment = new Dialog_ajout_fragment();
        Bundle bundle = new Bundle();
        bundle.putString("num", num);
        dialogFragment.setArguments(bundle);
cache2= String.valueOf(num);
        return dialogFragment;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("ajouter article")
                .setItems(R.array.ajout_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 1:

                                AddNewProdFragment fragment = new AddNewProdFragment();
                                Bundle args = new Bundle();
                                args.putString(KEY_ID, cache2);
                                fragment.setArguments(args);
                                FragmentTransaction ft = getFragmentManager().beginTransaction();
                                ft.addToBackStack(null);
                                ft.replace(R.id.drawer_layout, new AddNewProdFragment());

                                fragment.newInstance(cache2);
                                ft.commit();



                                break;
                            case 2:
                                Intent i = new Intent(getActivity(), CodeBarreActivity.class);
                                startActivity(i);
                                break;
                        }
                    }
                });
        return builder.create();
    }

    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_ajout_fragment, container, false);
    }
*/
}
