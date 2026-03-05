#pragma once
#include "Book.h"
#include <initializer_list>
#include <iostream>
#include <string>

using namespace std;
//jako tablica analogicznie do klasy Vektor tablica, przechowuje obiekty klasy book
class Library {
	Book* array; //tablica z ksiazkami
	size_t size; //rozmiar tablicy

protected:
	friend ostream& operator<<(ostream& ostr, const Library& L);

public:
	Library();
	Library(std::initializer_list<Book> list); //tu jest pokazane, ¿e przechowuje obiekty klasy Book
	Library(const Library& orig); //konstruktor kopiujacy
	Library(Library&& orig); //konstruktor przenoszacy
	Library(size_t number); //konstruktor z intem
	Library& operator=(const Library& right); //kopiujacy operator przypisania
	Library& operator=(Library&& right); //przenoszacy operator przypisania
	Book& operator[](std::size_t index); //operator[]
	const Book& operator[](std::size_t index) const;
	size_t GetSize() const;
	~Library(); //dekonstruktor

	//zadanie
	void AddNewBook(string&title, string& name);
	void LookBooks();
	void EditBook(size_t index);
	void ShowAuthor(size_t index);
	void DeleteBook(size_t index);
};


