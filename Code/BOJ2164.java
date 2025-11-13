package BOJ2164;
import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int save;
        int N = Integer.parseInt(input.nextLine());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.add(i+1);
        }

        while (q.size() != 1){
            q.remove();
            q.add(q.remove());
        }

        System.out.println(q.remove());
    }
}
