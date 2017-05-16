package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    RadioGroup rgStars;
    Button btnInsert, btnList;
    ArrayList<Note> notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = (EditText)findViewById(R.id.editTextNote);
        rgStars = (RadioGroup)findViewById(R.id.radioGroupStars);
        btnInsert = (Button)findViewById(R.id.buttonInsertNote);
        btnList = (Button)findViewById(R.id.buttonShowList);

        notes = new ArrayList<Note>();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                int selectedButtonId = rgStars.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);

                int starRat = Integer.valueOf(rb.getText().toString());
                String note = etNote.getText().toString();

                db.insertNote(note, starRat);
                db.close();

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                // Start the new activity
                startActivity(i);

            }
        });

    }

}
