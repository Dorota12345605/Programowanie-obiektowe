#include <iostream>
#include <string>
#include "Library.h"
#include "Book.h"

using namespace std;

//konstruktor bezparametrowy
Library::Library(): size(0), array(nullptr) {

}

//konstruktor z list¹ inicjalizacyjn¹
Library::Library(initializer_list<Book> list) : size{ list.size() }, array{new Book[list.size()]} {
	size_t i = 0;
	for (Book b : list) 
	{
		array[i] = b;
		i++;
	}
}

//konstruktor z parametrem

Library::Library(size_t size) : size(size), array{new Book[size]} {
}

//konstruktor kopiuj¹cy przez referencje
Library::Library(const Library& orig) :size{ orig.size }, array{ new Book[orig.size] } {
	for (size_t i = 0; i < size; i++) {
		array[i] = orig.array[i]; //kopiuje do array
	}
}

//konstruktor przenosz¹cy, wskazniki sie przenosza nie ma zbednego kopiowania
Library::Library(Library&& orig) {
	array = orig.array;
	size = orig.size;
	orig.array = nullptr; //usuwanie odniesienia do danych w obiekcie
	orig.size = 0;
}

//przenosz¹cy operator przypisania
//musi zaistniec zmiana wskaznikow na tablice miejscami
Library& Library ::operator=(Library&& right) {
	swap(array, right.array);
	swap(size, right.size); //zamiana informacji o wielkosci

	return *this;
}

//kopiuj¹cy operator przypisania
Library& Library::operator=(const Library& right) {
	//tworzenie tymczasowego obiektu
	Library tmp = right;
	swap(array, tmp.array);
	swap(size, tmp.size);
	return *this;
}

size_t Library::GetSize() const {
	return size;
}

//operator[]
Book &Library::operator[](std::size_t index) {
	return array[index];
}

//wersja const operatora[],
const Book& Library::operator[](size_t index) const {
	return array[index];
}

//operator << wypisania na strumieñ std::ostream.
//przez strumieniowanie
ostream& operator<<(ostream& ostr, const Library& l) {
	ostr << "Library: { ";
	for (size_t i = 0; i < l.GetSize(); i++) {
		if (i > 0)
			ostr << ", ";
		ostr << l[i];
	}
	ostr <<"}";
	return ostr;
}

//dekonstruktor
Library::~Library() 
{
	if (array != nullptr) {
		delete[] array;//usuwanie tablicy dynamicznej
	}
}


//zadania

void Library::AddNewBook(string &title, string &author) {
	Book newbook;
	newbook.SetTitleL(title);
	newbook.SetAuthor(author);
	Book* newArray = new Book[size+1];

	for (int i = 0; i < size; i++) {
		newArray[i] = array[i];
	}
	newArray[size] = newbook;

	delete[] array;
	array = newArray;
	size = size + 1;

}

void Library::LookBooks() {
	
	for (int i = 0; i < size; i++) {

		cout << i + 1 << ". " << array[i].GetA() << ", " << array[i].GetT() << endl;;

	}

}

void Library::EditBook(size_t index) {
	char change;
	string changedThing;
	cout << "Podaj, co chcesz zmienic " << endl;
	cin >> change;
	if (change == 'a') {
		cout << "Zmieniasz autora" << endl;
		cout << "Podaj zmiane ";
		cin >> changedThing;
		array[index].SetAuthor(changedThing);
	}
	else if (change == 't') {
		cout << "Zmieniasz tytul" << endl;
		cout << "Podaj zmiane ";
		cin >> changedThing;
		array[index].SetTitleL(changedThing);
	}
}

void Library::ShowAuthor(size_t index) {
	cout<<array[index].GetA();
}

void Library::DeleteBook(size_t index) {
	Book* newArray = new Book[size -1];

	for (int i = 0; i < index; i++) {
		newArray[i] = array[i];
	}

	for (int i = index + 1; i < size; i++) {
		newArray[i - 1] = array[i];
	}

	delete[] array;
	
	array = newArray;
	size = size - 1;

}