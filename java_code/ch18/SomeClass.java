package Chapter_18;

// Exercise 18.13 Solution: SomeClass.java
public class SomeClass {

   /* public static String someMethod(int[] array2, int x) {
        if (x < array2.length)
            return String.format("%s %d", someMethod(array2, x + 1), array2[x]);
        else
            return "";
    }  */
    public static String result = "";

    public static String rev(String text, int x) {

        if (x == 0)
            return text.charAt(x) + "";

        else SomeClass.result += (text.charAt(x) + "") + rev(text, x - 1) + "";

        return SomeClass.result;
    }

    public static void main(String[] args) {

       /*  int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        String result = someMethod(array, 0);
        System.out.println();
        System.out.println(result);*/

        System.out.println(rev("Hello", "Hello".length() - 1));
    } 
} // end class SomeClass
