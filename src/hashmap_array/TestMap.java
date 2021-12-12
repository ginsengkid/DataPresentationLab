package hashmap_array;
import java.util.Random;

public class TestMap {

    public static void main(String[] args) {
        Map map = new Map();
        char a = Map.RangeType.FIRST, z = Map.RangeType.LAST;
        int i, size = z - a + 1;
        Map.RangeType r = new Map.RangeType(Map.RangeType.NODEF);
        Random rand = new Random();
        while (a <= z)
        {
            i = Math.abs(rand.nextInt() % size);
            if (!map.COMPUTE(i, r))
                map.ASSIGN(i, a++);
        }
        map.PRINT();

        a = Map.RangeType.FIRST;
        for(i = 0; i < size; i++)
            map.ASSIGN(i, a++);
        map.PRINT();

        map.MAKENULL();
        map.PRINT();
    }
}
