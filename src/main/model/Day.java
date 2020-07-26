package model;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class Day {
    public int date;
    public ArrayList<Objective> listOfObjective;

    //REQUIRES:date must be an int from 1 to 31
    //EFFECTS: creates new Day, set the date to the given parameter, creates an arraylist
    public Day(int date) {
        this.date = date;
        this.listOfObjective = new ArrayList<>();
    }

    //REQUIRES: There must be no more than 5? objects in a day
    //MODIFIES: this
    //EFFECTS: adds the given Objective to listOfObjective
    public void addObjective(Objective objective) {
        this.listOfObjective.add(objective);
    }

    //REQUIRES: listOfObject to be nonempty
    //MODIFIES: this
    //EFFECTS: removes the given Objective from listOfObjective
    public void removeObjective(Objective objective) {
        this.listOfObjective.remove(objective);
    }



    public int getDate() {
        return this.date;
    }

    public ArrayList<Objective> getListOfObjective() {
        return this.listOfObjective;
    }


}
