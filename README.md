### INSTRUCTIONS FOR CANDIDATES
1. Install the [DevSpaces Chrome browser extension](https://chrome.google.com/webstore/detail/devspaces-dev-environment/dmbijlfedfamdpenajngckdlehjighfi?hl=en) 
2. Copy the BOJR repository into your own GitHub account (*make sure your new repo is private*)
3. Click on the DevSpaces button that appears above (*top right*) your copied repo to launch the IDE
4. Analyze and identify the root causes of the following two issues and add your fixes to the code (*See Debugging in DevSpaces below for more*)
5. Submit both fixes as a SINGLE pull request
6. Add 'yikunchen' and 'trilogymercer' as collaborators and share the link to your PR as your submission response

### Real Work Analysis
1.  The **test.zip** file

```SETUP: Run the DevSpaces debugger on the ExtractArchive.java file in the test folder.```

The "/testZipExtracted" folder is generated from the contents of the "test.zip" file archive. Inside, you'll find the **extractingReport.dat** file. This file has information about the extracted files and folders in the "test.zip" archive. We expect the file and folder names to be ordered alphabetically, but one item in the list is not. 

```
Please fix this issue so that all file and folder names are correctly ordered within the "extractingReport.dat" file. 

Do this by identifying a root cause and fixing it - rather than applying a new sorting algorithm.
```

2.  The read-only **destination** folder

```
SETUP: Create the destination folder without write permissions using these commands in the DevSpaces terminal:

mkdir destination
chmod 0444 destination

This will create a folder called 'destination' and set the correct permissions to duplicate the issue. 

Run the DevSpaces debugger on the CreateArchive.java file in the test folder.
```

When creating a new archive, by attempting to write to a read-only **destination** folder, you'll hit a "java.io.IOException: Permission denied" exception. This is because there are no *write* permissions for the **destination** folder.

However, relying on low level IO exceptions to catch bad inputs is not good practice. 

```
Please implement validation code that will enable the application to throw an "IllegalArgumentException" exception instead. 

Identify the most appropriate method/class to add your code and the fix should work the same on both Windows and Linux.
```

### Debugging in DevSpaces
DevSpaces is an online, browser based debugger that offers many of the same features and functionality you'll be familiar with in your own favorite IDE. Just one of the many great projects you could contribute to when you join.

Go to any java file you want to debug, hover on the left of the line number and click to enable a break point there.

Click the *Play* button (*top right*) and select *Debug Java*.
