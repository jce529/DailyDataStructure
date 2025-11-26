package BOJ9012;
import java.util.*;

public class BOJ9012 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int inputPS = Integer.parseInt(input.nextLine());
        for (int i = 0; i < inputPS; i++)
        {
            int isVPS = 0;
            String PS = input.nextLine();

            for (int j = 0; j < PS.length(); j++){
                if (PS.charAt(j) == '('){
                    isVPS++;
                }
                else if (PS.charAt(j) == ')'){
                    isVPS--;
                }
                if (isVPS < 0){
                    break;
                }
            }

            if (isVPS == 0) System.out.println("YES");
            else System.out.println("NO");

        }

        input.close();
    }
}
