package model;

import exceptions.TooManyObjectivesException;

import java.util.ArrayList;


public class Day {
    public int date;
    public ArrayList<Objective> listOfObjective;
    public final int maxSize = 5;


    //EFFECTS: creates new Day, set the date to the given parameter, creates an arraylist
    public Day(int date) {
        this.date = date;
        this.listOfObjective = new ArrayList<>();
    }

    //Too many exception
    //MODIFIES: this
    //EFFECTS: adds the given Objective to listOfObjective
    public void addObjective(Objective objective) throws TooManyObjectivesException {
        if (this.listOfObjective.size() < maxSize) {
            this.listOfObjective.add(objective);
        } else {
            throw new TooManyObjectivesException();
        }
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
