#include <iostream>
#include <string>
#include "Book.h"
#include "Library.h"
using namespace std;


//Library e;
//cout << "e: " << e << endl;
////3-5 książek
//Library l1 = { {"Tom", "Book1"},
//{"Jess", "Book2"},
//{"Nadia", "Book3"} };

//cout << "l1: " << l1 << endl;
//Library l2(2);
//cout << "l2: " << l2 << endl;
//l2[0] = { "Bernard", "Book4" };
//l2[1] = {"Alan", "Book5" };
//cout << "l2: " << l2 << endl;
//
//e = std::move(l2);
//cout << "e: " << e << " l2: " << l2 << endl;
//l1[0] = std::move(e[1]);
//cout << "l1: " << l1 << " e: " << e << endl;

int main()
{
	/*1) wprowadzania nowej książki : 1 pkt
	2) przeglądania istniejących książek : 0.5 pkt
	3) edycji książki : 1pkt
	4) wyświetlenia autora wybranej książki : 1 pkt
	5) usunięcia książki : 1 pkt
	6) wyjścia z programu : 0.5 pkt*/
	Library l;
	int on = 1;
	int number;
	size_t bookNumber;
	string author;
	string title;
	while (on != 0) {
		cout << "Podaj numer" << endl;
		cin >> number;
		switch (number) {
		case 1:
			cout << "Podaj autora" << endl;
			cin >> author;
			cout << "Podaj tytul " << endl;
			cin >> title;
			l.AddNewBook(title, author);
			break;
		case 2: 
			cout << "to sa istniejace ksiazki" << endl;
			l.LookBooks();
			break;
		case 3:
			cout << "Edytuj ksiazke" << endl;
			cin >> bookNumber;
			l.EditBook(bookNumber-1);
			break;
		case 4:
			cout << "Autor wybranej ksiazki: ";
			cin >> bookNumber;
			cout << endl;
			cout << "Autor to ";
			l.ShowAuthor(bookNumber-1);
			cout << endl;
			break;
		case 5:
			cout << "Usun ksiazke: " << endl;
			cout << "Podaj numer ksiazki, ktora chcesz usunac" << endl;
			cin >> bookNumber;
			l.DeleteBook(bookNumber-1);
			break;
		case 6:
			on = 0;
			cout << "wychodzisz z programu" << endl;
			break;
		default:
			break;
		}
		

	}

	return 0;
}
