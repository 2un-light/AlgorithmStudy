import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //시험 본 과목 갯수
        int n = Integer.parseInt(br.readLine());

        //점수를 저장하는 배열
        int[] scores = new int[n];

        //점수 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }

        //최댓값 구하기
        int max = scores[0];
        for(int i = 1; i < n; i++){
            if(max < scores[i]) {
                max = scores[i];
            }
        }

        //재정산
        double sum = 0.0;
        for(int i = 0; i < n; i++){
           sum += (double) scores[i] / max * 100;
        }

        double avg = sum / n;

        bw.write(String.valueOf(avg));

        bw.flush();
        bw.close();
        br.close();

    }
}