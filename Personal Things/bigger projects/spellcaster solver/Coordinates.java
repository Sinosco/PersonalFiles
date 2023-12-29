import java.util.Objects;

public class Coordinates{
    private int coords1;
    private int coords2;
    private String value;

    public Coordinates(int coord1, int coord2, String[][] board){
        this.coords1 = coord1;
        this.coords2 = coord2;
        value = board[coord1][coord2];
    }


    public int getCoords1(){ return coords1; }
    public void setCoords1(int coords){ coords1 = coords; }

    public int getCoords2(){ return coords2; }
    public void setCoords2(int coords){ coords2 = coords; }

    public String getValueCoords(){ return value; }
    public void setValueCoords(String v){ value = v;}

    public String toString(){ return "[" + coords1 + ", " + coords2+ "]" + " " + value; }
    
    //both below are chatgpt code
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinates other = (Coordinates) obj;
        return coords1 == other.coords1 && coords2 == other.coords2 && value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coords1, coords2, value);
    }

}