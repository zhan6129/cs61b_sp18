
public class OffByN implements CharacterComparator
{
    private int Diff;
    
    public OffByN(int N) {
        Diff = N;       
    }
    
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == Diff || diff == -Diff) {
            return true;
        }
        return false;
    }

}
