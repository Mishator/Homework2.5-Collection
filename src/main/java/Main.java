import java.util.ArrayList;
import java.util.List;

public class Main {

   private static final List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
   private static final List<String> strings = new ArrayList<>(List.of("один", "два","два", "три", "три", "три"));

    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        for (int num : nums) {
            if (num % 2 != 0) {
                System.out.println(num);
            }
        }
    }

}
