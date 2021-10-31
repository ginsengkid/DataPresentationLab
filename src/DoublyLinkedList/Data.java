package DoublyLinkedList;

public class Data {
    private final char[] name = new char[20];
    private final char[] address = new char[50];

    public Data(char[] name1, char[] address1) {
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

    public Data(String name, String address) {
        char[] nameArray = name.toCharArray();
        char[] addressArray = address.toCharArray();
        for (int i = 0; i < nameArray.length; i++)
            this.name[i] = nameArray[i];
        for (int i = 0; i < addressArray.length; i++)
            this.address[i] = addressArray[i];
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
        Data Data = (Data) o;
        for (int i = 0; i < name.length; i++){
            try {
                if (name[i] != Data.name[i]) return false;
            }catch (Exception e){return false;}
        }
        for (int i = 0; i < address.length; i++){
            try {
                if (address[i] != Data.address[i]) return false;
            }catch (Exception e){return false;}
        }

        return true;
    }
}
