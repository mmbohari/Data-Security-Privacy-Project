# Data-Security-Privacy-Project
A secure healthcare database management system.

HOW TO RUN (an example):

1. Double-click the executable jar file Data-Security-Privacy-Project.jar in the Program directory.

NOTE: This will create a "database_url.txt" file in the same directory as the jar. If the file can't be created, the default MariaDB url will be used. database_url.txt will contain a url to the desired host to connect to. You can use your username and password, combined with the MariaDB url in this text file, to connect to the database and perform extra actions (such as inserting data, provided that your user's role has permission to do so) via third-party applications.

2. If there is an error message, then the GUI will essentially run in disconnected mode, meaning the queries won't work. If the program connected successfully, continue to step 3.

EXAMPLE USAGE:

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