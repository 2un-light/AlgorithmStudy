import java.io.*;

class ABSHeap {
    static int[] heap;
    static int size;

    public ABSHeap(int capacity){
        heap = new int[capacity + 1];
        size = 0;
    }

    public void offer(int num) {
        heap[++size] = num;
        int current = size;

        while(current > 1) {
            int parent = current / 2;

            if(compare(current, parent)) {
                swap(current, parent);
                current = parent;
            }else{
                break;
            }
        }

    }

    public int poll() {
        if(size == 0) return 0;
        int min = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return min;
    }

    public void heapify(int index) {
        int absSmallest = index;
        int left = 2 * index;
        int right = 2 * index + 1;

        if(left <= size && compare(left, absSmallest)) {
            absSmallest = left;
        }

        if(right <= size && compare(right, absSmallest)){
            absSmallest = right;
        }

        if(absSmallest != index) {
            swap(absSmallest, index);
            heapify(absSmallest);
        }

    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private boolean compare(int a, int b) {
        int absA = abs(heap[a]), absB = abs(heap[b]);
        return (absA < absB) || (absA == absB && heap[a] < heap[b]);
    }

    private int abs(int a) {
        return (a < 0) ? -a : a;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ABSHeap absHeap = new ABSHeap(N);

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                bw.write(absHeap.poll() + "\n");
            }else {
                absHeap.offer(x);
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
