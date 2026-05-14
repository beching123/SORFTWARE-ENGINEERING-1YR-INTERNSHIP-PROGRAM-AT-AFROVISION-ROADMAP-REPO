#include<stdio.h>
#include<math.h>

int to_decimal (int);//to handle conversion 
int main()
{
    int number, decimalEquivalence;
    printf("Please enter your Number:");
    scanf("%d",&number);
    decimalEquivalence = to_decimal(number);
    printf("the decimal equivalence of %d is %d", number, decimalEquivalence);
    return 0;
}
int to_decimal(int num){
   int digit,decimalDigit = 0;
   int I = 0;
   while (num){
     digit = num % 10;
     decimalDigit += digit * pow(2,I);
     num = num / 10;
     I ++;
   }
   return decimalDigit;
}
     