package benchmarks;

import java.util.ArrayList;

public class ListInterfaceExample {
    public static void main(String[] args) {
        ArrayList<Integer> myarrayList = new ArrayList<>();
        myarrayList.trimToSize();

        // в случае изменения ArrayList<> на просто List<> обратиться к методу trimToSize будет невозможно
        // потому что он был задекларирован не на уровне интерфейса, а на уровне уже класса ArrayList



    }
}
