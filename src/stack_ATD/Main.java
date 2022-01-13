package stack_ATD;

import list_linkedList.Data;

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(new Data("Anna", "MSK"));
        s.top().printData();
        s.push(new Data("Ann", "SPB"));
        s.top().printData();
    }
}
