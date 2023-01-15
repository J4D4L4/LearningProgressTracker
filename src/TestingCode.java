import java.util.HashMap;
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

}
