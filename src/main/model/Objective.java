package model;

public class Objective {
    public String note;
    public Boolean completeStatus;


    //REQUIRES: objectiveNote be a non empty string
    //EFFECTS: note on objective is set to objectiveNote, completeStatus is set to false
    public Objective(String objectiveNote) {
        note = objectiveNote;
        completeStatus = false;
    }


    //May not need this method!!!
    //REQUIRES: this.note to have no value
    //MODIFIES: this
    //EFFECTS: sets the note for the objective to the given parameter
    //public void setNote(String note) {
    //    this.note = note;
    //}


    //REQUIRES: this.completeStatus to be false
    //MODIFIES: this
    //EFFECTS: sets the completeStatus for the objective to true
    public void markComplete() {
        this.completeStatus = true;
    }


    public String getNote() {
        return this.note;
    }

    public Boolean getCompleteStatus() {
        return this.completeStatus;
    }

}
