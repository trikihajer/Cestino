package projettutore.cestino.UI.listAchat_produit;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import projettutore.cestino.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dialog_ajout_fragment extends DialogFragment {


    public static Dialog_ajout_fragment newInstance(int num){

        Dialog_ajout_fragment dialogFragment = new Dialog_ajout_fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("num", num);
        dialogFragment.setArguments(bundle);

        return dialogFragment;

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("ajouter article")
                .setItems(R.array.ajout_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
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
