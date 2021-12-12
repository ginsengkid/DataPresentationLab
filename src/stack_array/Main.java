package stack_array;

import java.util.Random;

public class Main    {
    static int rand() {
        Random obj=new Random();
        return obj.nextInt()%100;
    }

    public static void main(String[] args) {
        Stack stk = new Stack(6);
        int i, j;

        for(j=1; j<=10; j++) {
            if(stk.full()) break;
            stk.push(rand());
        }

        while(!stk.empty())
            System.out.print(stk.pop() + " ");
            System.out.println();
    }
}
