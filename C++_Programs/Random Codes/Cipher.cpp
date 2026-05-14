#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

class BankAccount {

private:
  double balance;

public:
  BankAccount (double balance) {
    this ->balance = balance;
  }

  void setBalance(double amount) {

    balance = amount;
  }

  double getBalance() {
    return balance;
  }

  double deposit(double amount) {

    setBalance(getBalance() + amount);
  }

  double withdraw(double amount) {
    setBalance(balance - amount);
  }


  void toString() {

    cout << "Balance: " << getBalance();
  }
};


int main() {

  BankAccount account1 (10000.00);

  account1.deposit(200000);
  account1.withdraw(10000.00);

  account1.toString();

}
