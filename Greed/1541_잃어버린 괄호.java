import java.io.*;
import java.util.*;

public class Main {
    /* 아이디어 생각
    for(int i = 0 ; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }

        for(int i = 0 ; i < signs.length; i++){
            System.out.println("signs = " + signs[i]);
        }

    괄호를 적절히 쳐서 !최소!
    괄호 -> 우선적으로 계산한다.
    그럼 해당 식에서 괄호를 한 곳씩 두면서 최소값을 찾자!
    길이의 최대 -> 50

    1.입력에 대한 처리
    값을 받아서 기호랑 분리한다? -> spilt
    그대로 값을 받아서 처리한다?
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정
        String[] subtraction = br.readLine().split("-");


        for(int i = 0; i < subtraction.length; i++) {
            int temp = 0;

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            String[] addition = subtraction[i].split("\\+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            for(int j = 0; j < addition.length; j++) {
                temp += Integer.parseInt(addition[j]);
            }

            // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
