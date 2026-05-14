#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

void myFunction() {
  cout << "I just got executed!";
}

void myFunction2(string fname) {
  cout << fname << " Doe";
}

int myFunction3 (int x) {
  return 5 + x;
}

int main() {
  myFunction();
  myFunction();
  cout << endl << endl << endl;
  myFunction2("John");
  cout << endl << endl << endl;
  cout << myFunction3(3);
  return 0;
}
