package Calculator_Lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner sc = new Scanner(System.in);
        String exit_str = "";
        int num1, num2;
        int result;
        int cal_op;

        System.out.println("<계산기를 실행합니다.>");
        System.out.println("1. 계산기 ");
        System.out.println("2. 최근 계산 기록 삭제하기");

        System.out.println("사용하려는 기능의 번호를 입력하세요. : ");
        cal_op = sc.nextInt();
        sc.nextLine();

        if (cal_op == 1) {
            do {
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                num2 = sc.nextInt();

                // nextInt로 인해 생긴 버퍼 비우기
                sc.nextLine();

                if (num1 >= 0 && num2 >= 0) { // num1, num2가 양수라면

                    System.out.print("사칙연산 기호(➕,➖,✖️,➗)를 입력하세요. : ");
                    String ops = sc.nextLine();
                    char op = ops.charAt(0);

                    // 나눗셈 연산 시 분모 자리에 0이 올 경우, 계산을 계속 할 지 결정
                    if (num2 == 0 && op == '/') {
                        System.out.println("분모에 0이 올 수 없습니다. ");
                    } else {
                        result = calculator.calculate(num1, num2, op);
                        System.out.println("계산 결과 : " + result);
                    }
                } else {
                    System.out.println("음수를 입력하셨습니다.");
                }

                System.out.println("계산기를 계속 사용 하시겠습니까? (exit 입력 시 종료) ");
                exit_str = sc.nextLine();

            } while(!exit_str.equals("exit"));

        } else if (cal_op == 2) {
            calculator.removeResult();
            System.out.println("사용 기록");

            int i = 1;

            for (int res : calculator.getResultQueue()) {
                System.out.println(++i + ". " + res);
            }
        }

    }
}
