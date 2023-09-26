package 그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] expressions = input.split("-");
        int result = 0;
        for(int i=0;i<expressions.length;i++){
            if(i==0) result+=calculate(expressions[i]);
            else result-=calculate(expressions[i]);
        }
        System.out.println(result);
    }

    private static int calculate(String expression) {
        String[] operands = expression.split("\\+");
        int result = 0;
        for(int i=0;i<operands.length;i++){
            result += Integer.parseInt(operands[i]);
        }
        return result;
    }
}
