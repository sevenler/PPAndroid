package com.xququ.audio2dcodedemo;

import com.xququ.SDK.XQuquerService;
import com.xququ.SDK.XQuquerService.XQuquerListener;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, XQuquerListener
{
	final String TAG = "Audio 2D Code Demo";
	
	final String MASHAPE_KEY = "fmoo0czenfgs9vxigbppvgztqkz7dd";
	
	private XQuquerService xququerService;
	private Audio2DCode audio2DCodeClient;
	
	private EditText txtMessage;
	private Button butSend;
	
	private String dataToken;
	private String dataContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		txtMessage = (EditText)this.findViewById(R.id.Message);
		butSend = (Button)this.findViewById(R.id.Send);
		
		butSend.setOnClickListener(this);
		
		audio2DCodeClient = new Audio2DCode(MASHAPE_KEY);
		xququerService = XQuquerService.getInstance();
		
		dataToken = "0ee220b0e01c0914";
		dataContent = "Hello World !";
		
		txtMessage.setText(dataContent);
	}
	
	@Override
	protected void onStart()
	{
		super.onStart();
		xququerService.start(this);		
		Log.i(TAG, "onStart");
	}
	
	@Override
	protected void onStop()
	{
		super.onStop();
		xququerService.stop();		
		Log.i(TAG, "onStop");
	}

	@Override
	public void onClick(View sender)
	{
		int id = sender.getId();
		if(id==R.id.Send)
		{
			send();
		}
	}
	
	private void send()
	{
		String dataContent = txtMessage.getText().toString();
		if(dataContent.length()<=0) return;
		
		if(!dataContent.equals(this.dataContent))
		{
			this.dataToken = null;
			this.dataContent = dataContent;
		}
		if(this.dataToken==null)
		{
			this.dataToken = audio2DCodeClient.upload(dataContent).getBody();
			Log.i(TAG, "uploadData:"+this.dataToken);
		}
		if(this.dataToken!=null) xququerService.sendDataToken(this.dataToken);
	}
	
	@Override
	public void onSend()
	{
		Log.i(TAG, "onSend");
		Toast.makeText(this, "Sent successfully", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onRecv(String dataToken)
	{
		Log.i(TAG, "onRecv:"+dataToken);
		Toast.makeText(this, "Received successfully", Toast.LENGTH_LONG).show();
		
		if(!dataToken.equals(this.dataToken))
		{
			this.dataToken = dataToken;
			this.dataContent = null;
		}
		if(this.dataContent==null)
		{
			this.dataContent = audio2DCodeClient.download(dataToken).getBody();
			Log.i(TAG, "downloadData:"+this.dataContent);
		}
		
		txtMessage.setText(dataContent);
	}
}
