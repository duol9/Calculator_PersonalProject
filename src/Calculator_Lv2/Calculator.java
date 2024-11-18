package Calculator_Lv2;

import java.util.LinkedList;
import java.util.Queue;

// 1. 연산 결과를 저장하는 컬렉션 queue를 외부에서 접근할 수 없도록 private으로 선언
// 1-1. 외부에서 queue에 접근할 수 있도록 getter, setter 메서드 구현
// 2. 사칙연산 수행 후 결과를 반환하는 calculate() 메소드 구현
// 3. 가장 먼저 저장된 연산 결과 삭제하는 removeResult() 메소드 구현

public class Calculator {
    // 객체 Integer 타입으로 결과를 저장하는 Queue 선언
    private Queue<Integer> resultQueue;;

    //생성자 정의, Calculator 객체가 생성될 때마다 Calculator()를 호출해 resultQueue를 초기화
    public Calculator() {
        this.resultQueue = new LinkedList<>();  // LinkedList 객체로 Queue(resultQueue) 인터페이스를 구현
    }

    // 피연산자 num1, num2, 연산기호 op를 매개변수로 받아 사칙연산 수행 후 int 타입으로 결과 반환하는 메소드
    public int calculate(int num1, int num2, char op) {

        int result = 0;   // 연산 결과 저장

        // switch 문으로 op와 일치하는 연산 수행
        switch (op) {
            case '+':
                result = num1 + num2;    // 덧셈 수행
                break;
            case '-':
                result = num1 - num2;   // 뺄셈 수행
                break;
            case '*':
                result = num1 * num2;   // 곱셈 수행
                break;
            case '/':
                result = num1/ num2;   // 나눗셈 수행
                break;
            default:
        }

        resultQueue.add(result);   // 연산 결과를 resultQueue에 삽입. int타입 result가 Integer 타입으로 자동 형변환 됨
        return result;   // result 반환
    }

    // 가장 먼저 삽입된 연산 결과를 queue에서 삭제하는 메소드
    public void removeResult() {
        resultQueue.remove();  // remove()로 가장 먼저 들어온 결과 삭제
    }

    // 연산 결과를 담은 resultQueue가 private이라 외부에서 읽을 수 없음 -> getter를 통해 읽을 수 있게힘
    // resultQueue를 반환하는 방식으로 외부에 보낼 수 있기 때문에 반환 타입을 resultQueue와 같게 설정
    public Queue<Integer> getResultQueue() {
        return resultQueue;
    }

    // 외부에서 resultQueue를 수정할 때 사용. 매개변수로 resultQueue와 동일한 타입으로 설정
    public void setResultQueue(Queue<Integer> resultQueue) {
        this.resultQueue = resultQueue;  // 매개변수로 받은 변수를 Calculator클래스의 resultQueue에 대입
    }
}
