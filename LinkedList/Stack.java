package LinkedList;

import java.util.LinkedList;

public  class Stack {
// Question: Implement a stack using LinkedList.

    private static LinkedList<Integer> linkedList=new LinkedList<>();

    public static void push(int value){
        linkedList.add(value);
    }

    public int pop(){
        // linkedList.pop();
        return linkedList.removeFirst();
    }

    public Boolean isEmpaty(){
        return linkedList.isEmpty();
    }
    public static void main(String[] args) {
        // System.out.println(Stack.push(6));
    }
}