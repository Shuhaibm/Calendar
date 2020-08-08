package ui;

import model.Day;
import model.Objective;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CalendarWindow implements ActionListener {
    JTextField textField;
    JComboBox<Integer> choiceBox;
    JButton addButton;
    JButton removeButton;

    public CalendarWindow() {
        JFrame frame = new JFrame("Add an objective");

        textField = new JTextField(10);
        addButton = new JButton("Add an objective");
        removeButton = new JButton("Remove an objective");

        addButton.addActionListener(this);
        removeButton.addActionListener(this);

        ArrayList<Integer> choices = new ArrayList<Integer>();
        for (Integer i = 1; i < 31; i++) {
            choices.add(i);
        }

        choiceBox = new JComboBox<Integer>((ComboBoxModel<Integer>) choices);


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,10,30,30));
        panel.setLayout(new GridLayout(0,1));

        panel.add(removeButton);
        panel.add(textField);
        panel.add(addButton);
        panel.add(choiceBox);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Calendar");
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        doAddObjective();
    }

    private void doAddObjective() {
        int dateIndex = choiceBox.getSelectedIndex();
        String objectiveNote = textField.getText();
        Objective objective = new Objective(objectiveNote);
        CalendarApp.calendar.calendarDays.get(dateIndex).addObjective(objective);
    }
}
