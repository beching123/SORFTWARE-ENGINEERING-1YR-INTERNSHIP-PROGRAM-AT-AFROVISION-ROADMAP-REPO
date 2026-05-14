#include <stdio.h>

int factorial(int target, int n) {
    if (n == target) { // base case
        return n;
    }
    return n * factorial(target, n + 1);
}

int main() {
    int number = 5;
    printf("Factorial of %d is %d\n", number, factorial(number, 1));
    return 0;
}