#include  <stdio.h>
int main () {
int size;
printf (" Enter size:");
scanf ("%d",&size);
    int I,j;
    for (  I = 0; I <= size ; I ++) {
        for( j = 0; j <= size; j ++) {
            if ( j == size && I != size)
                printf ("*");
            else  if ( j ==  size-I ||(I == size & j%2 ==0))
                printf ("*");
           else printf (" ");
        }
        for ( int k = j-1; k >0; k --) {
            if ( I== size && k %2 !=0 ||(k == j - I))
                printf ("*");
            else
                printf (" ");
        }
        printf ("\n");
    }
    for (  I = 0; I <= size -1 ; I ++) {
        for( j = 0; j <= size; j ++) {
            if  (j == size || (j == I +1))
                printf ("*");
            else printf (" ");
        }
        for ( int k = j; k >=0; k --) {
            if ( (k == I + 3))
                printf("*");
            else   printf (" ");
        }
        printf ("\n");
    }}