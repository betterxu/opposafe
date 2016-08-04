package com.example.aidl;



import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

public class Book implements Parcelable{
	private int id;
	private String name;
	
	public Book(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Book(Parcel in){
		id = in.readInt();
		name = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(name);
	}
	
	public static Parcelable.Creator<Book> CREATOR = new Creator<Book>() {
		
		@Override
		public Book[] newArray(int size) {
			return new Book[size];
		}
		
		@Override
		public Book createFromParcel(Parcel source) {
			return new Book(source);
		}
	};

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
	

}

