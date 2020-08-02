package persistence;

import model.Day;
import model.MyCalendar;
import model.Objective;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static final String DELIMITER = ",";
    public static final String DAYDELIMITER = "/";



    // EFFECTS: returns a list of calendars parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<MyCalendar> readCalendars(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return makeCalendars(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of calendars parsed from list of strings
    private static List<MyCalendar> makeCalendars(List<String> fileContent) {
        List<MyCalendar> calendars = new ArrayList<>();
        for (String line : fileContent) {
            ArrayList<String> lineDays = splitStringDays(line);
            ArrayList<Day> listOfDays = new ArrayList<>();

            for (String day: lineDays) {
                String[] splits = day.split(DELIMITER);
                ArrayList<String> componentList = new ArrayList<>(Arrays.asList(splits));
                //date, note, complete status, note, complete status...
                //Make a day: day(listofObjectives, date)
                int date = Integer.parseInt(componentList.get(0));
                componentList.remove(0);
                ArrayList<Objective> objectives = makeObjectives(componentList);
                listOfDays.add(new Day(objectives, date));
            }
            calendars.add(new MyCalendar(listOfDays));
        }
        return calendars;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitStringDays(String line) {
        String[] splits = line.split(DAYDELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }


    private static ArrayList<Objective> makeObjectives(ArrayList<String> componentList) {
        ArrayList<Objective> objectives = new ArrayList<>();
        while (!componentList.isEmpty()) {
            String note = componentList.get(0);
            Boolean completeStatus = Boolean.parseBoolean(componentList.get(1));

            objectives.add(new Objective(note, completeStatus));

            componentList.remove(0);
            componentList.remove(0);
        }

        return objectives;
    }
}
