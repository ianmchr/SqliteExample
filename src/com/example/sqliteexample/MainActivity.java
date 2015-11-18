package com.example.sqliteexample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText edtNames, edtAge, edtOrigin;
	RadioButton radioMale;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edtNames = (EditText) findViewById(R.id.editTextNames);
		edtAge = (EditText) findViewById(R.id.editTextAge);
		edtOrigin = (EditText) findViewById(R.id.editTextOrigin);
		radioMale = (RadioButton) findViewById(R.id.radioMale);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void register(View v) {
		String names = edtNames.getText().toString();
		String age = edtAge.getText().toString();
		String origin = edtOrigin.getText().toString();
		String gender = radioMale.isSelected() ? "Male" : "Female";
		
		Database db = new Database(this);
		if(!names.equals("") && !age.equals("") && !origin.equals("")){
			db.save(names, age, origin, gender);
			Toast.makeText(this, "#"+db.count(), Toast.LENGTH_SHORT).show();
			edtNames.setText("");
			edtAge.setText("");
			//edtOrigin.setText("");
		}
		else{
			Toast.makeText(this, "Empty Fields!!", Toast.LENGTH_SHORT).show();
		}
	}

    public void fetch(View v){
    	Intent all = new Intent(this, RefugeesActivity.class);
    	startActivity(all); 
    }

}


