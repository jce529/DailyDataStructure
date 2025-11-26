package BOJ10773;
import java.util.*;
import BOJ10828.MyStack;

public class BOJ10773 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //재민이한테 K번 받아와야함
        int K = Integer.parseInt(input.nextLine());
        int sum =0;
        MyStack<Integer> myCog = new MyStack<Integer>();//배열 만들고

        //K줄의 정수 받기
        for (int i = 0; i < K; i++) {
            int cog = Integer.parseInt(input.nextLine());

            if (cog != 0) {
                myCog.push(cog);//0이 아니면 배열에 집어넣고
            }
            else {
                myCog.pop();//0이면 배열에서 최근 정수 빼고
            }
        }

        int n = myCog.size();
        for (int i = 0; i < n; i++) {
            //배열 크기만큼 돌면서 넣을 수 가 없구나;;
            sum += myCog.pop();
        }

        System.out.println(sum);
    }
}
