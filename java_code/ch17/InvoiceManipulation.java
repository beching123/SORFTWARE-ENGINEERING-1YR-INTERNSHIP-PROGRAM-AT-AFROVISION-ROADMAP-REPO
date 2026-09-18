// Exercise 17.11;
// performing various querries on class invoice created in chapter 13
package Chapter_17;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import Chapter_Three.Invoice;

public class InvoiceManipulation {

    public final Invoice[] invoice = {

            new Invoice(83, "Electric sander", 7, 57.98), new Invoice(24, "Power saw", 18, 99.99),
            new Invoice(7, "Sledge hammer", 11, 21.50), new Invoice(77, "Hammer", 76, 11.99),
            new Invoice(39, "Lawn mower", 3, 79.50), new Invoice(68, "Screwdriver", 106, 6.99),
            new Invoice(56, "Jig saw", 21, 11.00), new Invoice(3, "wrench", 34, 7.50), };


    public static void main(String[] args){

        InvoiceManipulation invoiceManipulation = new InvoiceManipulation();
        List<Invoice> list = Arrays.asList(invoiceManipulation.invoice);

        // printed the complete list of our invoices
        System.out.println("The complete Invoice list:");System.out.println();
        list.stream().forEach(System.out::println);System.out.println();System.out.println();

        //a. sort by partDescriptiton
        System.out.println("Invoice sorted by PartDescription:");System.out.println();
        
        // function to get the part description
        Function<Invoice, String> byDescription = Invoice::getPartDescription;

        // comparator for comparing invoice by description
        Comparator<Invoice> descriptionsComparator = Comparator.comparing(byDescription);

        // sorting and displaying
        list.stream().sorted(descriptionsComparator).forEach(System.out::println);System.out.println();System.out.println();

        //b. sort by price
        System.out.println("Invoice sorted by price");System.out.println();

        // function used to get the price
        Function<Invoice, Double> byPrice = Invoice::getPrizePerItem;

        // creating a comparator used in method sorted
        Comparator<Invoice> pricesComparator = Comparator.comparing(byPrice);

         // sorting and displaying
        list.stream().sorted(pricesComparator).forEach(System.out::println);System.out.println();System.out.println();

        //c. mapping each invoice to its partDescription and quantity.
        System.out.println("Printed mapped invoice to part Description and Quantity");System.out.println();

        // mapped and sorted displaying // add something research on how to do it. 
        list.stream().map((Invoice::getPartDescription)).sorted();
    }

}
