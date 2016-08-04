package com.example.aidl;
import com.example.aidl.Book;
interface IBookManager{

	void addBook(in Book book);
	List<Book> getBookList();
}