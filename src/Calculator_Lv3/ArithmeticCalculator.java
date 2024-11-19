package Calculator_Lv3;

import java.util.LinkedList;
import java.util.Queue;

// 제네릭 / Number클래스를 상속받는 이유는 intvalue, doublevlaue 메소를 사용해 객체를 정수/실수 타입으로 바꾸기 위해서
public class ArithmeticCalculator <T>  {
    // 속성
    private Queue<T> resultQue;

    //생성자
    public ArithmeticCalculator() {
        this.resultQue = new LinkedList<>();
    }

    // 기능(메소드)

}
