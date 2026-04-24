#include <stdio.h>
  int main (){
     int number,digit;
     int sum = 0;
     printf("Enter your number: ");
     scanf("%d",&number);
     
     while (number){
        digit = number % 10;
        sum += digit;
        printf("%d + ",digit);
        number = number / 10;
     }
     printf("Your sum = %d",sum);
     return 0;
 }    