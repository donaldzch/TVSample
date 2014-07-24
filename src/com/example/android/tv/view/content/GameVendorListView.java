package com.example.android.tv.view.content;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.android.tv.R;
import com.example.android.tv.utils.BitmapUtil;

public class GameVendorListView extends LinearLayout {

    public GameVendorListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.game_vendor_list, this);
    }

    public void render(String[] drawables) {
        for (int i = 0; i < drawables.length; i++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LayoutParams(R.dimen.game_vendor_image_width, R.dimen.game_vendor_image_height);
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.game_vendor_image_spacing), 0);
            imageView.setLayoutParams(layoutParams);
            int resId = getContext().getResources().getIdentifier(drawables[i], "drawable", getContext().getPackageName());
            imageView.setImageBitmap(getPropThumnail(resId));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            addView(imageView);
        }
    }

    private Bitmap getPropThumnail(int id){
        Drawable d = getContext().getResources().getDrawable(id);
        Bitmap b = BitmapUtil.drawableToBitmap(d);
        int w = getContext().getResources().getDimensionPixelSize(R.dimen.game_vendor_image_width);
        int h = getContext().getResources().getDimensionPixelSize(R.dimen.game_vendor_image_height);

        Bitmap thumBitmap = ThumbnailUtils.extractThumbnail(b, w, h);

        return thumBitmap;
    }

}
