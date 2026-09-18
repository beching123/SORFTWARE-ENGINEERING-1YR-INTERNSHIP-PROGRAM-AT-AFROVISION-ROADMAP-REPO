#include<stdio.h>
    int determinant(int,int,int cols,int [][cols]);//for determinat calculation
    void subMatrix(int,int,int cols,int,int subcols,int,int,int array[][cols],int subArray[][subcols]);//for generating cofactor matrix
    void coFactors(int,int,int cols,int array[][cols]);//printing the coFactors 
    int main (){
        printf("Welcome to matrix Determinant.\n\n");
        int rows,cols,detRow;
        printf("Enter number of rows:");
        scanf("%d",&rows);
        printf("Enter number of columns:");
        scanf("%d",&cols);
        if (rows!=cols){//Since Determinant works only for square matrix
            printf("\nError. Matrix must be a square matrix");
            return 0;
        }
        printf("\n");
        int I,j, array[rows][cols];
        //Taking and storing of users inout
        for (I = 0; I < rows; I ++){
            for ( j = 0; j < cols; j ++){
                printf("Enter Element[%d][%d]:",I,j);
                scanf("%d",&array[I][j]);
            }
        }
        //displaying user's matrix
        printf("\nYour Matrix:\n");  
        for (I = 0; I < rows; I ++){
            for ( j = 0; j < cols; j ++){
                printf("%d ", array[I][j]);
            }
            printf("\n");
        }
        printf("\n");
        //Enabling the user to use any row of their choice to calculate the determinant 
        printf("Enter the row number you wish to use to compute.\n   your Determinant:");
        scanf("%d",&detRow);
        printf("\n");
        if(detRow > rows - 1){//checking if the row number for the calculation of the determinant is within the actual rows
            printf("Invalid row number\n  ( Row indexing starts from 0 to %d ).",rows - 1);
            return 0;
        }
        int Determinant = determinant (detRow,rows,cols,array);//calling the determinant function to calculate the determinant 
        printf("\nDeterminant of Matrix = %d", Determinant);
     }
   int determinant(int detRow,int rows, int cols, int array[][cols]){//for determinant calculation
    int dermina = 0;//use to store the values of each sub determinant 
    if (rows == 1) {//base case for our recursive determinant function 
        return array[0][0];
    } else {//recursive function call
        for (int j = 0; j < cols; j++) {
            int value = ((detRow + j) % 2 == 0) ? array[detRow][j] : -array[detRow][j];
            int subArray[rows - 1][cols - 1];//for each coFactor matrix 
            subMatrix(value,rows, cols, rows - 1, cols - 1, detRow, j, array, subArray);//creates coFactor subMatrix 
            dermina += value * determinant(0,rows - 1, cols - 1, subArray);//recursive call of this function 
        }
    }
    return dermina;
}
void subMatrix(int value,int rows, int cols, int subrows, int subcols, int indexI, int indexJ, int array[][cols], int subArray[][subcols]) {//for coFactor creation
    int k = 0;
    for (int i = 0; i < rows; i++) {
        if (i == indexI) continue;
        int l = 0;
        for (int j = 0; j < cols; j++) {
            if (j == indexJ) continue;//rejecting unwanted elements for coFactor sub matrix 
            subArray[k][l++] = array[i][j];
        }
        k++;
    }
    coFactors(value,subrows,subcols, subArray);//prints the co factor matrix 
}
void coFactors(int value, int rows,int cols,int matrix[][cols]){//prints the coFactor matrix
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
