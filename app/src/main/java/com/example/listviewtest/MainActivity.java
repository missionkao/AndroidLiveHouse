package com.example.listviewtest;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.widget.ListView;
import android.view.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;

public class MainActivity extends ListActivity {
	
	private ListView lview;
	private SimpleAdapter adapter;
	private String[] items = {"River Side","Legacy","Kafka","Witch House","Underworld","The WALL","ThERE CAFE"};
	private String[] items_desc = {"?x?_?????????T?q244??2??B1","?x?_????????K?w???@?q1??","?x?_?????????T?q244??2??2??",
									"?x?_???s??n???T?q56??7??","?v?j?? 45 ?? B1","?x?_????s?????????|?q200??B1",
									"????_????454??B1"};
	private String[] from = {"item_txt","item_desc"};
	private int[] to = { R.id.item_txt , R.id.item_desc };
	private ArrayList<HashMap<String,Object>> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		lview = getListView();
		data = new ArrayList<HashMap<String,Object>>();
		for (int i=0;i<items.length;i++){
			HashMap<String,Object> temp = new HashMap<String,Object>();
			try{
			String itemS = new String(items[i].getBytes(), "big5");
				temp.put(from[0], itemS);}catch (Exception ex){
				ex.printStackTrace();
			}
//			temp.put(from[0], items[i]);
			temp.put(from[1], items_desc[i]);
			data.add(temp);
		}
		adapter = new SimpleAdapter(this,data,R.layout.activity_main,from,to);
		lview.setAdapter(adapter);

		lview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> aview, View view, int index, long arg3) {
				if (index == 0) {
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, River.class);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
