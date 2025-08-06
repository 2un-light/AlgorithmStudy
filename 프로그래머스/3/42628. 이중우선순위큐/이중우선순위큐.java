import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] result = solution(operations);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public static int[] solution(String[] operations) {
        int operationsLength = operations.length;

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < operationsLength; i++) {
            String[] line = operations[i].split(" ");

            String command = line[0];
            int num = Integer.parseInt(line[1]);

            if(command.equals("I")) {
                arrayList.add(num);
                Collections.sort(arrayList);
            }else if(command.equals("D")){
                if(!arrayList.isEmpty()){
                    if(num == -1) {
                        arrayList.remove(0);
                    } else if (num == 1) {
                        arrayList.remove(arrayList.size() - 1);
                    }
                }
            }
        }

        if(arrayList.isEmpty()) {
            return new int[]{0, 0};
        }else {
            return new int[]{
                    arrayList.get(arrayList.size() - 1),
                    arrayList.get(0),
            };
        }


    }
}
