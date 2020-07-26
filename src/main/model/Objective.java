package model;

public class Objective {
    public String note;
    public Boolean completeStatus;


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


    //MODIFIES: this
    //EFFECTS: sets the completeStatus for the objective to true
    public void markComplete() {
        if (this.completeStatus == false) {
            this.completeStatus = true;
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
