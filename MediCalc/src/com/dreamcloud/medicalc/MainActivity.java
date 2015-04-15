package com.dreamcloud.medicalc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dreamcloud.medcontent.MedicationContent;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ListView medview = (ListView) findViewById(R.id.MainMedList);
		
		final ArrayList<String> medlist = new ArrayList<String>();
		for (int i = 0; i < MedicationContent.ITEMS.size(); ++i) {
		      medlist.add(MedicationContent.getItemName(i));
		}
		
		final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, medlist);
		medview.setAdapter(adapter);
		
		medview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			 @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
				 Bundle bundle = new Bundle();
				 bundle.putString("medName", MedicationContent.getItemName((int)id));
				 bundle.putString("description", MedicationContent.getItemDescription((int)id));
				 Intent intent = new Intent(MainActivity.this, GenderActivity.class);
				 intent.putExtras(bundle);
				 startActivity(intent);
		      }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	       List<String> objects) {
	          super(context, textViewResourceId, objects);
	          for (int i = 0; i < objects.size(); ++i) {
	             mIdMap.put(objects.get(i), i);
	          }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }

}
