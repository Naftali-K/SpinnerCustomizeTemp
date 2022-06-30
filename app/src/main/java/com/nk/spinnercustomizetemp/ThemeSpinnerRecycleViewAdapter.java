package com.nk.spinnercustomizetemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ObjIntConsumer;

public class ThemeSpinnerRecycleViewAdapter extends RecyclerView.Adapter<ThemeSpinnerRecycleViewAdapter.ThemeSpinnerRecycleViewHolder> {

    private Context context;
    private List<String> themesList = new ArrayList<>();

    public ThemeSpinnerRecycleViewAdapter(Context context) {
        this.context = context;
        this.themesList = Arrays.asList(context.getResources().getStringArray(R.array.themes_spinner));
    }

    @NonNull
    @Override
    public ThemeSpinnerRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theme_item, parent, false);
        return new ThemeSpinnerRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeSpinnerRecycleViewHolder holder, int position) {
        holder.bind(themesList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return themesList.size();
    }


    class ThemeSpinnerRecycleViewHolder extends RecyclerView.ViewHolder{

        private TextView itemTitleTextView;

        public ThemeSpinnerRecycleViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTitleTextView = itemView.findViewById(R.id.item_title_text_view);
        }

        void bind(String title,int position){
            itemTitleTextView.setText(title);
        }
    }
}
