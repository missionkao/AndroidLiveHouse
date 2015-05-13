package com.example.listviewtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class RiverInfo extends Activity{
	
	private static final String MAP_URL = "http://140.112.175.212/river_map.html";
	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.river_info);
		setupWebView();
	}
	
	
	private void setupWebView(){
		webView = (WebView) findViewById(R.id.webviewmap);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(MAP_URL);
		
	}
	
	
}
