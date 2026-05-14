/*
Name: Beching Rexzy Bate
Matriculation Number: FE24A240
Cipher: Veginerre Cipher using C++
*/
// header files
#include <iostream>
#include <conio.h>
#include <string>
#include <cctype>

using namespace std;

// class veginerre cipher used to implement the cipher logic
class VeginerreCipher {

private:
  // instance variables used to hold the data of our class
  string text;
  string key;

  int getKeyNumber(char key, bool state) { // private method used get the integer equivalence of each letter

      int keyNumber; // used to hold the key that will be sent to cipher

      // generating key from letter
      key = toupper(key);
      keyNumber = (key - 'A') % 26;

      if (state == true) // for cipher keys
        return keyNumber;
      else { // for decipher keys
        int reverseKey = (26 - keyNumber) % 26;
        return reverseKey;
      }
  }

public:
  VeginerreCipher (string text,string key) { // constructor used to initialized variables
    // using set methods
    setKey(key);
    setText(text);
  }

  void setKey(string key) { // public method used to set and validate our key
    if (key == "") {
      cout <<"key is empty. Default key (HELLO) will be use";
      this->key = "HELLO";
    } else {
      for (char c: key){
        if ((c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z')) continue;
        else {
          cout << "\nInvalid key only letters (a-z or A-Z) are allowed\n";
          cout << "Default key (HELLO) will be used\n";
          cout << "Or terminate and restart the program to Enter a new key\n\n";

          this->key = "HELLO";
          break;
        }
      }
    }
      if (this->key != "HELLO")
        this->key = key;
    }

    void setText(string text) { // public method used to set the text inputed

      if (text == "") {
        cout << "No Text provided. Default text (Hello) will be used";
        this->text = "Hello";
    } else {
        this->text = text;
    }
  }

  // Shift one character safely, even if it was signed
  char shiftChar(char c, char k, bool encryptOrDecrypt) {
        if (isupper(static_cast<unsigned char>(c))) { // for upper case characters
            return 'A' + (c - 'A' + getKeyNumber(k, encryptOrDecrypt)) % 26;
        }
        else if (islower(static_cast<unsigned char>(c))) { // for lower case characters
            return 'a' + (c - 'a' + getKeyNumber(k, encryptOrDecrypt)) % 26;
        }

        return c; // leave other characters unchanged except space which is handled
  }

  string encrypt() { // encryption method for encrypting of our texts
    string result;
    int keyPosition = -1; // since we haven't started looping into our key yet
    for (char c: text){
      if (!isalpha(c)) { continue;} // for non alphabets,keep them they way they are
      result += shiftChar(c, key[++ keyPosition], true); // shifting each charaters

      if (keyPosition == key.length() - 1) // restarting when the end of the key is reached
        keyPosition = -1;
    }

    return result; // return result
  }

  string decrypt() { // method used to decrypt the text
    string result;
    int keyPosition = -1;
    for (char c: text){
      if (!isalpha(c)) { continue;}
      result += shiftChar(c, key[++ keyPosition], false);

      if (keyPosition == key.length() - 1)

        keyPosition = -1;
    }

    return result;
  }
};

int main() { // main funtion for our beginning the execution of our program
 string input; // holds the inputed text be it encrypted or plaintext
 string key;
 int choice;

    // menu
    cout << "===== Caesar Cipher Program =====\n";
    cout << "1. Encrypt Text\n";
    cout << "2. Decrypt Text\n";
    cout << "Choose option: ";

    if (!(cin >> choice)) { // if the user does not enters an integer value
        cout << "Invalid choice. Exiting.\n";
        return 1;
    }

    cin.ignore(); // clear buffer

    cout << "Enter text: "; // getting user input
    getline(cin, input);

    if (input.empty()) { // if the user enters nothing
        cout << "Error: Text cannot be empty.\n";
        return 1;
    }

    cout << "Enter key (string): ";
    if (!(cin >> key)) { // if the user does not enter an integer value
        cout << "Invalid key. Using default key = hello.\n";
        key = "hello";
    }

    VeginerreCipher cipher(input, key); //object that does the encryption/decryption

    if (choice == 1) { // encryption is done if the use chooses 1
        cout << "Encrypted Text: " << cipher.encrypt() << endl;
    }
    else if (choice == 2) { // decryption is done if the user chooses 2
        cout << "Decrypted Text: " << cipher.decrypt() << endl;
    }
    else { // if choice is greater than the required ones
        cout << "Invalid option selected.\n";
    }

    return 0;
}
