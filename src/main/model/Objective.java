package model;

//Objectives that the user has
public class Objective {
    public String note;
    public Boolean completeStatus;


    //EFFECTS: Creates an objective, note on objective is set to objectiveNote, completeStatus is set to false
    public Objective(String objectiveNote) {
        note = objectiveNote;
        completeStatus = false;
    }

    //EFFECTS: Creates an objective, note on objective is set to objectiveNote, completeStatus is set to false
    public Objective(String objectiveNote, Boolean completeStatus) {
        note = objectiveNote;
        this.completeStatus = completeStatus;
    }


    //MODIFIES: this
    //EFFECTS: sets the completeStatus for the objective to true and adds COMPLETE to note
    public void markComplete() {
        if (!this.completeStatus) {
            this.completeStatus = true;
            this.note = this.note + " COMPLETE";
        }
    }

    //EFFECTS: returns note
    public String getNote() {
        return this.note;
    }

    //EFFECTS: returns completeStatus
    public Boolean getCompleteStatus() {
        return this.completeStatus;
    }

}
