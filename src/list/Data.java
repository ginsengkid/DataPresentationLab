package list;

public class Data {
    private char[] name = new char[20];
    private char[] address = new char[50];

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

    public void setAddress(char[] a){
        address = new char[50];
        for (int i = 0; i < a.length; i++)
            this.address[i] = a[i];
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
        return (compareCharArrays(Data.name, this.name) && compareCharArrays(Data.address, this.address));
    }

    public boolean compareCharArrays(char[] q1, char[] q2){
        int len = Math.min(q1.length, q2.length);
        for (int i = 0; i < len; i++){
            if (q1[i] == '0' || q2[i] == '0') continue;
            if (q1[i] != q2[i]) return false;
        }
        return true;
    }
}
