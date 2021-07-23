### INSTALLATION INSTRUCTIONS
1. Copy and extract the test repository into your own GitHub repository.
2. Install the DevSpaces Chrome browser extension (Insert link) 
3. ...

### Real Work Analysis
1.  The **test.zip** file

The "/testZipExtracted" folder is generated from the contents of the "test.zip" file archive. Inside, you'll find the **extractingReport.dat** file. This file has information about the extracted files and folders in the "test.zip" archive. The file and folder names should be ordered in the file, but one item in the list does not meet this requirement. 

```Please fix this issue so that all file and folder names are correctly ordered within the "extractingReport.dat" file. Do this by identifying a root cause and fixing it - rather than applying a new sorting algorithm.```

2.  The read-only **destination** folder

When creating a new archive, by attempting to write to a read-only **destination** folder (*note that you may need to create this folder with appropriate permissions in order to reproduce this issue*), you hit a "java.io.IOException: Permission denied" exception. This is because there are no *write* permissions for the "destination" folder. After all, the directory permissions are declared as read only.

However, relying on low level IO exceptions to catch bad inputs is not good practice. 

``Please implement validation code that will enable the application to throw an "IllegalArgumentException" exception instead. You will need to identify the most appropriate method/class to add your code and the fix should be OS agnostic (i.e. work the same on both Windows and Linux environments). ``
