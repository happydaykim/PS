import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class P1003 {

    static int zeroCount = 0;
    static int oneCount = 0;

    private static void fibonacci(int n) {
        if(n == 0) {
            zeroCount = 1;
            oneCount = 0;
            return;
        } else if(n == 1) {
            zeroCount = 0;
            oneCount = 1;
            return;
        }

        int[][] array = new int[n + 1][2];
        array[0] = new int[]{1, 0}; // 0번째는 0이 1번, 1이 0번 호출
        array[1] = new int[]{0, 1}; // 1번째는 0이 0번, 1이 1번 호출

        for(int i = 2; i <= n; i++) {
           array[i][0] = array[i - 1][0] + array[i - 2][0];
           array[i][1] = array[i - 1][1] + array[i - 2][1];
        }
        zeroCount = array[n][0];
        oneCount = array[n][1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            zeroCount = 0;
            oneCount = 0;
            fibonacci(number);
            System.out.println(zeroCount + " " + oneCount);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(zeroCount + " " + oneCount + "\n");
        }
    }
}