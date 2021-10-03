package array;

public class Position {
    private int x;
    public Position(int number){
        x = number;
    }

    public int getX() {
        return x;
    }
    public int getP() {
        return x;
    }
    public void increaseByOne() {
        this.x += 1;
    }

    public void decreaseByOne() {
        this.x -= 1;
    }


}
