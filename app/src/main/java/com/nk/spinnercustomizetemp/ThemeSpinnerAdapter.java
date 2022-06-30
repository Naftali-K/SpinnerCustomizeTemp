package com.nk.spinnercustomizetemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThemeSpinnerAdapter extends BaseAdapter {

    private Context context;
    private List<String> themesList = new ArrayList<>();

    public ThemeSpinnerAdapter(Context context) {
        this.context = context;
        this.themesList = Arrays.asList(context.getResources().getStringArray(R.array.themes_spinner));
    }

    @Override
    public int getCount() {
        return themesList.size();
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

        View rootView = LayoutInflater.from(context).inflate(R.layout.theme_item, viewGroup, false);

        TextView itemTitleTextView = rootView.findViewById(R.id.item_title_text_view);

        itemTitleTextView.setText(themesList.get(i));

        return rootView;
    }
}
