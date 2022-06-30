package com.nk.spinnercustomizetemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.nk.spinnercustomizetemp.inventory.DataInventory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Text_Code";

    private CustomSpinner fruitsSpinner, themesSpinner;
    private FruitAdapter fruitAdapter;
    private ThemeSpinnerAdapter themeSpinnerAdapter;
    private ThemeSpinnerRecycleViewAdapter themeSpinnerRecycleViewAdapter;
    private ThemeSpinnerAdapterAdapter themeSpinnerAdapterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setReferences();

        fruitAdapter = new FruitAdapter(this, DataInventory.getFruitList());
        fruitsSpinner.setAdapter(fruitAdapter);

        fruitsSpinner.setSpinnerEventsListener(new CustomSpinner.OnSpinnerEventsListener() {
            @Override
            public void onPopupWindowOpened(Spinner spinner) {
                fruitsSpinner.setBackground(getResources().getDrawable(R.drawable.spinner_bg_fruit_up));
            }

            @Override
            public void onPopupWindowClosed(Spinner spinner) {
                fruitsSpinner.setBackground(getResources().getDrawable(R.drawable.spinner_bg_fruit_down));
            }
        });

        fruitsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();

                String text = fruitsSpinner.getSelectedItem().toString();

                Log.d(TAG, "onItemSelected: " + adapterView.getItemAtPosition(i).toString());
                Log.d(TAG, "onItemSelected: " + text);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        themeSpinnerAdapter = new ThemeSpinnerAdapter(this);
        themesSpinner.setAdapter(themeSpinnerAdapter);


//        themeSpinnerRecycleViewAdapter = new ThemeSpinnerRecycleViewAdapter(this);
//        themesSpinner.setAdapter(themeSpinnerRecycleViewAdapter); //recycle view adapter can't use

//        themeSpinnerAdapterAdapter = new ThemeSpinnerAdapterAdapter(this);
//        themesSpinner.setAdapter(themeSpinnerAdapterAdapter);
    }

    private void setReferences(){
        fruitsSpinner = findViewById(R.id.fruits_spinner);
        themesSpinner = findViewById(R.id.themes_spinner);
    }
}