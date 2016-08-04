package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.example.aidl.Book;
import com.example.aidl.IBookManager;


import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class BindService extends Service{
	
	private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<Book>();
	
	public Binder mBinder = new IBookManager.Stub(){

		@Override
		public void addBook(Book book) throws RemoteException {
			mBookList.add(book);
		}

		@Override
		public List<Book> getBookList() throws RemoteException {
			Log.d("MLJ","BookManagerService#getBookList()");
			return mBookList;
		}
		
	};
	
	
	public void onCreate() {
		Log.d("MLJ","BookManagerService#onCreate()");
		mBookList.add(new Book(1,"ios"));
		mBookList.add(new Book(2,"android"));
	};
	
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
	public boolean onUnbind(Intent intent)
	{return true;}
}
