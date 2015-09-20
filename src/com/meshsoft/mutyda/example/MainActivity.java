package com.meshsoft.mutyda.example;

import java.util.UUID;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meshsoft.mutyda.MutydaHelper;

public class MainActivity extends Activity {

	final String MUTYDA_CALLBACK_URL="mutyda://auth";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		((TextView)findViewById(R.id.tvResult)).setText("");
		
		
	}

	public void MutydaAuthClick(View v){
		
		((TextView)findViewById(R.id.tvResult)).setText("");
		
		String sessionGuid=UUID.randomUUID().toString();
		MutydaHelper.MutydaAuth(this, sessionGuid, MUTYDA_CALLBACK_URL, callback);
		
		
	}

	MutydaHelper.AuthCallback callback=new MutydaHelper.AuthCallback() {
		
		@Override
		public void success(JSONObject liderData) {
			((TextView)findViewById(R.id.tvResult)).setText("Success\n\r"+liderData.toString());
		}

		@Override
		public void error(JSONObject refusedUserData) {
			((TextView)findViewById(R.id.tvResult)).setText("Error\n\r"+refusedUserData.toString());
		}
	};
	
}
