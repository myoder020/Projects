package com.dreamcloud.medicalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GenderActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gender);
		
		// Declare Buttons and TextView
		TextView description = (TextView) findViewById(R.id.genderView);
		Button male = (Button) findViewById(R.id.maleButton);
		Button female = (Button) findViewById(R.id.femaleButton);
		
		// Set actionbar title to medName
		final String name = getIntent().getExtras().getString("medName");
		getActionBar().setTitle(name);
		
		String desc = getIntent().getExtras().getString("description");
		description.setText(desc);
		
		male.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putString("medName", name);
				Intent intent = new Intent(GenderActivity.this, Male_WeightActivity.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		female.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putString("medName", name);
				Intent intent = new Intent(GenderActivity.this, Female_WeightActivity.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gender, menu);
		return true;
	}

}
