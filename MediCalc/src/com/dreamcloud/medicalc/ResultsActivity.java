package com.dreamcloud.medicalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ResultsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		final String name = getIntent().getExtras().getString("medName");
		getActionBar().setTitle(name);
		String result = getIntent().getExtras().getString("result");
		int weight = Integer.parseInt(result);
		int calculation = weight*20;
		String fresult = Integer.toString(calculation);
		
		TextView display = (TextView)findViewById(R.id.results);
		display.setText(fresult);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.results, menu);
		return true;
	}

}
