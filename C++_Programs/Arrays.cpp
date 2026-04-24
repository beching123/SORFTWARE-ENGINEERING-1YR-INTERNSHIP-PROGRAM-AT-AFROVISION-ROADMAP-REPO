#include <iostream>
#include <conio.h>

using namespace std;

int main() {

  string car[4] = {"Volvo", "BMW", "Ford","Mazda"};
  cout << car[1];
  car[0] = "Opel";
  cout << car[0];
  cout << "\n\n\n";

  for (int i = 0; i < 4; i ++) {

    cout << car[i] << "\n";
  }

  return 0;
}
