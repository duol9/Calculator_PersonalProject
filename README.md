# Java 계산기 프로젝트 (Lv.3)

Java로 구현된 간단한 콘솔 기반 계산기 애플리케이션의 향상된(Lv.3)버입니다. 제네릭을 활용하여 실수 연산을 추가 제공하며, Enum을 사용하여 연산자 타입을 관리합니다.

## 요구사항

**1. 현재 사칙연산 계산기는 (➕,➖,✖️,➗) 이렇게 총 4가지 연산 타입으로 구성되어 있습니다.**
- Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.

**2. 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기**
  - 키워드 : `제네릭`
     - 단순히, 기존의 Int 타입을 double 타입으로 바꾸는 게 아닌 점에 주의하세요!
  - 지금까지는 ArithmeticCalculator, 즉 사칙연산 계산기는 양의 정수(0 포함)를 매개변수로 전달받아 연산을 수행
  - 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장
     - ArithmeticCalculator 클래스의 연산 메서드(`calculate`)
  - 위 요구사항을 만족할 수 있도록 ArithmeticCalculator 클래스를 수정합니다. (제네릭)
     - 추가적으로 수정이 필요한 다른 클래스나 메서드가 있다면 같이 수정 해주세요.
   
## 개발 환경

- Java 17
- IntelliJ IDEA (또는 기타 Java IDE)

## 주요 기능
1. 정수 및 실수 연산 지원 (덧셈, 뺄셈, 곱셈, 나눗셈)
2. 사칙연산 기호 enum을 사용해 관리  
3. 연산 결과 출력 및 저장
4. 저장된 연산 결과 중 가장 오래된 결과 삭제
5. 반복 실행 (사용자가 'exit'를 입력 혹은 종료를 선택할 때까지)
6. 예외 처리 (0으로 나누기, 지원하지 않는 타입 입력 등)

## 사용 방법

1. 프로그램 실행
2. 다음 옵션 중 하나를 선택:
   1. 계산기 실행
   2. 계산 기록 삭제
   3. 계산기 종료
3. 계산기 실행을 선택한 경우:
   - 두 개의 피연산자를 입력
   - 사칙연산 기호(+, -, *, /)를 입력
   - 계산 결과 출력
   - 계산 후 계속 사용할지 묻는 메시지가 표시. 'exit'를 입력하면 계산기 종료
4. 계산 기록 삭제를 선택한 경우:
   - 가장 먼저 수행한 계산 결과 삭제
   - 남은 계산 기록들 출력
5. 계산기 종료를 선택한 경우:
   - 프로그램 종료
  
## 주요 구현 사항
- 제네릭 사용: ArithmeticCalculator<T>를 통해 다양한 숫자 타입 지원
- Enum 활용: OperatorType을 통한 연산자 관리
- 예외 처리:
- - 분모에 0이 올 시 ArithmeticException 발생
  - 지원하지 않는 타입(연산자, 피연산자) 입력 시 IllegalArgumentException 발생
- 타입 변환: stringToNumber 메소드를 통해 문자열을 적절한 숫자 타입으로 변환
  
## 프로젝트 구조
### App 클래스
#### 주요 변수:
- arithmeticCalculator: ArithmeticCalculator<Number> 클래스의 인스턴스
- sc: 사용자 입력을 받기 위한 Scanner 객체
- exit_str: 프로그램 종료 여부를 결정하는 문자열
- num1, num2: 사용자로부터 입력받은 두 개의 Number 객체
- result: 계산 결과를 저장하는 Number 객체
- s_num1, s_num2: 숫자 타입 결정하기 전 입력받을 문자열
- cal_op: 계산기 옵션을 저장하는 변수

#### 주요 메소드:
1. main(String[] args)
     - ArithmeticCalculator 인스턴스 생성
     - 무한 반복 (while(true))
       - 입력된 옵션에 따라 처리:
         - 계산 수행
         - 계산 기록 삭제
         - 종료
2. stringToNumber(String s_num): 문자열을 Number 객체로 변환

### ArithmeticCalculator 클래스

#### 주요 필드:
- resultQue: 연산 결과를 저장하는 Queue<T>

#### 생성자:
- `ArithmeticCalculator()`: resultQue를 LinkedList<>로 초기화

#### 주요 메소드:
- calculate(T num1, T num2, OperatorType op): 연산 수행
- sum(T addNum1, T addNum2): 덧셈 연산
- sub(T subNum1, T subNum2): 뺄셈 연산
- mul(T mulNum1, T mulNum2): 곱셈 연산
- div(T divNum1, T divNum2): 나눗셈 연산
- removeResult(): 가장 오래된 결과 삭제
- getResultQue(): 결과 큐 반환
- setResultQue(Queue<T> resultQue): 결과 큐 설정

### OperatorType Enum

#### 정의된 상수:
- ADDITION
- SUBTRACTION
- MULTIPLICATION
- DIVISION

### 주요 메소드:
- getSymbol(): 연산자 심볼 반환
- searchBySymbol(String symbol): 심볼로 연산자 타입 검색
  
## 향후 개선 사항
- Lambda & Stream을 활용한 결과 조회 기능 구현
