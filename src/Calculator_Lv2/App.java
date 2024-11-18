package Calculator_Lv2;

import java.util.Scanner;

// 1. Caculator 객체 생성
// 2. 연산에 필요한 정보들을 입력받고
// 3. Caclulator에서 연산이 작동할 수 있도록 구현
// 4. 계산 기록 삭제를 원할 때, Calculator.클래스 removeResult() 메소드가 작동할 수 있도록 구현
// 5. 계산기를 종료하고 싶을 때까지 무한으로 연산을 실행할 수 있도록 구현

public class App {
    public static void main(String[] args) {
        // Calculator클래스 메소드를 사용하기 위해 new Calculator로 Calculator 생성자를 호출해 인스턴스를 생성
        Calculator calculator = new Calculator();  //calculator 인스턴스

        Scanner sc = new Scanner(System.in);

        String exit_str = "";  // 연산 종료 입력 문자열
        int num1, num2;        // 피연산자
        int result;            // 연산 결과
        int cal_op;            // 사칙연산 기호

        while(true) {
            // 계산기 옵션
            System.out.println("<계산기를 실행합니다.>");
            System.out.println("1. 계산기 ");
            System.out.println("2. 계산 기록 삭제하기");
            System.out.println("3. 계산기 종료하기");
            System.out.print("옵션을 입력하세요. : ");
            cal_op = sc.nextInt();
            // nextInt()로 입력을 받으며 생긴 버퍼를 nextLine()로 처리하여 남은 버퍼를 비움
            sc.nextLine();

            // cal_op == 1이라면 연산을 수행
            if (cal_op == 1) {
                // do - while 문을 사용해 한 번은 무조건 연산을 실행
                // 그 후엔 계산을 종료한다는 의미인 'exit'를 변수 exit_str에 입력받기 전까지 연산을 반복
                do {
                    System.out.print("첫 번째 숫자를 입력하세요 : ");
                    num1 = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요 : ");
                    num2 = sc.nextInt();

                    // nextInt로 인해 생긴 버퍼 비우기
                    sc.nextLine();

                    if (num1 >= 0 && num2 >= 0) { // num1, num2가 양수라면 연산 수행

                        System.out.print("사칙연산 기호(➕,➖,✖️,➗)를 입력하세요. : ");
                        String ops = sc.nextLine(); // char 타입으로 입력을 받을 수 없어서 String타입으로 연산 기호 입력을 받고
                        char op = ops.charAt(0);    // charAt() 메소드로 0번째 인덱스에 있는 연산 기호를 char 타입으로 형변환

                        // 나눗셈 연산 시 분모 자리에 0이 올 경우 계산이 불가함. 조건문을 벗어나 계산을 계속 할 지 물어보는 출력문 코드로 이동
                        if (num2 == 0 && op == '/') {
                            System.out.println("분모에 0이 올 수 없습니다. ");
                        } else {
                            // 분모가 0인 나눗셈 연산을 제외하고는 해당 줄로 이동
                            // Calculator 클래스 calculate 메소드에 양수 num1, num2와 연산기호 op를 매개변수로 넘겨 연산을 수행
                            // 수행된 연산 결과를 result 변수로 반환
                            result = calculator.calculate(num1, num2, op);
                            System.out.println("계산 결과 : " + result);
                        }
                    } else {
                        // num1, num2가 양수가 아니라면 연산을 실행하지 않음
                        System.out.println("음수를 입력하셨습니다.");
                    }

                    System.out.println("계산기를 계속 사용 하시겠습니까? (exit 입력 시 종료) ");
                    exit_str = sc.nextLine();

                } while(!exit_str.equals("exit"));  // exit_str에 exit가 들어있으면 do - while문 종료, 아니라면 계속 진행

            } else if (cal_op == 2) {       // cal_op == 2라면 가장 먼저 저장된 결과를
                calculator.removeResult(); // 삭제하는 removeResult()를 Calculator 클래스에서 호출 후, 가장 먼저 저장된 기록 삭제
                System.out.println("사용 기록");

                int i = 1;
                // Caclculator클래스 getResultQueue 메소드로 결과가 저장된 queue를 참조할 수 있도록 함
                // queue에 저장된 값들을 res에 대입 후, 순서대로 하나씩 출력 
                for (int res : calculator.getResultQueue()) {
                    System.out.println(i++ + ". " + res);  // 해당 출력문 실행이 끝나면 i가 1씩 증가하도록 후위 증가 연산자 사용
                }                                         
            } else if (cal_op == 3) {
                //3. 종료하기 선택 시 가까운 반복문인 while문을 빠져나옴 -> 이후 실행되는 코드 없으므로 프로그램 종료
                break;
            }
        }
    }
}
