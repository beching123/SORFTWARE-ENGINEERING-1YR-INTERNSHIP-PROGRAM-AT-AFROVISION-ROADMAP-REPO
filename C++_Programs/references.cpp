#include <iostream>
#include <conio.h>

using namespace std;

int main() {

  int number;
  number = 20;
  int &x = number;
  cout << number;
  cout << endl << x;
  cout << &x;
}
