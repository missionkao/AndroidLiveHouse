package com.example.listviewtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class Thread_getRiverJSON extends Thread implements Runnable{
	public void run(){
		try{
			StringBuilder sb = new StringBuilder();

			HttpClient client = new DefaultHttpClient();
			HttpParams httpParams = client.getParams();
			//設置網路超時參數
			HttpConnectionParams.setConnectionTimeout(httpParams, 3000);
			HttpConnectionParams.setSoTimeout(httpParams, 5000);
			HttpResponse response = client.execute(new HttpGet(RiverParameters.url));
			HttpEntity entity = response.getEntity();
			if (entity != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(),"big5"), 8192);

			String line = null;
			while ((line = reader.readLine())!= null){
			sb.append(line + "\n");
			}
			reader.close();
			}
			RiverParameters.strJSONInfo = sb.toString();
		}catch(Exception e){}
	}
	

}

