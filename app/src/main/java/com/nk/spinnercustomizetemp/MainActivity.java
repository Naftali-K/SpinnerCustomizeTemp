package com.nk.spinnercustomizetemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nk.spinnercustomizetemp.inventory.DataInventory;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Text_Code";

    private CustomSpinner fruitsSpinner, themesSpinner;
    private Spinner yearSpinner;
    private FruitAdapter fruitAdapter;
    private ThemeSpinnerAdapter themeSpinnerAdapter;
    private ThemeSpinnerRecycleViewAdapter themeSpinnerRecycleViewAdapter;
    private ThemeSpinnerAdapterAdapter themeSpinnerAdapterAdapter;

    private ArrayList<CharSequence> dates = new ArrayList<>();
    private ArrayAdapter<CharSequence> yearsArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setReferences();
        createYearsListAdapter();

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

        yearsArrayAdapter = new ArrayAdapter<CharSequence>(getBaseContext(), R.layout.spinner_item_text_block, dates);
        yearSpinner.setAdapter(yearsArrayAdapter);
        yearSpinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (yearSpinner.getSelectedItemPosition() == 0) {
                    Log.d(TAG, "onTouch: Year not selected");

                    Calendar calendar = Calendar.getInstance();
                    int currentYear = calendar.get(Calendar.YEAR);

                    int currentYearPosition = dates.indexOf(String.valueOf(currentYear));
                    Log.d(TAG, "onTouch: Current year: " + currentYear + " Current year position: " + currentYearPosition);

                    yearSpinner.setSelection(currentYearPosition);
                }
                return false;
            }
        });

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                yearSpinner.setSelection(0);
            }
        });
    }

    private void setReferences(){
        fruitsSpinner = findViewById(R.id.fruits_spinner);
        themesSpinner = findViewById(R.id.themes_spinner);
        yearSpinner = findViewById(R.id.year_spinner);
    }

    private void createYearsListAdapter() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        currentYear += 20;

        dates.add(getString(R.string._year));

        for (int i = 0; i < 100; i++){
            int year = currentYear - i;
            dates.add("" + year);
        }
    }
}