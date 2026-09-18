#include <stdio.h>

int main() {

  int number1, int number2;
  printf("Enter number 1: ");
  scanf("%d", &number1);
  printf("Enter number 2: ");
  scanf("%d", &number2);

  printf("%d + %d = %d", number1, number2, number1 + number2);
  return 0;
}
