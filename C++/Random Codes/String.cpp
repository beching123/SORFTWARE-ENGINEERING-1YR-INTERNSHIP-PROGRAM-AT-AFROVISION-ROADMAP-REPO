#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

int main() {

  string fulltName;
  //string lastName;

 // cout << "Enter your first name: ";
  //cin >> firstName;
  //cout << "Enter your last name: ";
  //cin >> lastName;

  cout << "Enter your full name: ";
  getline(cin, fulltName);

  cout << "\n\nYour full Name: "<< fulltName << endl;
  return 0;

}
