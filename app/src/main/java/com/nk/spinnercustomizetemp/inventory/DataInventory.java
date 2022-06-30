package com.nk.spinnercustomizetemp.inventory;

import com.nk.spinnercustomizetemp.R;

import java.util.ArrayList;
import java.util.List;

public class DataInventory {

    public static List<Fruit> getFruitList(){
        List<Fruit> fruitList = new ArrayList<>();

        fruitList.add(new Fruit("Avocado", R.drawable.avocado));

        fruitList.add(new Fruit("Banana", R.drawable.banana));

        fruitList.add(new Fruit("Coconut", R.drawable.coconut));

        fruitList.add(new Fruit("Guava", R.drawable.guava));

        fruitList.add(new Fruit("Lemon", R.drawable.lemon));

        fruitList.add(new Fruit("Mango", R.drawable.mango));

        fruitList.add(new Fruit("Orange", R.drawable.orange));

        return fruitList;
    }
}
