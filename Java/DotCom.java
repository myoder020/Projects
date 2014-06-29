import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;
    private int numOfHits = 0;
    private String dotComName;

    public String checkYourself(String userInput) {
        int guess = Integer.parseInt(userInput);
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            } //close if

        } //end of outter if

        return result;
    }
    
    public void setLocationCells(ArrayList<String> loc) { 
        locationCells = loc;
    }

    public void setName(String name) {
        dotComName = name;
    }


} //close class
