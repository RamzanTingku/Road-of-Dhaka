package com.example.user.dhakasroad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity  {

   // private Bundle bundle;
    private AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bundle = new Bundle();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        BlankFragment blankFragment = new BlankFragment();
        ft.add(R.id.fragmentContainer1,blankFragment);
        ft.addToBackStack(null);
        ft.commit();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.autocompleteEditTextView2);
        textView.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView1 = (AutoCompleteTextView)
                findViewById(R.id.autocompleteEditTextView1);
        textView1.setAdapter(adapter1);

        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autocompleteEditTextView2);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment fragment = null;
                fragment = new ItemFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentContainer1,fragment);
                ft.addToBackStack(null);
                ft.commit();


                FragmentManager fm1 = getSupportFragmentManager();
                FragmentTransaction ft1 = fm1.beginTransaction();
                BlankFragment blankFragment = new BlankFragment();
                ft1.add(R.id.fragmentContainer,blankFragment);
                ft1.addToBackStack(null);
                ft1.commit();
            }
        });

    }




    private static final String[] COUNTRIES = new String[] {
            "Mirpur-1", "Mirpur-2", "Mirpur-10","Farmgate", "Germany", "Spain"
    };


}
