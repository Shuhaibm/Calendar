package ui;

import model.Day;
import model.Objective;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CalendarWindow {
    JTextField textField;
    JComboBox<Integer> choiceBox;
    JButton addButton;
    JButton removeButton;

    public CalendarWindow() {
        JFrame frame = new JFrame("Add an objective");

        textField = new JTextField(10);
        addButton = new JButton("Add an objective");
        removeButton = new JButton("Remove an objective");

        ArrayList<Integer> choices = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            choices.add(i);
        }
        choiceBox = new JComboBox<>((ComboBoxModel<Integer>) choices);


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

}
