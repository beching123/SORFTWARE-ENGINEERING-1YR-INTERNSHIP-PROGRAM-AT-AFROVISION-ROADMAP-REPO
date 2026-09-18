package java_code.ch21;

import java.security.SecureRandom;

public class SortListTest {

    public static void main(String[] args) {

        SortList<Integer> list = new SortList<>("list1");
        SortList<Integer> list1 = new SortList<>("list2");
        SortList<Integer> copy = new SortList<>("Copy");
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 25; i++) {
            list.sortedInsert(random.nextInt(100) + 1);
            list1.sortedInsert(random.nextInt(100) + 1);
        }
        list.getDuplicate();
        list.print();

        System.out.println();System.out.println();
        list1.getDuplicate();
        list1.print();

        list.mergeSortedList(list1);
        list.getDuplicate();
        list.print();

        System.out.println();
        copy = list1.reverseCopy(list);
        copy.print();
    }
}
