import java.io.*;
class MaxHeap {
    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity + 1];
        size = 0;
    }

    public void insert(int value) {
        heap[++size] = value;
        int current = size;

        //상향식 heapify
        while(current > 1 && heap[current] > heap[current / 2]) {
            swap(current, current / 2);
            current /= 2;
        }

    }

    public int extractMax() {
        if(size == 0) return 0;

        int max = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return max;
    }

    private void heapify(int index) {
        int largest = index;
        int left = 2 * index, right = 2 * index + 1;

        if(left <= size && heap[left] > heap[largest]) largest = left;
        if(right <= size && heap[right] > heap[largest]) largest = right;

        if(largest != index) {
            swap(index, largest);
            heapify(largest);
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
        MaxHeap mh = new MaxHeap(N);

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                bw.write(mh.extractMax() + "\n");
            }else {
                mh.insert(x);
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
