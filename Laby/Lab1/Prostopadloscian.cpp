#include "Prostopadloscian.h"
#include "Prostokat.h"
#pragma once

#include <iostream>
using namespace std;
Prostopadloscian::Prostopadloscian(double a, double b, double h)
	: a(a), b(b), h(h)
{
	cout << "Konstruktor Prostokąta(" << a << "," << b << "," <<h<< ")" << endl;
}

Prostopadloscian::Prostopadloscian(double a): a(a), b(a), h(a)
{
	cout << "Konstruktor Szeszcianu(" << a << "," << a << "," << a << ")" << endl;
}

double Prostopadloscian::GetA() const {
	return a;
}
double Prostopadloscian::GetB() const {
	return b;
}
void Prostopadloscian::SetA(double a) {
	this->a = a;
}
void Prostopadloscian::SetB(double b) {
	this->b = b;
}
double Prostopadloscian::GetH() const {
	return h;
}
void Prostopadloscian::SetH(double a) {
	this->h = h;
}

double Prostopadloscian::PoleBoczne() {
	Prostokat p1(a, h);
	Prostokat p2(b, h);

	int poleBoczne = 2 * p1.Pole() + 2 * p2.Pole();
	return poleBoczne;
}
double Prostopadloscian::PoleCalkowite() {
	Prostokat p1(a, h);
	Prostokat p2(b, h);
	Prostokat p3(a, b);

	int poleCalkowite = 2 * p1.Pole() + 2 * p2.Pole() + 2 * p3.Pole();
	return poleCalkowite;
}
void Prostopadloscian::Wypisz(std::ostream& out) const {
	cout << "Prostokat " << endl;
	cout << a << " " << b << endl;
}
Prostopadloscian::~Prostopadloscian() {
	cout << "Konstruktor prostokata" << endl;
}