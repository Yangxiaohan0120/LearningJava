package DataStructureAndAlgorithm.Linear;

import DataStructureAndAlgorithm.Linear.array.ArrayStack;
import DataStructureAndAlgorithm.Linear.list.LinkedListStack;
import DataStructureAndAlgorithm.Linear.list.ListNode;
import DataStructureAndAlgorithm.Linear.queue.Deque;
import DataStructureAndAlgorithm.Linear.queue.Queue;

import java.util.HashSet;
import java.util.Random;
import java.util.Stack;

/**
 * @ author: yxh
 * @ created: 2021-12-15 : 8:57 PM
 */
public class DSMain {

    public DSMain() {

    }

    public void testLinkedListStack() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

    public static boolean isCorrectedOrder(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    private static double testDeque(Deque<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.addFront(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            q.removeFront();
        for (int i = 0; i < opCount; i++)
            q.addLast(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            q.removeLast();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    private static double testStack(DataStructureAndAlgorithm.Linear.stack.Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> Set = new HashSet<>();
        for (int i : nums) {
            Set.add(i);
        }
        return Set.size() < nums.length;
    }


    public static void main(String[] args) {
//        DynamicArray arr = new DynamicArray(10);
//        for (int i = 0; i < 10; i++) {
//            arr.addLast(i);
//        }
//        System.out.println(arr);
//
//        arr.addLast(-1);
//        System.out.println(arr);
//
//        Array<Student> arr1 = new Array<>(10);
//        arr1.addLast(new Student("Alice", 100));
//        arr1.addLast(new Student("Bob", 99));
//        arr1.addLast(new Student("Charlie", 66));
//        System.out.println(arr1);
//
//        String s = "{{[()]}}";
//        System.out.println(isCorrectedOrder(s));
//        System.out.println(isValid(s));
//

        //////////////////////////////////
//        int opCount = 100000;
//
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue, opCount);
//        System.out.println("ArrayQueue, time: " + time1 + " s");
//
//        LoopQueue<Integer> loopQueue = new LoopQueue<>();
//        double time2 = testQueue(loopQueue, opCount);
//        System.out.println("LoopQueue, time: " + time2 + " s");

//        LinkedListQueue<Integer> loopQueue = new LinkedListQueue<>();
//        double time2 = testQueue(loopQueue, opCount);
//        System.out.println("LoopQueue, time: " + time2 + " s");

//
//        Deque<Integer> deque = new Deque<>();
//        double time3 = testQueue(loopQueue, opCount);
//        System.out.println("LoopQueue, time: " + time3 + " s");

        ///////////////////////////////////
//        int opCount = 100000;
//
//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        double time1 = testStack(arrayStack, opCount);
//        System.out.println("ArrayStack, time: " + time1 + " s");
//
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//        double time2 = testStack(linkedListStack, opCount);
//        System.out.println("LinkedListStack, time: " + time2 + " s");
//
//        (new DSMain()).testLinkedListStack();
//
//    }

        int[] nums = {1,2,3,4};
//        System.out.println(new DSMain().containsDuplicate(nums));

        ListNode head = new ListNode(nums);
        System.out.println(head);
        head = head.reverse2(head);
        System.out.println(head);
    }
}