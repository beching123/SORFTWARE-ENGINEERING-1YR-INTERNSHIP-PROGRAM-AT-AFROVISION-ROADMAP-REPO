#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

int main() {

  string food = "Pizza";
  string* ptr = &food;

  // Output the value of food (pizza)
  cout << food << "\n";

  // Access the memory address of food and outputs its value (Pizza)
  cout << *ptr << "\n";

  // Change the value of the pointer
  *ptr = "Hamburger";

  //Output the new value of the pointer (Hamburger)
  cout << *ptr << "\n";

  // Output the new value of the food variable (Hamburger)
  cout << food << "\n";
}
