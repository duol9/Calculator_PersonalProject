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


    // 1. num1, num2 모두 Double 타입
    // 4. num1, num2 모두 Integer 타입

    // 덧셈 연산
    private T sum (T addNum1, T addNum2) { // 확인되지 않는 예외는 thorws 키워드를 사용하지 않아도 됨
        T result;

        if (addNum1 instanceof Double && addNum2 instanceof Double) {  // instanceof ; addNum1이 Double 타입인지 확인 후 (true / false)로 반환 (=클래스 거짓판별기)
            return (T) Double.valueOf((double)addNum1 + (double)addNum2); // 객체 addNum1, addNum2를 double타입으로 언박싱 후, 덧셈 연산을 하고 Double 객체 타입으로 박싱함. -> 다시 제네릭 타입으로
        } else if (addNum1 instanceof Integer && addNum2 instanceof Integer) {
            return  (T) Integer.valueOf((int)addNum1 + (int)addNum2);
        } else {
            // IllegalArgumentException : 지정한 타입이 아닌 다른 타입이 들어오면 예외 처리 함
            throw new IllegalArgumentException("이 계산기는 Integer, Double 타입만 지원합니다.");
        }
    }
    // 뺄셈연산
    private T sub (T subNum1, T subNum2) {
        if (subNum1 instanceof Double && subNum2 instanceof Double) {
            return (T) Double.valueOf((double)subNum1 - (double)subNum2);
        } else if (subNum1 instanceof Integer && subNum2 instanceof Integer) {
            return (T) Integer.valueOf((int)subNum1 + (int)subNum2);
        } else {
            throw new IllegalArgumentException("이 계산기는 Integer, Double 타입만 지원합니다.");
        }
    }
    // 곱셈 연산
    private T mul (T mulNum1, T mulNum2) {
        if (mulNum1 instanceof Double && mulNum2 instanceof Double) {
            return (T) Double.valueOf((double)mulNum1 * (double)mulNum2);
        } else if (mulNum1 instanceof Integer && mulNum2 instanceof Integer) {
            return (T) Integer.valueOf((int)mulNum1 + (int)mulNum2);
        } else {
            throw new IllegalArgumentException("이 계산기는 Integer, Double 타입만 지원합니다.");
        }
    }

    // 나눗셈 연산
    // 니눗셈 연산은 1. 분모에 0이 오는지 확인 . 2. 지원하지 않는 피연산자 타입 2가지의 예외 사항을 처리 해야 함
    private T div (T divNum1, T divNum2) {
        if (divNum1 instanceof Double && divNum2 instanceof Double) {
            if ((double)divNum2 == 0) {
                throw new ArithmeticException("분모에 0이 올 수 없습니다.");   // 분모에 해당하는 피연산자의 값이 0이면 ArithmeticException으로 예외처리
            }
            return (T) Double.valueOf((double)divNum1 * (double)divNum2);
        } else if (divNum1 instanceof Integer && divNum2 instanceof Integer) {
            return (T) Integer.valueOf((int)divNum1 + (int)divNum2);
        } else {
            throw new IllegalArgumentException("이 계산기는 Integer, Double 타입만 지원합니다.");
        }
    }

}
