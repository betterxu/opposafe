package com.example.service;

import java.util.List;

import com.example.aidl.Book;
import com.example.aidl.IBookManager;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{
	

	
	private static final String SERVICE_NAME = "com.example.service.BindService";
	
	private IBookManager mBookService = null;
	private TextView kk;
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			mBookService = IBookManager.Stub.asInterface(service);
			try {
				List<Book> list=mBookService.getBookList();
				Log.i("MLJ","book list=" + mBookService.getBookList());
				Book newbook=new Book(3,"Android 开发艺术探索");
				mBookService.addBook(newbook);
				kk.append(mBookService.getBookList().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
kk=(TextView)findViewById(R.id.kk);
	
				Intent i = new Intent(MainActivity.this,BindService.class);
	              
				bindService(i, conn, Context.BIND_AUTO_CREATE);
			
		
		
		
					
				
			
	}
}


