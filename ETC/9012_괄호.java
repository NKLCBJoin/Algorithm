import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
    단순히 개수만 비교하면 ()))((도 가능함
    나올 경우 하나씩 제거하는 방법도 괜찮을 거 같은데
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        //올바른 VPS인지 확인
        for(int i = 0 ; i < testCase; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            int leftCnt = 0;
            int rightCnt = 0;

            List<Character> list = new ArrayList<>();
            for(int k = 0; k < tmp.length(); k++){
                char get = tmp.charAt(k);
                list.add(get);
                if(get == '(') leftCnt++;
                else if(get == ')') rightCnt++;
            }

            if(rightCnt != leftCnt){
                System.out.println("NO");
                continue;
            }
            else{//괄호 갯수는 같은데 순서가 다를 수 있으니 체크해야한다!

            }
        }
    }
}