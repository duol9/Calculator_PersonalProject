package Calculator_Lv3;


public enum OperatorType {
    // 각 연산자(+, -, *, /)에 대한 심볼 정의
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String symbol;

    // enum 생성자.  private이 기본임
    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    //enum 생성자는 private임 -> 외부와 직접적으로 교류를 하지 못하므로 getter 메소드 구현
    public String getSymbol(){
        return symbol;
    }

    public OperatorType searchBySymbol (String symbol){
        for (OperatorType op : values()) { // values()를 사용해 OperatorType enum에 들어있는 상수들을 순차적으로 op에 반환
            if (op.symbol.equals(symbol)) return op; // 매개변수로 받은 symbol이 OperatorType enum 상수와 일치한지 확인 후, 일치하면 해당 op(symbol) 반환
        }
        // enum상수에 없는 연산 기호라면 예외처리 후 종료
        throw new IllegalArgumentException("지원하지 않는 연산 기호 입니다.");
    }
}
