package Calculator_Lv3;


public enum OperatorType {
    // 각 연산자(+, -, *, /)에 대한 심볼 정의
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String symbol;

    // enum 생성자
    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    //enum 생성자는 private임 -> 외부와 직접적으로 교류를 하지 못하므로 getter 메소드 구현
    public String getSymbol(){
        return symbol;
    }
}
