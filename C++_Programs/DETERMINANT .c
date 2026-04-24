#include<stdio.h>
    int determinant(int,int,int*);//for determinat calculation
    int main (){
        int rows,cols;
        printf("Enter number of rows:");
        scanf("%d",&rows);
        printf("Enter number of columns:");
        scanf("%d",&cols);
        if (rows!=cols){
            printf("\nInvalid!!!");
            return 0;
        }
        int I,j, array[rows][cols];
        for (I = 0; I < rows; I ++){
            for ( j = 0; j < cols; j ++){
                printf("Enter Element[%d][%d]:",I,j);
                scanf("%d",&array[I][j]);
            }
        } 
        printf("Your Array:\n\t");  
        for (I = 0; I < rows; I ++){
            for ( j = 0; j < cols; j ++){
                printf("%d ", array[I][j]);
            }
            printf("\n\t");
        } 
        int deterMinant = determinant(rows,cols,array);
        printf ("The determinat of the matrix: %d",deterMinant);
        return 0;
    }
    int determinant(int rows,int cols,int 
    