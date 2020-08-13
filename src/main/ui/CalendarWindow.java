package ui;

import exceptions.NoSuchObjectiveException;
import exceptions.TooManyObjectivesException;
import model.Objective;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;



// Calendar graphical user interface
public class CalendarWindow extends JFrame implements ActionListener {

    JTextField textField;
    JComboBox<Integer> choiceBox;
    JButton addButton;
    JButton removeButton;
    JButton viewButton;
    JFrame frame;
    JPanel panel;


    // EFFECTS: initializes the graphical user interface
    public CalendarWindow() {
        frame = new JFrame();
        panel = new JPanel();
        initializeStarter();
    }

    // MODIFIES: this
    // EFFECTS:  Presents a menu option for the user to choose a command
    public void initializeStarter() {
        clearScreen();
        viewButton = new JButton("View Calendar");
        viewButton.addActionListener(this);
        addButton = new JButton("Add an objective");
        addButton.addActionListener(this);
        removeButton = new JButton("Remove an objective");
        removeButton.addActionListener(this);
        JButton completeButton = new JButton("Mark as complete");
        completeButton.addActionListener(this);
        JButton saveButton = new JButton("Save Calendar");
        saveButton.addActionListener(this);
        JButton loadButton = new JButton("Load Calendar");
        loadButton.addActionListener(this);

        panel.add(viewButton);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(completeButton);
        panel.add(saveButton);
        panel.add(loadButton);

        setUpScreen();
    }


    // EFFECTS:  Reads the user's action performed and runs the corresponding method
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("View Calendar")) {
            CalendarWindowView.initializeShower(this);
        } else if (e.getActionCommand().equals("Show")) {
            CalendarWindowView.printDay(this);
        } else if (e.getActionCommand().equals("Back")) {
            initializeStarter();
        } else if (e.getActionCommand().equals("Add an objective")) {
            CalendarWindowAdd.initializeAdder(this);
        } else if (e.getActionCommand().equals("Add")) {
            CalendarWindowAdd.doAddObjective(this);
        } else if (e.getActionCommand().equals("Remove an objective")) {
            CalendarWindowRemove.initializeRemover(this);
        } else if (e.getActionCommand().equals("Remove")) {
            CalendarWindowRemove.doRemoveObjective(this);
        } else if (e.getActionCommand().equals("Save Calendar")) {
            CalendarApp.doSaveCalendar();
        } else if (e.getActionCommand().equals("Load Calendar")) {
            CalendarApp.doLoadCalendar();
        } else if (e.getActionCommand().equals("Mark as complete")) {
            CalendarWindowComplete.initializeCompleter(this);
        } else if (e.getActionCommand().equals("Complete")) {
            CalendarWindowComplete.doMarkComplete(this);

        }
    }


    // REQUIRES: audio file to exist
    // EFFECTS:  Plays the specified audio file
    public void playSound(String addSound) {

        // source for sound files: https://www.wavsource.com/sfx/sfx.htm

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(addSound).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            assert clip != null;
            clip.open(audioInputStream);
        } catch (IOException | LineUnavailableException | NullPointerException e) {
            e.printStackTrace();
        }
        clip.start();
    }


    // MODIFIES: this
    // EFFECTS:  Clears the current panel
    public void clearScreen() {
        panel.removeAll();
        revalidate();
        repaint();
    }

    // MODIFIES: this
    // EFFECTS: sets up the repetitive commands for the panel and the frame
    public void setUpScreen() {
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Calendar");
        frame.pack();
        frame.setVisible(true);
    }
}

    /*
    // MODIFIES: this
    // EFFECTS:  Presents a screen for adding an objective, where the user enters required information
    public void initializeAdder() {
        clearScreen();

        JLabel title = new JLabel("Add an Objective", SwingConstants.CENTER);
        textField = new JTextField(10);

        Integer[] choices = new Integer[30];
        for (int i = 0; i < 30; i++) {
            choices[i] = i + 1;
        }
        choiceBox = new JComboBox<>(choices);

        JLabel text1 = new JLabel("Date:", SwingConstants.LEFT);
        JLabel text2 = new JLabel("Objective:", SwingConstants.LEFT);

        addButton = new JButton("Add");
        addButton.addActionListener(this);

        panel.add(title);
        panel.add(textField);
        panel.add(text1);
        panel.add(choiceBox);
        panel.add(text2);
        panel.add(addButton);

        setUpScreen();
    }
    */

    /*

    //MODIFIES: calendar
    //EFFECTS: adds specified objective to the specified date
    private void doAddObjective() {
        int dateIndex = choiceBox.getSelectedIndex();
        String objectiveNote = textField.getText();

        if (!objectiveNote.equals("")) {
            Objective objective = new Objective(objectiveNote);
            try {
                CalendarApp.calendar.calendarDays.get(dateIndex).addObjective(objective);
            } catch (TooManyObjectivesException e) {
                System.out.println("Too many objectives for this day");
            }
        }

        playSound("./data/bloop_x.wav");

        clearScreen();
        initializeStarter();
    }
    */

        /*
    // MODIFIES: this
    // EFFECTS:  Presents a screen for removing an objective, where the user enters required information
    private void initializeRemover() {
        clearScreen();

        JLabel title = new JLabel("Remove an Objective", SwingConstants.CENTER);

        JLabel text1 = new JLabel("Position of objective:", SwingConstants.LEFT);
        JLabel text2 = new JLabel("Date:", SwingConstants.LEFT);
        textField = new JTextField(10);

        Integer[] choices = new Integer[30];
        for (int i = 0; i < 30; i++) {
            choices[i] = i + 1;
        }
        choiceBox = new JComboBox<>(choices);

        addButton = new JButton("Remove");
        addButton.addActionListener(this);

        panel.add(title);
        panel.add(text2);
        panel.add(choiceBox);
        panel.add(text1);
        panel.add(textField);
        panel.add(addButton);

        setUpScreen();
    }
    */


/*
    //MODIFIES: calendar
    //EFFECTS: removes specified objective from the specified date
    private void doRemoveObjective() {
        int dateIndex = choiceBox.getSelectedIndex();

        try {
            int positionIndex = Integer.parseInt(textField.getText()) - 1;

            try {
                CalendarApp.calendar.calendarDays.get(dateIndex).removeObjective(positionIndex);
            } catch (NoSuchObjectiveException e) {
                System.out.println("No such objective");
            }


        } catch (NumberFormatException e) {
            //do nothing
        } finally {
            playSound("./data/blip.wav");
            clearScreen();
            initializeStarter();
        }
    }
*/


/*
    // MODIFIES: this
    // EFFECTS:  Presents a screen for completing an objective, where the user enters required information
    private void initializeCompleter() {
        clearScreen();

        JLabel title = new JLabel("Complete an Objective", SwingConstants.CENTER);

        JLabel text1 = new JLabel("Position of objective:", SwingConstants.LEFT);
        JLabel text2 = new JLabel("Date:", SwingConstants.LEFT);
        textField = new JTextField(10);

        Integer[] choices = new Integer[30];
        for (int i = 0; i < 30; i++) {
            choices[i] = i + 1;
        }
        choiceBox = new JComboBox<>(choices);

        addButton = new JButton("Complete");
        addButton.addActionListener(this);

        panel.add(title);
        panel.add(text2);
        panel.add(choiceBox);
        panel.add(text1);
        panel.add(textField);
        panel.add(addButton);

        setUpScreen();
    }
*/
/*
    //MODIFIES: calendar
    //EFFECTS: removes specified objective from the specified date
    public void doMarkComplete() {
        int dateIndex = choiceBox.getSelectedIndex();

        try {
            int positionIndex = Integer.parseInt(textField.getText()) - 1;

            if (positionIndex < CalendarApp.calendar.calendarDays.get(dateIndex).listOfObjective.size()) {
                CalendarApp.calendar.calendarDays.get(dateIndex).listOfObjective.get(positionIndex).markComplete();
            } else {
                System.out.println("No objective to mark as complete here");
            }
        } catch (NumberFormatException e) {
            //do nothing
        } finally {
            clearScreen();
            initializeStarter();
        }
    }
*/

/*
    // MODIFIES: this
    // EFFECTS:  Presents a screen for showing the calendar, where the user enters required information
    private void initializeShower() {
        clearScreen();

        JLabel title = new JLabel("Select date:", SwingConstants.LEFT);

        addButton = new JButton("Show");
        addButton.addActionListener(this);

        Integer[] choices = new Integer[30];
        for (int i = 0; i < 30; i++) {
            choices[i] = i + 1;
        }
        choiceBox = new JComboBox<>(choices);

        panel.add(title);
        panel.add(choiceBox);
        panel.add(addButton);

        setUpScreen();
    }


    // MODIFIES: this
    // EFFECTS:  Prints out all the objectives in a day
    private void printDay() {
        clearScreen();

        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);

        int date = choiceBox.getSelectedIndex() + 1;
        JLabel dayTitle = new JLabel("Day " + date, SwingConstants.LEFT);


        panel.add(dayTitle);

        ArrayList<Objective> objectives = CalendarApp.calendar.calendarDays.get(date - 1).listOfObjective;
        for (Objective objective : objectives) {
            panel.add(new JLabel("       • " + objective.note));
        }

        panel.add(backButton);

        setUpScreen();
    }

*/




