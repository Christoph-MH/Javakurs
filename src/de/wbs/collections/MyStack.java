package de.wbs.collections;

import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(7);
        stack.push(1);
        stack.push(5);
        stack.add(4);       // stack extends vector, add Methode ist "nur" geerbt
        stack.add(3,33);
        System.out.println(stack.peek());
        System.out.println("search: "+stack.search(1));
        System.out.println("______________ Stack ausgeben bis leer ___________");
        while ((!stack.empty())){
            System.out.println(stack.pop());
        }
    }
}
