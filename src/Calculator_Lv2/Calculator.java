package Calculator_Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    // 컬렉션에는 객체만 저장 가능
    private Queue<Integer> resultQueue;;

    public Calculator() {
        this.resultQueue = new LinkedList<>();
    }

    public int calculate(int num1, int num2, char op) {

        int result = 0;

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1/ num2;
                break;
            default:
        }

        resultQueue.add(result);
        return result;
    }

    public void removeResult() {
        resultQueue.remove();
    }
    // 연산 결과를 담은 resultList가 private이라 외부에서 읽을 수 없음 -> getter를 통해 읽어
    public Queue<Integer> getResultQueue() {
        return resultQueue;
    }

    // 외부에서 resultList를 수정할 때 사용
    public void setResultQueue(Queue<Integer> resultQueue) {
        this.resultQueue = resultQueue;
    }
}
