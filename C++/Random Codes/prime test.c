#include <stdio.h>
#include <math.h>
  
  int is_Prime(int);//for the prime number test
  int main (){
    int number,status;
    printf(" Please enter your Number: ");
    scanf("%d",&number);
    status = is_Prime(number);
    if(status)
      printf("%d (prime)",status);
    else 
      printf("%d (not prime)",status);
    return 0;
}
  int is_Prime(int num){
    if (num == 2 )
       return 1;
    else if (num < 2)
       return 0;
    for (int I = 2; I <= sqrt(num) + 1; I ++){
      if ((num % I )== 0 ){
         return 0;
      } 
    } 
    return 1;
  }
  
      