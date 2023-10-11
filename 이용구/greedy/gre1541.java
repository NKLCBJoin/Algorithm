package greedy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//백준 1541 잃어버린 괄호
//덧셈을 먼저하고 빼는 방식

public class gre1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input[] = sc.next().split("-"); //자르기
        sc.close();

        System.out.print(min(input));
    }

    public static int min(String[] input) {
        int result = 0;

        for (int number = 0; number < input.length; number++) {
            List<Integer> plus = Arrays.stream(input[number].split("\\+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (number != 0) {
                result -= plus.stream().reduce(0, Integer::sum);
            }
            else {
                result += plus.stream().reduce(0, Integer::sum);
            }
        }
        return result;
    }

}