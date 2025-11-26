package BOJ9012;
import BOJ10828.MyStack;
import java.util.*;

public class BOJ9012stack {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int PSnum = Integer.parseInt(input.nextLine());
        for (int i = 0; i < PSnum; i++) {
            MyStack<Integer> myStack = new MyStack<Integer>();
            String PS = input.nextLine();
            boolean isVPS = true;
            for (int j = 0; j < PS.length(); j++) {

                if (PS.charAt(j) == '(') {
                    myStack.push(1);
                }
                else if (PS.charAt(j) == ')') {
                    try {myStack.pop();}
                    catch (EmptyStackException e) {
                        isVPS = false;
                        break;
                    }
                }
            }
            if (myStack.isEmpty() && isVPS) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }



    }
}
