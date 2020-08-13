package ui;

import javax.swing.*;

public class CalendarWindowComplete {
    // MODIFIES: this
    // EFFECTS:  Presents a screen for completing an objective, where the user enters required information
    public static void initializeCompleter(CalendarWindow calwin) {
        calwin.clearScreen();

        JLabel title = new JLabel("Complete an Objective", SwingConstants.CENTER);

        JLabel text1 = new JLabel("Position of objective:", SwingConstants.LEFT);
        JLabel text2 = new JLabel("Date:", SwingConstants.LEFT);
        calwin.textField = new JTextField(10);

        Integer[] choices = new Integer[30];
        for (int i = 0; i < 30; i++) {
            choices[i] = i + 1;
        }
        calwin.choiceBox = new JComboBox<>(choices);

        calwin.addButton = new JButton("Complete");
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
    public static void doMarkComplete(CalendarWindow calwin) {
        int dateIndex = calwin.choiceBox.getSelectedIndex();

        try {
            int positionIndex = Integer.parseInt(calwin.textField.getText()) - 1;

            if (positionIndex < CalendarApp.calendar.calendarDays.get(dateIndex).listOfObjective.size()) {
                CalendarApp.calendar.calendarDays.get(dateIndex).listOfObjective.get(positionIndex).markComplete();
            } else {
                System.out.println("No objective to mark as complete here");
            }
        } catch (NumberFormatException e) {
            //do nothing
        } finally {
            calwin.clearScreen();
            calwin.initializeStarter();
        }
    }

}
