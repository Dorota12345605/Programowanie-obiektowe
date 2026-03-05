#include "Bryla.h"
#include "Prostokat.h"
#pragma once
class Prostopadloscian : public Bryla{
private:
	double a, b, h;
protected:
	void Wypisz(std::ostream& out) const override;
public:
	Prostopadloscian(double a, double b, double h);
	Prostopadloscian(double a=1);
	
	double GetA() const;
	void SetA(double a);
	double GetB() const;
	void SetB(double b);
	double GetH() const;
	void SetH(double h);
	double PoleBoczne() override;
	double PoleCalkowite() override;
	~Prostopadloscian() override;
};