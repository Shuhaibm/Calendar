package model;

import java.util.ArrayList;

//A day in the calendar
public class Day {
    public int date;
    public ArrayList<Objective> listOfObjective;


    //EFFECTS: creates new Day, set the date to the given parameter, creates an arraylist
    public Day(int date) {
        this.date = date;
        this.listOfObjective = new ArrayList<>();
    }

    //Too many exception
    //MODIFIES: this
    //EFFECTS: adds the given Objective to listOfObjective
    public void addObjective(Objective objective) {
        this.listOfObjective.add(objective);
    }

    //MODIFIES: this
    //EFFECTS: removes the Objective with the given index from listOfObjective
    public void removeObjective(int index) {
        this.listOfObjective.remove(index);
    }


    //EFFECTS: returns date
    public int getDate() {
        return this.date;
    }

    //EFFECTS: returns listOfObjective
    public ArrayList<Objective> getListOfObjective() {
        return this.listOfObjective;
    }


}
