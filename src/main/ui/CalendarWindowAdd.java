package ui;

import exceptions.TooManyObjectivesException;
import model.Objective;

import javax.swing.*;


//Add functions of CalendarWindow
public class CalendarWindowAdd {


    // MODIFIES: this
    // EFFECTS:  Presents a screen for adding an objective, where the user enters required information
    public static void initializeAdder(CalendarWindow calwin) {
        calwin.clearScreen();

        JLabel title = new JLabel("Add an Objective", SwingConstants.CENTER);
        calwin.textField = new JTextField(10);

        Integer[] choices = new Integer[30];
        for (int i = 0; i < 30; i++) {
            choices[i] = i + 1;
        }
        calwin.choiceBox = new JComboBox<>(choices);

        JLabel text1 = new JLabel("Date:", SwingConstants.LEFT);
        JLabel text2 = new JLabel("Objective:", SwingConstants.LEFT);

        calwin.addButton = new JButton("Add");
        calwin.addButton.addActionListener(calwin);

        calwin.panel.add(title);
        calwin.panel.add(calwin.textField);
        calwin.panel.add(text1);
        calwin.panel.add(calwin.choiceBox);
        calwin.panel.add(text2);
        calwin.panel.add(calwin.addButton);

        calwin.setUpScreen();
    }

    //MODIFIES: calendar
    //EFFECTS: adds specified objective to the specified date
    public static void doAddObjective(CalendarWindow calwin) {
        int dateIndex = calwin.choiceBox.getSelectedIndex();
        String objectiveNote = calwin.textField.getText();

        if (!objectiveNote.equals("")) {
            Objective objective = new Objective(objectiveNote);
            try {
                CalendarApp.calendar.calendarDays.get(dateIndex).addObjective(objective);
            } catch (TooManyObjectivesException e) {
                System.out.println("Too many objectives for this day");
            }
        }

        calwin.playSound("./data/bloop_x.wav");

        calwin.clearScreen();
        calwin.initializeStarter();
    }


}
