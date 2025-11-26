package BOJ10845;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        MyQue<Integer> myStack = new MyQue<Integer>();
        for(int i = 0; i < n; i++){
            String[] order = input.nextLine().split(" ");
            switch(order[0]){

                case "push" :
                    int pushNum = Integer.parseInt(order[1]);
                    myStack.enQueue(pushNum);
                    break;


                case "pop" :
                    try {System.out.println(myStack.deQueue());}
                    catch(EmptyStackException e) {System.out.println(-1);}
                    break;


                case "size" :
                    System.out.println(myStack.size());//사이즈 값을 출력
                    break;

                case "back" :
                    if (myStack.isEmpty()){//비었으면 -1 출력
                        System.out.println(-1);
                        break;
                    }
                    //아님 가장 높은 숫자리턴 ㅇㅇ
                    System.out.println(myStack.rear());
                    break;

                case "front" :
                    if (myStack.isEmpty()){//비었으면 -1 출력
                        System.out.println(-1);
                        break;
                    }
                    //아님 가장 높은 숫자리턴 ㅇㅇ
                    System.out.println(myStack.front());
                    break;

                case "empty" :
                    if(!myStack.isEmpty()){//차있으면 0
                        System.out.println(0);
                        break;
                    }
                    if(myStack.isEmpty()){//비었으면 1
                        System.out.println(1);
                        break;
                    }

            }
        }

        input.close();
    }
}

class MyQue <E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] arr;
    private int front;
    private int rear;

    public MyQue() {
        arr = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        return rear < front;
    }

    public boolean isFull() {
        return rear == arr.length - 1;
    }

    public void reSize() {
        int arrCapacity = arr.length - 1;

        if(rear == arrCapacity) {
            int newCapacity = arr.length * 2;
            arr = Arrays.copyOf(arr, newCapacity);

            return;
        }

        if (rear < arrCapacity/2) {
            int newCapacity = arrCapacity / 2;
            arr = Arrays.copyOf(arr,Math.max(DEFAULT_CAPACITY,newCapacity));
        }
    }

    public int size(){
        return (rear - front) + 1;
    }

    public E rear(){
        return (E) arr[rear];
    }

    public E front(){
        return (E) arr[front];
    }

    public E enQueue(E e){
        if (isFull()) {
            reSize();
        }

        rear++;

        arr[rear] = e;
        return e;
    }

    public E  deQueue(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E value = (E) arr[front];
        front++;

        return value;
    }

    public E peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (E) arr[front];
    }
}


