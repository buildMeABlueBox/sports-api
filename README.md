# sports-api

Since VS Code does not have a template to start a maven project quickly we'll do it manually.

**Prerequisite installation:**

  - Apache Maven 
    - linux: sudo apt-get install maven
    - OS X:  brew install maven
  - Visual Studio Code
  
**Creating New Maven Project:**

     Go to appropriate folder for where the project should be created and run the set of commands:
     
       - mvn archetype:generate
       
       - Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 1202:
          - 1606 (this is for making a rest api using jax-rs specification using jersey implementation)
          
       - Choose a number: 7:
          - 71 (this is version 2.26b03 because higher versions give a factory manager error)
          
       - Define value for property 'groupId':
          - com.<<COMPANY_NAME>>.<<APP_NAME>>
          
       - Define value for property 'artifactId':
          - <<APP_NAME>>
          
       - Define value for property 'version' 1.0-SNAPSHOT:
          - [enter]
          
       - Define value for property 'package' com.homebase.sportsapi:
          - [enter]

**VS Code Setup:**


Open the Command Palette (via the View menu or by right-clicking) and type in and select Tasks: Configure task then select Create tasks.json from template.
Choose maven ("Executes common Maven commands"). This creates a tasks.json file with "verify" and "test" tasks. More can be added corresponding to other Maven Build Lifecycle phases. To specifically address your requirement for classes to be built without a JAR file, a "compile" task would need to be added as follows:
 
 
 
{
    "label": "compile",
    "type": "shell",
    "command": "mvn -B compile",
    "group": "build"
}


Save the above changes and then open the Command Palette and select "Tasks: Run Build Task" then pick "compile" and then "Continue without scanning the task output". This invokes Maven, which creates a target folder at the same level as the src folder with the compiled class files in the target\classes folder.

**Running app on Servlet Container using Visual Studio Code (Tomcat/Grizzly/Heroku):**

    Prerequisites:
      - Servlet Container - Tomcat in this example 
      - Tomcat Extentsion for VS Code
          - Linux: sudo apt-get install tomcat8
          - 0S X:     brew install tomcat
      - VS Code Maven Extension
      - .war file 
          - after cloning repo, either use already generated war inside of repo OR generate war by running mvn install or clicking on install in the maven extension as seen in pic below.
 
**Steps to run app:**

    * Point tomcat extention to libexec inside of tomcat folder ($TOMCAT_FOLDER/libexec) for mac otherwise on linux point it to $CATALINA_HOME
    * Right click on generated war and click on Run on Tomcat Server as seen in the picture below


