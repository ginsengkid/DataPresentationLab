package hashmap_array;

public class Map {
    public static class RangeType
    {
        private char c;
        public final static char NODEF = '?';
        public final static char FIRST = 'A';
        public final static char LAST = 'Z';

        public RangeType(char x)
        {
            c = x;
        }

        public void Print()
        {
            System.out.printf("%3c", c);
        }
    }

    private RangeType [] M;

    public Map()
    {
        M = new RangeType[RangeType.LAST - RangeType.FIRST + 1];
        int i = RangeType.FIRST;
        for(; i <= RangeType.LAST; i++)
            M[i - RangeType.FIRST] = new RangeType(RangeType.NODEF);
    }

    public void MAKENULL()
    {
        int i = RangeType.FIRST;
        for(; i <= RangeType.LAST; i++)
            M[i - RangeType.FIRST].c = RangeType.NODEF;
    }

    public void ASSIGN(int d, char r)
    {
        M[d].c = r;
    }

    public boolean COMPUTE(int d, RangeType r)
    {
        if (M[d].c == RangeType.NODEF)
            return false;
        r.c = M[d].c;
        return true;
    }

    public void PRINT()
    {
        for(int i = 0; i < M.length; i++)
            System.out.printf("%3d", i);
        System.out.printf("\n");
        for(RangeType r : M)
            r.Print();
        System.out.printf("\n\n");
    }
}

