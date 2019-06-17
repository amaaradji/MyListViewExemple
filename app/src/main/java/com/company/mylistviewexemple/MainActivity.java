package com.company.mylistviewexemple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private EditText et;
    private List<String> maliste;
    private ArrayAdapter arrayAdapterforMaliste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et_input);
        lv = findViewById(R.id.lv_maliste);

        maliste = new ArrayList<>();
        maliste.add("1- java");
        maliste.add("2- python");
        maliste.add("3- c++");


        arrayAdapterforMaliste = new ArrayAdapter(this, android.R.layout.simple_list_item_1, maliste);

        lv.setAdapter(arrayAdapterforMaliste);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                arrayAdapterforMaliste.remove(maliste.get(position));
                maliste.remove(position);
                arrayAdapterforMaliste.notifyDataSetChanged();
            }
        });

    }


    public void ajouter(View view) {
        //code pour ajouter element
        String txt = et.getText().toString();
        arrayAdapterforMaliste.add(txt);
        et.setText("");

    }

    public void vider(View view) {
        arrayAdapterforMaliste.clear();
    }
}
