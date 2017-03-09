# Data-Security-Privacy-Project
Developing a secure healthcare database.

NOTE: THE JAR AND THE "resources" FOLDER MUST BE IN THE SAME DIRECTORY! THIS WILL NO LONGER BE NECESSARY ONCE ROLES ARE IMPLEMENTED!

HOW TO RUN (an example):

1. Double-click the executable jar file Data-Security-Privacy-Project.jar in the Program directory.

2. If there is an error message, then the GUI will essentially run in disconnected mode, meaning the queries won't work. If clicking the executable jar doesn't work, try the alternate steps below. Otherwise, continue to step 3.

    ALTERNATE STEPS (between steps 2 and 3):

    a. Open up a command prompt
	
	b. navigate to Eclipse-Project/Data-Security-Privacy-Project
	
	c. Run the following command:
	
		java -cp "bin;lib/mysql-connector-java-5.1.41-bin.jar" dsp.main.Main
		
	d. If the command worked, continue to step 3. Otherwise, there may be an issue with connecting to the database or the program's ability to read the password file.
	
3. Click "Show tables" to show the tables.

4. Click either the "X" or "OK" or Cancel to exit this dialog.

5. Click "Select..."

NOTE: For the typing directions below, exclude the quotations.

6. Type "*" into the "SELECT" text field.

7. Type "Doctor" into the "FROM" text field.

8. Type "fname" into the first "WHERE" text field.

9. Type "Gal" into the second "WHERE" text field.

10. Press "Ok", and one search result should come up.

11. Type in any other desireable queries, using any of the tables from the "Show Tables" dialog, and repeat the process.