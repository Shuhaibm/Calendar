package model;

import exceptions.NoSuchObjectiveException;
import exceptions.TooManyObjectivesException;

import java.util.ArrayList;

//A day in the calendar
public class Day {
    public int date;
    public ArrayList<Objective> listOfObjective;

    public static final int MAXOBJECTIVES = 10;



    //EFFECTS: creates new Day, set the date to the given parameter, creates an arraylist
    public Day(int date) {
        this.date = date;
        this.listOfObjective = new ArrayList<>();
    }

    //EFFECTS: creates new Day, set the date to the given parameter, creates an arraylist according to given
    public Day(ArrayList<Objective> objectives, int date) {
        this.date = date;
        this.listOfObjective = objectives;
    }

    //Too many exception
    //MODIFIES: this
    //EFFECTS: adds the given Objective to listOfObjective
    public void addObjective(Objective objective) throws TooManyObjectivesException {
        if (this.listOfObjective.size() < MAXOBJECTIVES) {
            this.listOfObjective.add(objective);
        } else {
            throw new TooManyObjectivesException();
        }
    }

    //MODIFIES: this
    //EFFECTS: removes the Objective with the given index from listOfObjective
    public void removeObjective(int index) throws NoSuchObjectiveException {
        if (index < listOfObjective.size()) {
            this.listOfObjective.remove(index);
        } else {
            throw new NoSuchObjectiveException();
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
