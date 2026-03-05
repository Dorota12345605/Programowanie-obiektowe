#include <iostream>
#include <string>
#include "Book.h"

//konstruktor kopiujacy nowy obiekt do nowego
//nie ma znaczenia co przeslane
Book::Book(const Book& other) {
	/*cout << "Konstruktor kopiujacy" << endl;*/
	author=other.author;
	title=other.title;
};

//konstruktor przenoszacy, musi byc r-referencja
Book::Book(Book&& other) {
	/*cout << "Konstruktor przenoszacy" << endl;*/
	author = other.author;
	title = other.author;

	//author = move(other.author);
	//title = move(other.title);
}

//kopiujacy operator przypisania

Book& Book::operator=(const Book& right) {
	/*Book tmp(right);*/
	author = right.author;
	title = right.title;
	/*swap(book, tmp.book);*/ //swap tu chyba nie ma sensu

	return *this;
}

//przenoszacy operator przypisania
Book &Book:: operator=(Book&& right) {
	/*cout << "operator otzypisania przez przenoszenie" << endl;*/
	author = move(right.author);
	title = move(right.title);
	return *this;
}

//konstruktor bezparametrowy i konstruktor kopiujacy
Book::Book(): author (""), title ("") {

};

//konstruktor. przyjmuje autora i tytul jako l-referencje
//wysylany obiekt
//book ("a", "t")
//a-stworzone tam i w book, nie music kopiowac

Book::Book(string a, string& t) 
{
	author = a;
	title = t;
}

//konstruktor przyjmuje autor i tytul jako r-referencje
Book::Book(string a, string&& t) {
	author = a;
	title = t;
}

//getery
string Book::GetA() {
	return author;
}


string Book::GetT() {
	return title;
}

//z l referencja, kopiuje sie konstruktor kopiujacy
void Book::SetAuthor(const string &a) {
	this->author = a;
}

//przeniesie, nie zrobi kopii
void Book::SetTitle(string &&t) {
	this->title = t;
}


//przeniesie, nie zrobi kopii
void Book::SetTitleL(string& t) {
	this->title = t;
}

// wypisywanie na strumien ostream, wczesniej byly prywatne wiec zeby udostepnic mozna uzyc friend
ostream& operator<<(ostream& ostr, const Book &book) {
	ostr <<"author- "<< book.author << ", title- " << book.title;

	return ostr;
}




