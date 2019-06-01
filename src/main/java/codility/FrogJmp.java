package codility;

public class FrogJmp {

    //O(1)
    public int solution(int X, int Y, int D) {
        int result = (Y - X) / D;
        return (Y - X) % D == 0 ? result : ++result;
    }

}
