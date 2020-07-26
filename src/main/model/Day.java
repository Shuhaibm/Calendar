package model;

import exceptions.InvalidDateException;
import exceptions.InvalidObjectiveException;
import exceptions.TooManyObjectivesException;

import java.util.ArrayList;


public class Day {
    public int date;
    public ArrayList<Objective> listOfObjective;
    public final int maxSize = 5;

    //May not need the exception:
    //            if (date < 1 || date > 31) {
    //            throw new InvalidDateException();

    //EFFECTS: creates new Day, set the date to the given parameter, creates an arraylist
    public Day(int date) {
        this.date = date;
        this.listOfObjective = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds the given Objective to listOfObjective
    public void addObjective(Objective objective) {
        if (this.listOfObjective.size() < maxSize) {
            this.listOfObjective.add(objective);
        }
    }

    //MODIFIES: this
    //EFFECTS: removes the given Objective from listOfObjective
    public void removeObjective(Objective objective) {
        if (listOfObjective.contains(objective)) {
            this.listOfObjective.remove(objective);
        }
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
