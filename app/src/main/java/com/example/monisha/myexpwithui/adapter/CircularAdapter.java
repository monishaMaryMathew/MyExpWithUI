package com.example.monisha.myexpwithui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.monisha.myexpwithui.ImageModel;
import com.example.monisha.myexpwithui.R;
import com.example.monisha.myexpwithui.util.ScaleToFitWidhtHeigthTransform;
import com.jpardogo.listbuddies.lib.adapters.CircularLoopAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Monisha on 1/22/2017.
 * Reference : https://github.com/jpardogo/ListBuddies
 */

public class CircularAdapter extends CircularLoopAdapter {
    private static final String TAG = CircularAdapter.class.getSimpleName();

    private List<ImageModel> mItems = new ArrayList<>();
    private Context mContext;
    private int mRowHeight;

    public CircularAdapter(Context context, int rowHeight, List<ImageModel> imagesUrl) {
        mContext = context;
        mRowHeight = rowHeight;
        mItems = imagesUrl;
    }

    @Override
    public ImageModel getItem(int position) {
        return mItems.get(getCircularPosition(position));
    }

    @Override
    protected int getCircularCount() {
        return mItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.image.setMinimumHeight(mRowHeight);

        //Picasso.with(mContext).load(getItem(position).getImageUrl()).transform(new ScaleToFitWidhtHeigthTransform(mRowHeight, true)).skipMemoryCache().into(holder.image);
        holder.image.setImageDrawable(getItem(position).getImageLocalAddress());
        return convertView;
    }

    static class ViewHolder {
        ImageView image;

        public ViewHolder(View convertView) {
            image = (ImageView) convertView.findViewById(R.id.image);
        }
    }
}
