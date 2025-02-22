import java.io.*;

class MinHeap {
    static int[] heap;
    static int size;

    public MinHeap(int capacity) {
        heap = new int[capacity + 1];
        size = 0;
    }

    public void offer(int num) {
        heap[++size] = num;
        int current = size;

        while(current > 1 && heap[current] < heap[current / 2]) {
            swap(current, current / 2);
            current /= 2;
        }
    }

    public int poll() {
        if(size == 0) return 0;
        int min = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return min;
    }

    private void heapify(int index){
        int smallest = index;
        int left = 2 * index;
        int right = 2 * index + 1;

        if(left <= size && heap[left] < heap[smallest]) smallest = left;
        if(right <= size && heap[right] < heap[smallest]) smallest = right;

        if(smallest != index) {
            swap(smallest, index);
            heapify(smallest);
        }

    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        MinHeap mh = new MinHeap(N);

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                bw.write(mh.poll() + "\n");
            }else {
                mh.offer(x);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
