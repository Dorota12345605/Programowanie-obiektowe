#include <iostream>
#pragma once
class Bryla {
protected:
	virtual void Wypisz(std::ostream& out) const = 0;
	friend std::ostream& operator<<(std::ostream& os, const Bryla&
		figura);
public:
	virtual double PoleBoczne() = 0;
	virtual double PoleCalkowite() = 0;
	virtual ~Bryla();
};