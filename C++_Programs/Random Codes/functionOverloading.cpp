#include <iostream>
#include <conio.h>

using namespace std;

int plusFunction(int x , int y) {

  return x + y;
}

double plusFunction (double x, double y) {

  return x + y;
}
int main() {
  int myNum1 = plusFunction(8, 5);
  double myNum2 = plusFunction (4.3, 6.26);
  cout << "Int: " << myNum1 << "\n";
  cout << "Double: " << myNum2;
  return 0;
}
