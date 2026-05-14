// Name: Beching Rexzy Bate
// FE24A240
// Columnar cipher

#include <iostream> // for printing cout
#include <string> // for handling text
#include <conio.h> // for console
#include <cctype> // for predefined methods like isspace() and more

using namespace std;

class ColumnarCipher {
public:

 static string encrypt(const string& plaitext, const string& perm);
 static string decrypt(const string& ciphertext, const string& perm);
 static bool isValidPermutation(const string& perm);

private:

  static char** allocateMatrix(int rows, int cols);
  static void freeMatrix(char** matrix, int rows);

};

bool ColumnarCipher::isValidPermutation(const string& perm) {

  int len = static_cast<int>(perm.length());
  if (len == 0) return false;

  bool* seen = new bool[len]();
  for (int i = 0; i < len; i ++) {

    if (!isdigit(perm[i])) {
      delete[]  seen;
      return false;
    }
    int digit = perm[i] - '0';
    if (digit < 0 || digit >= len || seen[digit]) {
      delete[] seen;
      return false;
    }
    seen[digit] = true;
  }
  delete[] seen;
  return true;
}

char** ColumnarCipher::allocateMatrix(int rows, int cols) {

  char** matrix = new char*[rows];
  for (int i = 0; i < rows; i ++) {

    matrix[i] = new char[cols];
    for (int j = 0; j < cols; j ++) {
      matrix[i][j] = ' ';
    }
  }

  return matrix;
}

void ColumnarCipher::freeMatrix(char** matrix, int rows) {

  for (int i = 0; i < rows; i ++) {

    delete[] matrix[i];
  }
  delete[] matrix;
}

string ColumnarCipher::encrypt(const string& plaintext, const string& perm) {

  if (!isValidPermutation(perm))
    return "";

  int width = static_cast<int>(perm.length());
  int len = static_cast<int>(plaintext.length());
  if (len == 0) return "";

  int rows = (len + width - 1) / width;

  char** matrix = allocateMatrix(rows, width);

  int index = 0;
  for (int row = 0; row < rows; row ++) {
    for (int col = 0; col < width; col ++) {

      if (index < len)  {
        matrix[row][col] = plaintext[index];
        index ++;
      }
    }
  }

  string ciphertext = "";
  ciphertext.reserve(len);

  for (int p = 0; p < width; p ++) {

    int col = perm[p] - '0';
    for (int r = 0; r < rows; r ++) {

      int cellIndex = r * width + col;
      if (cellIndex < len) {

        ciphertext += matrix[r][col];
      }
    }
  }

  freeMatrix(matrix, rows);

  return ciphertext;

}


string ColumnarCipher::decrypt(const string& ciphertext, const string& perm) {
  if (!isValidPermutation(perm))
    return "";

  int width = static_cast<int>(perm.length());
  int len = static_cast<int>(ciphertext.length());
  if (len == 0) return "";

  int rows = (len + width - 1) / width;

  int base = len / width;
  int extra = len & width;

  char** grid = allocateMatrix(rows, width);

  int cipherIndex = 0;
  for (int p = 0; p < width; p ++) {

    int col = perm[p] - '0';
    int colCount = base + (col < extra? 1: 0);

    for (int r = 0; r < colCount; r ++) {

      grid[r][col] = ciphertext[cipherIndex];
      cipherIndex ++;
    }
  }

  string plaintext = "";
  plaintext.reserve(len);
  for (int r = 0; r < rows; r ++) {

    for (int c = 0; c < width; c ++) {

      if ((r * width + c) < len) {
        plaintext += grid[r][c];
      }
    }
  }

  freeMatrix(grid, rows);

  return plaintext;
}

int main()
{
  cout << "=== Columnar Transposition Cipher ==="<< endl << endl;
  cout << "1. Encrypt\n2. Decrypt\n";
  cout << "Choice: ";
  int choice;
  cin >> choice;

  string temp;
  getline(cin, temp);

  string permutation;
  cout << "Enter permutation (eg. 10342): ";
  getline(cin, permutation);

  if (!ColumnarCipher::isValidPermutation(permutation)) {

    cout << "Invalid permutation! Must be a string containing each digit from 0 to n-1 exactly once." <<endl;
    return 1;
  }

  string text;
  cout << "Enter text (space allowed): ";
  getline(cin, text);

  if (choice == 1) {
  string cipherText = ColumnarCipher::encrypt(text, permutation);
  cout << "CipherText: \"" << cipherText << "\"" << endl;
  }

  else if (choice == 2) {

  string decrypted = ColumnarCipher::decrypt(text, permutation);
  cout << "Decrypted: \"" << decrypted << "\"" << endl;

  }

  return 0;

}
