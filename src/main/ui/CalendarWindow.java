package ui;

import model.Objective;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;


public class CalendarWindow extends JFrame implements ActionListener {
    JTextField textField;
    JComboBox<Integer> choiceBox;
    JButton addButton;
    JButton removeButton;
    JButton viewButton;

    JFrame frame;
    JPanel panel;

    public CalendarWindow() {
        frame = new JFrame();
        panel = new JPanel();
        initializeStarter();

    }

    // MODIFIES:
    // EFFECTS:
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


    //EFFECTS: Shows the calendar (everyday + objectives
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


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("View Calendar")) {
            initializeShower();
        } else if (e.getActionCommand().equals("Show")) {
            printDay();
        } else if (e.getActionCommand().equals("Back")) {
            initializeStarter();
        } else if (e.getActionCommand().equals("Add an objective")) {
            initializeAdder();
        } else if (e.getActionCommand().equals("Add")) {
            doAddObjective();
        } else if (e.getActionCommand().equals("Remove an objective")) {
            initializeRemover();
        } else if (e.getActionCommand().equals("Remove")) {
            doRemoveObjective();
        } else if (e.getActionCommand().equals("Save Calendar")) {
            CalendarApp.doSaveCalendar();
        } else if (e.getActionCommand().equals("Load Calendar")) {
            CalendarApp.doLoadCalendar();
        } else if (e.getActionCommand().equals("Mark as complete")) {
            initializeCompleter();
        } else if (e.getActionCommand().equals("Complete")) {
            doMarkComplete();
        }
    }



    private void printDay() {
        clearScreen();

        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);

        int date = choiceBox.getSelectedIndex() + 1;
        JLabel dayTitle = new JLabel("Day " + date, SwingConstants.LEFT);


        panel.add(dayTitle);

        ArrayList<Objective> objectives = CalendarApp.calendar.calendarDays.get(date - 1).listOfObjective;
        for (Objective objective : objectives) {
            if (objective.completeStatus) {
                panel.add(new JLabel("       • " + objective.note ));
            } else {
                panel.add(new JLabel("       • " + objective.note));
            }
        }

        panel.add(backButton);

        setUpScreen();
    }



    //MODIFIES: calendar
    //EFFECTS: adds specified objective to the specified date
    private void doAddObjective() {
        int dateIndex = choiceBox.getSelectedIndex();
        String objectiveNote = textField.getText();

        if (!objectiveNote.equals("")) {
            Objective objective = new Objective(objectiveNote);
            CalendarApp.calendar.calendarDays.get(dateIndex).addObjective(objective);
        }

        playSound("./data/bloop_x.wav");

        clearScreen();
        initializeStarter();
    }


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
            clip.open(audioInputStream);
        } catch (IOException | LineUnavailableException | NullPointerException e) {
            e.printStackTrace();
        }
        clip.start();
    }

    //MODIFIES: calendar
    //EFFECTS: removes specified objective from the specified date
    private void doRemoveObjective() {
        int dateIndex = choiceBox.getSelectedIndex();

        try {
            int positionIndex = Integer.parseInt(textField.getText()) - 1;

            if (positionIndex < CalendarApp.calendar.calendarDays.get(dateIndex).listOfObjective.size()) {
                CalendarApp.calendar.calendarDays.get(dateIndex).removeObjective(positionIndex);
            }

        } catch (NumberFormatException e) {
            //do nothing
        } finally {
            playSound("./data/blip.wav");
            clearScreen();
            initializeStarter();
        }
    }

    //MODIFIES: calendar
    //EFFECTS: removes specified objective from the specified date
    private void doMarkComplete() {
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

    private void clearScreen() {
        panel.removeAll();
        revalidate();
        repaint();
    }

    private void setUpScreen() {
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Calendar");
        frame.pack();
        frame.setVisible(true);
    }

}

