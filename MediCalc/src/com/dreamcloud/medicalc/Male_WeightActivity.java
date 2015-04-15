package com.dreamcloud.medicalc;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Male_WeightActivity extends Activity {

	private static final String CALCULATOR_PACKAGE_NAME = "com.android.calculator2";
	private static final String CALCULATOR_CLASS_NAME = "com.android.calculator2.Calculator";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_male__weight);
		
		final String name = getIntent().getExtras().getString("medName");
		getActionBar().setTitle(name);		
		
		final EditText wt = (EditText)findViewById(R.id.weightValue);
		
		Button calculate = (Button)findViewById(R.id.msubmitButton);
		ImageButton calculator = (ImageButton)findViewById(R.id.calcButton);
		
		calculate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String result = wt.getText().toString();
				Bundle bundle = new Bundle();
				bundle.putString("result", result);
				Intent intent = new Intent(Male_WeightActivity.this, ResultsActivity.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		calculator.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				launchCalculator();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.male__weight, menu);
		return true;
	}
	
	public void launchCalculator(){
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_MAIN);
    	intent.addCategory(Intent.CATEGORY_LAUNCHER);
    	intent.setComponent(new ComponentName(CALCULATOR_PACKAGE_NAME, CALCULATOR_CLASS_NAME));
    	try{
    		this.startActivity(intent);
    	}catch(ActivityNotFoundException noSuchActivity){
    		// handle exception where calculator intent filter isi not register
    	}
    }

}
