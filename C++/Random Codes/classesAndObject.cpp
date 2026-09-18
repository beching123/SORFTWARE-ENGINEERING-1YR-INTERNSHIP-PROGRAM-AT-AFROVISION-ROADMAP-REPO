#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

class MyClass {         // The class
  public:              // Access specifier
    int myNum;        // Attribute (int variable)
    string myString;  // Attribute (String variable)
};

int main() {

  MyClass myObj; // Create an object of Myclass

  // Access attribute and set values
  myObj.myNum = 15;
  myObj.myString = "Some text";

  // print attribute values
  cout << myObj.myNum << "\n";
  cout << myObj.myString;
  return 0;
}
