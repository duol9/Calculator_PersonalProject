package Caculator;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit_str = null;
        int num1, num2;
        int result;


        do {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요 : ");
            num2 = sc.nextInt();

            // nextInt로 인해 생긴 버퍼 비우기
            sc.nextLine();

            if (num1 >= 0 && num2 >= 0) { // num1, num2가 양수라면

                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요. : ");

                String ops = sc.nextLine();
                char op = ops.charAt(0);
                // nextLine은 문자열 뒤 공백까지 처리해줘서 버퍼 비우기X

                switch (op) {
                    case '*':
                        result = num1 * num2;
                        break;
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            System.out.println("error : 나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            System.out.println("다시 입력하세요.");
                            continue;
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default:
                        System.out.println("지원하지 않는 연산자입니다.");
                        System.out.println("다시 입력하세요.");
                        continue;
                }

                System.out.println("계산 결과 : " + result);
            } else {
                System.out.println("음수를 입력하셨습니다.");
            }

            System.out.println("계산기를 계속 사용 하시겠습니까? (exit 입력 시 종료) ");
            exit_str = sc.nextLine();

        } while(!exit_str.equals("exit"));

    }
}
