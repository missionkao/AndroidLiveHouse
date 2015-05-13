package com.example.listviewtest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import com.example.listviewtest.Thread_getRiverJSON;

public class River extends ListActivity {
	
	
	private ListView riverview;
	private SimpleAdapter adapter;
	private String[] from = {"river_name","river_desc"};
	private int[] to = { R.id.river_name , R.id.river_desc };
	private ArrayList<HashMap<String,Object>> data;
	private JSONArray array;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.river);
		getRiverJSON();
		getRiverList();
		riverview = getListView();
		riverview.setAdapter(adapter);
		
		riverview.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> aview,View view,int index,long arg3){
				try{
					Intent intent = new Intent();
					intent.setClass(River.this, Temp.class);
					array = new JSONArray(RiverParameters.strJSONInfo);
					JSONObject obj = array.getJSONObject(index);
					Bundle bundle = new Bundle();
					bundle.putString("WEB_URL", obj.getString("web"));
					bundle.putString("NAME", obj.getString("name"));
					intent.putExtras(bundle);
					startActivity(intent);
				}catch(Exception e){}
			}
		});
		
	}
	
	private void getRiverJSON(){
		try{
			Thread_getRiverJSON threadRiverJSON = new Thread_getRiverJSON();
			threadRiverJSON.start();
			threadRiverJSON.join();
		}catch(Exception e){}
	}
	
	protected void getRiverList(){
		try{
			data = new ArrayList<HashMap<String,Object>>();
			array = new JSONArray(RiverParameters.strJSONInfo);
			for(int i=0; i<array.length(); i++){
				JSONObject obj = array.getJSONObject(i);
				HashMap<String,Object> temp = new HashMap<String,Object>();
				temp.put(from[0],obj.getString("name"));
				temp.put(from[1],obj.getString("date"));
				data.add(temp);
			}
			adapter = new SimpleAdapter(this,data,R.layout.river,from,to);
		}catch(Exception e){}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rivermain, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()){
		case R.id.river_info:
			Intent riverintent = new Intent();
			riverintent.setClass(River.this, RiverInfo.class);
			startActivity(riverintent);
		}
		
		
		return super.onOptionsItemSelected(item);
	}
}
