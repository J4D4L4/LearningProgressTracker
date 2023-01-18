import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestingCode {

    public void hashMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(27, "Fairy Godmother");
        for (var in : map.entrySet()){
            System.out.println(in.getKey().hashCode());
        }

    }

    public void uniqueHashMap(){

    }

    public void comparingNumber(){
        List<Integer> numbers = Arrays.asList(12, 2, 13, 4, 15, 6);

        numbers.sort((i1, i2) -> !i1.equals(i2) ? 0 : i2 - i1);

        System.out.println(numbers);
    }

}
