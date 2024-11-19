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
    // 어떤 타입이 피연산자가 될지 모르니 리턴 타입도 제네릭으로 설정
    // 외부 클래스에서 매개 변수를 받아와서 public
    public T calculate (T num1, T num2, OperatorType op) {
        T result;

        switch (op) {
            case ADDITION:
                result = sum(num1, num2);
                break;
            case SUBTRACTION:
                result = sub(num1, num2);
                break;
            case MULTIPLICATION:
                result = mul(num1, num2);
                break;
            case DIVISION:
                result = div(num1, num2);
                break;
            default:
        }

        resultQue.add(result);
        return result;
    }


    // 1. num1, num2 모두 Integer 타입
    // 2. num1은 Integer, num2 는 Double
    // 3. num1은 Double, num2는 Integer
    // 4. num1, num2 모두 Double 타입

    // 덧셈 연산
    private T sum (T addNum1, T addNum2) {

        if (addNum1 instanceof Integer && addNum2 instanceof Integer) {  // instanceof ; addNum1이 Integer 타입인지 확인 (true / false)로 반환
            return (T) Integer.valueOf((int)addNum1 + (int)addNum2); // 객체 addNum1, addNum2를 int타입으로 언박싱 후, 덧셈 연산을 하고 Integer 객체 타입으로 박싱함. -> 다시 제네릭 타입으로
        } else if (addNum1 instanceof Integer && addNum2 instanceof Double) {
            return (T) Double.valueOf((double)addNum1 + (double)addNum2);
        } else if (addNum1 instanceof Double && addNum2 instanceof Integer) {
            return (T) Double.valueOf((double)addNum1 + (double)addNum2);
        } else if (addNum1 instanceof Double && addNum2 instanceof Double) {
            return (T) Double.valueOf((double)addNum1 + (double)addNum2);
        }

        throw new IllegalArgumentException("Integer 또는 Double이 아닌 타입으로 입력이 됐습니다."); // 확인되지 않는 에외이기 때문에 메소드에 throws 키워드 붙이지 않아도 됨
                                                                                                    // IllegalArgumentException : 지정한 타입이 아닌 다른 타입이 들어오면 예외 처리 함
    }

    private T sub (T subNum1, T subNum2) {
        return
    }
    private T mul (T mulNum1, T mulNum2) {
        return
    }

    private T div (T divNum1, T divNum2) {
        return
    }

}
