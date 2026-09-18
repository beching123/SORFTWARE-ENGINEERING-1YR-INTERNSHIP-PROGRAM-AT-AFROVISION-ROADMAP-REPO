#include<stdio.h>
    int determinant(int,int,int cols,int [][cols]);//for determinat calculation
    void subMatrix(int,int,int cols,int,int subcols,int,int,int array[][cols],int subArray[][subcols]);//for generating cofactor matrix
    void coFactors(int,int,int cols,int array[][cols]);
    int main (){
        printf("Welcome to matrix Determinant.\n\n");
        int rows,cols,detRow;
        printf("Enter number of rows:");
        scanf("%d",&rows);
        printf("Enter number of columns:");
        scanf("%d",&cols);
        if (rows!=cols){
            printf("\nError. Matrix must be a square matrix");
            return 0;
        }
        printf("\n");
        int I,j, array[rows][cols];
        for (I = 0; I < rows; I ++){
            for ( j = 0; j < cols; j ++){
                printf("Enter Element[%d][%d]:",I,j);
                scanf("%d",&array[I][j]);
            }
        } 
        printf("\nYour Matrix:\n");  
        for (I = 0; I < rows; I ++){
            for ( j = 0; j < cols; j ++){
                printf("%d ", array[I][j]);
            }
            printf("\n");
        }
        printf("\n");
        printf("Enter the row number you wish to use to compute.\n   your Determinant:");
        scanf("%d",&detRow);
        printf("\n");
        if(detRow > rows - 1){
            printf("Invalid row number\n  ( Row indexing starts from 0 to %d ).",rows - 1);
            return 0;
        }
        int Determinant = determinant (detRow,rows,cols,array);
        printf("\n\nDeterminant of Matrix = %d", Determinant);
     }
   int determinant(int detRow,int rows, int cols, int array[][cols]) {
    int dermina = 0;
    if (rows == 1) {
        return array[0][0];
    } else {
        for (int j = 0; j < cols; j++) {
            int value = ((detRow + j) % 2 == 0) ? array[detRow][j] : -array[detRow][j];
            int subArray[rows - 1][cols - 1];
            subMatrix(value,rows, cols, rows - 1, cols - 1, detRow, j, array, subArray);
            dermina += value * determinant(0,rows - 1, cols - 1, subArray);
        }
    }
    return dermina;
}
void subMatrix(int value,int rows, int cols, int subrows, int subcols, int indexI, int indexJ, int array[][cols], int subArray[][subcols]) {
    int k = 0;
    for (int i = 0; i < rows; i++) {
        if (i == indexI) continue;
        int l = 0;
        for (int j = 0; j < cols; j++) {
            if (j == indexJ) continue;
            subArray[k][l++] = array[i][j];
        }
        k++;
    }
    coFactors(value,subrows,subcols, subArray);
}
void coFactors(int value, int rows,int cols,int matrix[][cols]){
     printf(" %+dx(",value);
     for ( int I = 0; I < rows; I ++){
         for ( int j = 0; j < cols; j ++){
             if ( j == cols - 1)
                 printf ("%d)",matrix[I][j]);
             else if ( j == 0)
                 printf ("(%d ", matrix[I][j]);
             else 
                printf ("%d ", matrix[I][j]);
         }
     } 
     if ( rows != 1 )
         printf (")");    
}   
