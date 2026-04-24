#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

class Car {
private:
  string model;
  string colour;
  int year;
  string make;

public:
  Car(){}

  Car (string model, int year, string make) {

    this->model = model;
    colour = "Black";
    this->year = year;
    this->make = make;

  }

  Car(string model, string colour, int year, string make) {

    this->model = model;
    this->colour = colour;
    this->year = year;
    this->make = make;
  }

  void start() {

    cout << "Started\n";
  }

  void stop () {

    cout << "Stopped\n";
  }

  void move () {

    cout << "Moved\n";
  }

  void display() {

    cout <<"-Model: "<< model<< endl << "-Color: " << colour << endl << "-Year: " << year << endl << "-Make: " << make << endl;

  }

};



int main() {

  Car Greeny ("range over", "Green", 2020, "USA");
  Greeny.display();

  return 0;
}
