package ui;

import exceptions.NoSuchObjectiveException;

import javax.swing.*;

public class CalendarWindowRemove {

    // MODIFIES: this
    // EFFECTS:  Presents a screen for removing an objective, where the user enters required information
    public static void initializeRemover(CalendarWindow calwin) {
        calwin.clearScreen();

        JLabel title = new JLabel("Remove an Objective", SwingConstants.CENTER);

        JLabel text1 = new JLabel("Position of objective:", SwingConstants.LEFT);
        JLabel text2 = new JLabel("Date:", SwingConstants.LEFT);
        calwin.textField = new JTextField(10);

        Integer[] choices = new Integer[30];
        for (int i = 0; i < 30; i++) {
            choices[i] = i + 1;
        }
        calwin.choiceBox = new JComboBox<>(choices);

        calwin.addButton = new JButton("Remove");
        calwin.addButton.addActionListener(calwin);

        calwin.panel.add(title);
        calwin.panel.add(text2);
        calwin.panel.add(calwin.choiceBox);
        calwin.panel.add(text1);
        calwin.panel.add(calwin.textField);
        calwin.panel.add(calwin.addButton);

        calwin.setUpScreen();
    }


    //MODIFIES: calendar
    //EFFECTS: removes specified objective from the specified date
    public static void doRemoveObjective(CalendarWindow calwin) {
        int dateIndex = calwin.choiceBox.getSelectedIndex();

        try {
            int positionIndex = Integer.parseInt(calwin.textField.getText()) - 1;

            try {
                CalendarApp.calendar.calendarDays.get(dateIndex).removeObjective(positionIndex);
            } catch (NoSuchObjectiveException e) {
                System.out.println("No such objective");
            }


        } catch (NumberFormatException e) {
            //do nothing
        } finally {
            calwin.playSound("./data/blip.wav");
            calwin.clearScreen();
            calwin.initializeStarter();
        }
    }


}
