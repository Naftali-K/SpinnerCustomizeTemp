package com.nk.spinnercustomizetemp;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.nk.spinnercustomizetemp.inventory.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThemeSpinnerAdapterAdapter implements SpinnerAdapter {

    private Context context;
    private List<String> themesList = new ArrayList<>();

    public ThemeSpinnerAdapterAdapter(Context context) {
        this.context = context;
        this.themesList = Arrays.asList(context.getResources().getStringArray(R.array.themes_spinner));
    }

    @Override
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

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
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.theme_item, viewGroup, false);

        TextView itemTitleTextView = rootView.findViewById(R.id.item_title_text_view);
        itemTitleTextView.setText(themesList.get(i));

        return rootView;
    }

    @Override
    public int getItemViewType(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
