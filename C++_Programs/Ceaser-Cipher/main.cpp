// Assignment on Security and Cryptographic System
// Caesar cipher program by: Beching Rexzy Bate
// Matriculation Number: FE24A240

// header files
#include <iostream>
#include <string>
#include <cctype>

using namespace std;

// class that handles all the encryption logic
class CaesarCipher {
private: // private instance variables that stores class info
    string text;
    int key;

    // private method, used to normalize key into range [0, 25]
    int normalizeKey(int k) {
        k %= 26;
        if (k < 0) k += 26;
        return k;
    }

    // Shift one character safely, even if it was signed
    char shiftChar(char c, int k) {
        if (isupper(static_cast<unsigned char>(c))) { // for upper case characters
            return 'A' + (c - 'A' + k) % 26;
        }
        else if (islower(static_cast<unsigned char>(c))) { // for lower case characters
            return 'a' + (c - 'a' + k) % 26;
        }

        return c; // leave other characters unchanged except space which is handled
    }

public: // public methods
    CaesarCipher(string text, int key) { // constructor that initializes instance variables
        this->text = text;
        this->key = normalizeKey(key); // key is normalized before stored
    }

    string encrypt() { // encryption method that encrypt text
        string result; // used to hold the result after the current character has been shifted
        for (char c : text) {
            if (isspace(c)) continue; // space not needed in cipher text
            result += shiftChar(c, key); // append character that is returned to result
        }
        return result; // return the final result after the text has been fully encrypted
    }

    string decrypt() { // decryption method that decrypt text
        string result; // used to hold the result after the current character has been shifted
        int reverseKey = (26 - key) % 26; // now since this is decryption, the key is reversed before used (since we are to shift negatively)
        for (char c : text) {
            result += shiftChar(c, reverseKey);
        }
        return result;
    }
}; // end class CaesarCipher

int main() { // main function that begins the execution of the program
    string input; // holds the inputed text be it encrypted or plaintext
    int key;
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

    cout << "Enter key (integer): ";
    if (!(cin >> key)) { // if the user does not enter an integer value
        cout << "Invalid key. Using default key = 3.\n";
        key = 3;
    }

    CaesarCipher cipher(input, key); //object that does the encryption/decryption

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
} // end of method main
