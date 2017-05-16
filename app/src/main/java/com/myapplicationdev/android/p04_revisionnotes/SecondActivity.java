package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lvList;
	ArrayAdapter aa;
	ArrayList<Note> notes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		lvList = (ListView)findViewById(R.id.lv);

		DBHelper db = new DBHelper(SecondActivity.this);

		notes = db.getAllNotes();

		aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, notes);

		lvList.setAdapter(aa);
		aa.notifyDataSetChanged();


	}


}
