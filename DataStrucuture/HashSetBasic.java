package DataStrucuture;
import java.util.*;

public class HashSetBasic {
    public static void main(String[] args){
        Set<Integer> employerNumbers = new HashSet<>();
        employerNumbers.add(1);
        System.out.println(employerNumbers);
        employerNumbers.add(2);
        System.out.println(employerNumbers);
        Boolean three = employerNumbers.contains(3);
        employerNumbers.add(3);
        System.out.println(three);
        three=employerNumbers.contains(3);
        Iterator<Integer> nums = employerNumbers.iterator();
        while(nums.hasNext()){
        System.out.println(nums.next());
        }
    }
}
