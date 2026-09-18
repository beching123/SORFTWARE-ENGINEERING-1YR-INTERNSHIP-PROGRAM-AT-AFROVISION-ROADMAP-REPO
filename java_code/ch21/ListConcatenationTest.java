package java_code.ch21;

public class ListConcatenationTest {

    public static void main(String[] args) {

        List<Character> list1 = new List<>("list1 ");
        List<Character> list2 = new List<>("list2 ");

        list1.insertAtBack('B');
        list1.insertAtBack('A');

        list2.insertAtBack('T');
        list2.insertAtBack('E');

        ListConcatenation.concatenate(list1, list2);
    }
}
