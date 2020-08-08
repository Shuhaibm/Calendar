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
    final JComboBox<Integer> choiceBox;
    JButton addButton;

    public CalendarWindow() {
        JFrame frame = new JFrame("Add an objective");

        textField = new JTextField(10);


        addButton = new JButton("Add an objective");
        //JButton removeButton = new JButton("Remove an objective");

        addButton.addActionListener(this);

        Integer[] choices;
        choices = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

        choiceBox = new JComboBox<>(choices);



        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
            }
        });

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,10,30,30));
        panel.setLayout(new GridLayout(0,1));

        //panel.add(removeButton);
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
