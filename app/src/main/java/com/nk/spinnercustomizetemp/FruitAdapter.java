package com.nk.spinnercustomizetemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nk.spinnercustomizetemp.inventory.Fruit;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private Context context;
    private List<Fruit> fruitList;

    public FruitAdapter(Context context, List<Fruit> fruitList) {
        this.context = context;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View rootView = LayoutInflater.from(context).inflate(R.layout.item_fruit, viewGroup, false);

        TextView fruitTextView = rootView.findViewById(R.id.fruit_text_view);
        ImageView fruitImageView = rootView.findViewById(R.id.fruit_image_view);

        fruitTextView.setText(fruitList.get(i).getName());
        fruitImageView.setImageResource(fruitList.get(i).getImage());

        return rootView;
    }
}
