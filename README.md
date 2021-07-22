### INSTALLATION INSTRUCTIONS
- Copy the provided repository folder.
- Create your own Git repository in the Github
- In a browser, navigate to your project’s GitHub
- In the browser’s address bar, prefix the entire URL with gitpod.io/# and press Enter. For sample: gitpod.io/#https://github.com/gitpod-io/website

### BUG1
#### How to Execute?
- Compile the application:
```sh
mvn compile
```
- Execute the extracting the **test.zip** file in the repository:
```sh
mvn compile exec:java -Dexec.mainClass="com.application.archive.test.ExtractArchive" -Dexec.args="test.zip /workspace/bojr/testZipExtracted"
```
- Go to the generated testZipExtracted folder and open the **extractingReport.dat** file:
```sh
cd testZipExtracted
nano extractingReport.dat
```
#### Symptoms
When you execute, the "/testZipExtracted" folder is generated with the content of the "test.zip" file archive. You notice the **extractingReport.dat** file inside the "testZipExtracted" folder. This file has information about the extracted files and folders in the "test.zip" file. The file and folder names should be ordered in the file, but one item in the list does not meet this requirement and inserted in the wrong order in the list. 

#### Expectation
Please fix this issue and all file and folder names should be ordered properly in the "extractingReport.dat" file.

### BUG2
#### How to Execute?
...
#### Symptoms
When you execute to create archive, you hit the "java.io.IOException: Access is denied" exception. Because the current user has no *write* permission for the "output" folder to create the "sample.zip" file in the "output" folder. As the directory permissions are in the Operating System level, this is expected.

#### Expectation
we would like to check the permissions of the destination folder in earlier stage of the program execution and throw the **IllegalArgumentException** exception with a clear message rather than throwing the "java.io.IOException" in the lower layers. Please add this proper code and enable the application that will throw **IllegalArgumentException** exception in this case. Please note that the code should be put in the best ideal location(method, class) of the code repository and it should execute fine and same in both Windows and Linux environments. 
