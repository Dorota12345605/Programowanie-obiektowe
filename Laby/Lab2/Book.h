#pragma once
#include <iostream>
#include <string>
using namespace std;

class Book {
	string author, title;

protected:
	friend ostream& operator<<(ostream& os, const Book& figura);

public:
	Book(); //konstruktor bezparametrowy
	Book(string a, string& t); //konstruktor przez l-referencje

	Book(string a, string&& t); //konstruktor przyjmuje autora i tytul jako r-refencje
	Book(const Book& other); //konstruktor kopiujacy
	Book(Book&& other); //konstruktor przenoszacy

	Book& operator=(Book&& right); //konstruktor przenoszacy przypisywania

	Book& operator=(const Book& right); //przenoszacy operator przypisywania


	string GetA(); //funcja get A
	void SetAuthor(const string &a); //funckja set A z l-referencja

	string GetT(); //funkcja get T
	void SetTitle(string &&t); //funkcja set T z r-referencja
	void SetTitleL(string& t);

};
