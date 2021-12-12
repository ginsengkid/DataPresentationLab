package hashmap_linkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class TestMap {

    public static void main(String[] args){
        String filePath = "C:\\Users\\Valer4ick PC\\idea\\DataPresentationLab\\src\\Addresses.txt";

        Map map = new Map();

        System.out.println("\tMap at start:\n<");
        map.print();
        System.out.println(">");

        Set<char[]> namesSet = new HashSet<>();
        try{
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            Pattern pattern = Pattern.compile("[ \t:]+");

            String line = scanner.nextLine();
            int inputCapacity = Integer.parseInt(line);

            for (int i = 0; i < inputCapacity; i++) {
                line = scanner.nextLine();
                String[] lineNames = pattern.split(line);

                char[] name = new char[20];
                char[] address = new char[50];

                char[] inputName = lineNames[0].toCharArray();
                char[] inputAddress = lineNames[1].toCharArray();

                int nameEnd = Math.min(20, inputName.length);
                int addressEnd = Math.min(50, inputAddress.length);

                for (int j = 0; j < nameEnd; j++) {
                    name[j] = inputName[j];
                }

                for (int j = 0; j < addressEnd; j++) {
                    address[j] = inputAddress[j];
                }
                map.assign(name, address);
                namesSet.add(lineNames[0].toCharArray());
            }
        }
        catch (Exception e){ System.out.println(e); }

        namesSet.add(new char[] {'P', 'i', 'p', 'o'});
        namesSet.add(new char[] {'D', 'o', 'b', 'b', 'y'});

        System.out.println("\tMap after assign:\n<");
        map.print();
        System.out.println(">");

        System.out.println("\tTest of compute:\n<");
        Map.RangeType rangeType = new Map.RangeType(new char[] {'?'});
        for (char[] name : namesSet) {
            if(map.compute(name, rangeType.getC())) {
                String n = new String(name);
                System.out.println(n + "\t\t" + rangeType.toString());
            }
            else {
                System.out.println("There is no " + new String(name));
            }
        }
        System.out.println(">");

        map.makeNull();
        System.out.println("\tAfter make null:\n<");
        map.print();
        System.out.println(">");
    }
}
