package array;

import java.util.Arrays;

public class Data {
    private final char[] name = new char[20];
    private final char[] address = new char[50];

    public Data(char[] name, char[] address) {
        //if (qwe.length > 20 || qweqwe.length > 50) throw new Exception("length is too long");
        for (int i = 0; i < name.length; i++)
            this.name[i] = name[i];
        for (int i = 0; i < address.length; i++)
            this.address[i] = address[i];
    }

    public Data(String qwe, String qweqwe) {
        //if (qwe.length > 20 || qweqwe.length > 50) throw new Exception("length is too long");
        char[] name1 = qwe.toCharArray();
        char[] address1 =qweqwe.toCharArray();
        for (int i = 0; i < name1.length; i++)
            name[i] = name1[i];
        for (int i = 0; i < address1.length; i++)
            address[i] = address1[i];
    }

    public char[] getAddress() {
        return address;
    }

    public char[] getName() {
        return name;
    }

    public void printData(){
        System.out.print("Name: ");
        for (char c : name) {
            if (c != 0) {
                System.out.print(c);
            }
        }

        System.out.print(" | Address: ");
        for (char c : address) {
            if (c != 0) {
                System.out.print(c);
            }
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data Data = (array.Data) o;
        return Arrays.equals(name, Data.name) && Arrays.equals(address, Data.address);
    }

    public Data getData() {
        return this;
    }

}
