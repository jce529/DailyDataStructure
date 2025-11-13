package BOJ11866;
import java.util.*;

public class BOJ11866 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (queue.size() > 1) {

            for (int i = 0; i < K - 1; i++) {
                int person = queue.poll();
                queue.add(person);
            }

            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll());

        sb.append(">");
        System.out.println(sb.toString());

        input.close();
    }
}