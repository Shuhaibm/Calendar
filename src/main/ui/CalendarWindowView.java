package ui;

import model.Objective;

import javax.swing.*;
import java.util.ArrayList;

public class CalendarWindowView extends CalendarWindow {

    // MODIFIES: this
    // EFFECTS:  Presents a screen for showing the calendar, where the user enters required information
    public static void initializeShower(CalendarWindow calwin) {
        calwin.clearScreen();

        JLabel title = new JLabel("Select date:", SwingConstants.LEFT);

        calwin.addButton = new JButton("Show");
        calwin.addButton.addActionListener(calwin);

        Integer[] choices = new Integer[30];
        for (int i = 0; i < 30; i++) {
            choices[i] = i + 1;
        }
        calwin.choiceBox = new JComboBox<>(choices);

        calwin.panel.add(title);
        calwin.panel.add(calwin.choiceBox);
        calwin.panel.add(calwin.addButton);

        calwin.setUpScreen();
    }


    // MODIFIES: this
    // EFFECTS:  Prints out all the objectives in a day
    public static void printDay(CalendarWindow calwin) {
        calwin.clearScreen();

        JButton backButton = new JButton("Back");
        backButton.addActionListener(calwin);

        int date = calwin.choiceBox.getSelectedIndex() + 1;
        JLabel dayTitle = new JLabel("Day " + date, SwingConstants.LEFT);


        calwin.panel.add(dayTitle);

        ArrayList<Objective> objectives = CalendarApp.calendar.calendarDays.get(date - 1).listOfObjective;
        for (Objective objective : objectives) {
            calwin.panel.add(new JLabel("       • " + objective.note));
        }

        calwin.panel.add(backButton);

        calwin.setUpScreen();
    }

}
