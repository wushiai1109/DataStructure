package ArrayStack;

public class Main {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        Integer pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack);
    }
}
