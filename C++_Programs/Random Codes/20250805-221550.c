#include <stdio.h>
int main(){
    int rows;
    int cols;
    printf("Enter number of rows:");
    scanf("%d",&rows);
    printf("Enter  number of cols:");
    scanf("%d",&cols);
    int array[rows][cols];
    // entering elements into the array
    for ( int I = 0; I < rows; I ++){
    for ( int j = 0; j < cols; j ++){
        printf ("Enter element[%d][%d]:",I,j);
        scanf ("%d",&array[I][j]);
        }
        }
        int n,m;
        printf("Enter your entry:");
        printf("Enter the row:");
        scanf("%d",&n);
        printf("Enter the col:");
        scanf("%d",&m);
        for ( int I = 0; I < rows; I ++){
        for ( int j = 0; j < cols; j ++){
          if ( I == n || j == m)
              continue;
           else 
              printf("%d ",array[I][j]);   
        }
        printf("\n");
        }
        }
    
    