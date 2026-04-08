public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        for(int i = 0; i < 5; i++) {
            printNStars(10);
        }
    }

    public static void printNStars(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}