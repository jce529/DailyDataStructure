package BOJ2606;
import java.util.*;

public class BOJ2606 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int computerN = Integer.parseInt(input.nextLine());//총 노드의 개수
        int connectionN = Integer.parseInt(input.nextLine());//노드 간의 간선의 개수
        int startComputer = 1;//바이러스는 1번 부터 시작
        int connectedComputer = -1;//1번과 연결되어있는 컴퓨터의 개수, 처음 시작할 때 자신을 셈하므로 -1.

        int[][] graph = new int[computerN + 1][computerN + 1];//그래프를 받을 2차원 배열 선언

        boolean[] visited = new boolean[computerN + 1];//방문했는지 확인하는 불린 배열 선언

        for (int i = 0; i < connectionN; i++) {//간선의 개수만큼
            String[] strings = input.nextLine().split(" ");
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);

            putEdge(graph, x, y);//2차원 배열에 간선을 표시
        }
        
        //1단 스택을 만들기
        Stack <Integer> stack = new Stack<>();
        //그리고 시작 컴퓨터를 집어넣어
        stack.push(startComputer);

        while (!stack.isEmpty()) {//스택이 빌 때 까지 반복
            int nodeIndex = stack.pop();//스택에서 하나 꺼내고

            if (visited[nodeIndex]) {//방문 했음 건너뛰기
                continue;
            }

            visited[nodeIndex] = true;//방문한 곳은 방문처리
            connectedComputer++;//방문한 만큼 숫자 새기

            for (int i = computerN; i >= 1; i--){
                //연결되어있고 방문처리되어있지 않다면
                if (graph[nodeIndex][i] == 1 && !visited[i]) {
                    //스택에 넣기
                    stack.push(i);
                }
            }


        }
        System.out.println(connectedComputer);



    }

    static void putEdge(int[][] graph, int x, int y){
        graph[x][y] = 1;
        graph[y][x] = 1;
    }
}
