package in.zollet.abhilashdas.spotspoon.utility;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by abhilashdas on 10/06/17.
 */

public class CustumDecoration extends RecyclerView.ItemDecoration {


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        outRect.left=16;
        outRect.right=16;
        outRect.bottom=16;
        if(parent.getChildAdapterPosition(view)==0){
            outRect.top=16;
        }


    }
}
