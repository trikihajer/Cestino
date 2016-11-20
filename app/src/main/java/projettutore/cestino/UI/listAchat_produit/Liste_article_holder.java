package projettutore.cestino.UI.listAchat_produit;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import projettutore.cestino.Controller.ItemClickListener;
import projettutore.cestino.Model.ListeCourse;
import projettutore.cestino.Model.Produit;
import projettutore.cestino.R;

/**
 * Created by Lenovo on 17/11/2016.
 */


public class Liste_article_holder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener, ItemClickListener, View.OnCreateContextMenuListener {

    public TextView titleView;
    public TextView authorView;
    public ImageView starView;
    public TextView numStarsView;
    public TextView bodyView;
    ItemClickListener itemClickListenerS;


    public Liste_article_holder(View itemView) {
        super(itemView);

        titleView = (TextView) itemView.findViewById(R.id.textViewTitreProduit_mesAchat);
    }

    public void setSimpleOnClickLitener(ItemClickListener simpleOnClickLitener) {
        this.itemClickListenerS = simpleOnClickLitener;

    }

    public void bindToPost(Produit post, View.OnClickListener starClickListener) {
        titleView.setText(post.getTitre());
        // bodyView.setText(post.startCount);
        Log.v("ssssssssssssssssss", "");
//        starView.setOnClickListener(starClickListener);
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
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        this.itemClickListenerS.onClick(view,getLayoutPosition(),false);

    }

    @Override
    public void onClick(View v) {

    }
}
