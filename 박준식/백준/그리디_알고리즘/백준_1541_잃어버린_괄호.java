package 백준.그리디_알고리즘;

import java.io.*;
import java.util.*;

public class 백준_1541_잃어버린_괄호 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String formula = br.readLine();
    String[] split = formula.split("");

    Queue<Integer> integers = new LinkedList<>();
    Queue<String> operators = new LinkedList<>();

    int temp = 0;

    for (String s : split) {
      try {
        temp = temp * 10 + Integer.parseInt(s);
      } catch (Exception e) {
        operators.add(s);
        integers.add(temp);
        temp = 0;
      }
    }

    integers.add(temp);

    int result = integers.poll();
    String lastOperator = "";
    temp = 0;

    while (!integers.isEmpty()) {
      String operator = operators.poll();
      if (operator.equals("-")) {
        if (lastOperator.equals("-")) result -= temp;
        else result += temp;
        lastOperator = "-";
        temp = integers.poll();
      } else {
        if (lastOperator.equals("-")) temp += integers.poll();
        else {
          lastOperator = "+";
          result += integers.poll();
        }
      }
    }

    if (lastOperator.equals("-")) result -= temp;
    else result += temp;

    System.out.println(result);
  }
}
