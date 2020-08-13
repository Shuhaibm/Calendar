# My Personal Project

## Calendar

All throughout highschool, my teachers **constantly** encouraged the use of agendas, but I never found 
the need to use one. However, once I entered university, it immediately became clear that an agenda
would make my life much easier, and help me stay on top of classes. I began to print out a calendar
every month, and list out all the things I needed to get done. These included:
- Assignments
- Forms/Paperwork
- Meetings
- Events 

I will stop wasting paper and take advantage of technology by creating a calendar application. I will
use this application instead of what I have been doing up until now. The application will present a 
monthly calendar, where the user can add items to a specific day, and check them off when they have 
been completed. 


## User Stories
- As a user, I want to be able to add multiple objectives to any day in my Calendar
- As a user, I want to be able to check off an objective and mark it complete
- As a user, I want to be able to remove an objective from a day in my Calendar
- As a user, I want to be able to view all objectives in each day in my Calendar

- As a user, I want to be able to the option to save my Calendar file when I quit
- As a user, I want to have the option of loading the previously saved Calendar when the program starts
 
 
 ## Instructions for Grader

- You can generate the first required event by clicking the "Add an Objective" button, entering an 
  objective in the text box, selecting the date you want to add to from the drop down menu, 
  and clicking the "Add" button. This will add an objective to the specified date.
- You can generate the second required event by clicking the "Remove an Objective" button, selecting
  the date you want to edit from the drop down menu, entering the position of the objective in the 
  text box and clicking the "Remove" button. This will remove the specified objective from the specified
  date.
- You can generate another second required event by clicking the "View Calendar" button, selecting
  the date you want to view from the drop down menu, and clicking the "Show" button. This will show all 
  the objectives of the specified date.
- You can generate another second required event by clicking the "Mark as complete" button, selecting
  the date and position of the objective you want to mark as complete, and this will mark that objective 
  as completed.
- You can trigger my audio component by clicking the "Add an Objective" button, then clicking the 
  "Add" button for the first sound, and clicking the "Remove an Objective" button, then clicking the
  "Remove" button for the second sound.
- You can save the state of my application by clicking the "Save Calendar" button.
- You can reload the state of my application by clicking the "Load Calendar" button.


## Phase 4: Task 2
For Task 2, I chose the first option, "Test and design a class that is robust". I have added two 
exceptions to my Day class. 
- The first exception I added is called TooManyObjectivesException, and 
  I added it to my addObjective() method in the Day class. This exception helps puts a limit to how 
  many objectives a user can add to a single day. This is tested in the DayTest class, testAddObjective()
  is the test where the exception is not excepted, and testTooManyObjectivesException() is the test
  where the exception is expected.
- The second exception I have added is called the NoSuchObjectiveException, and I have added it to 
  the removeObjective() method in the Day class. This exception is called when the position of the 
  objective entered does not refer to an objective in the selected day. This is tested in the DayTest 
  class, testRemoveObjective() is the test where the exception is not excepted and 
  testNoSuchObjective() is the test where the exception is expected.
  
## Phase 4: Task 3
For Task 3, here are the decisions I made to enhance the code design:
- In order to make the code more readable and for cohesion of my methods,  I took out the code that 
  sets up the screen, and put it into the setUpScreen() method in my CalendarWindow class
- In order to make the code more readable  and for cohesion of my methods, I took out the code that 
  clears the screen, and put it into the clearScreen() method in my CalendarWindow class  
- In order to make the code more readable and for cohesion of my methods, I took out the code that 
  plays a sound, and put it into the playSound() method in my CalendarWindow class
  
- To improve the cohesion of my CalendarWindow class, and to enforce the Single Responsibility Principle,
  I created multiple subclasses that carry out the methods that were originally in the CalendarWindow
  class. I created a CalendarWindowAdd class, that is responsible for when the user is adding an objective.
  I created a CalendarWindowRemove class, that is responsible for when the user is removing an objective.
  I created a CalendarWindowComplete class, that is responsible for when the user is completing an objective.
  I created a CalendarWindowView class, that is responsible for when the user is viewing an objective. 
      
 
 

 

