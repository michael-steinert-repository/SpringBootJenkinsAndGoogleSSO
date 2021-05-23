# Jenkins

* Jenkins is a Continuous Integration Tool used to build (compile and test) Code and deploy it to the Production Enviroment
* It is a Server-based System that runs in Servlet Containers such as Apache Tomcat
* It supports Version Control Tools like Git to automate build the Code

## Continuous Integration

* Continuous Integration is a Process in which all Development Work is integrated as early as possible.
* The resulting Artifacts are automatically created and tested
* This Process allows to dentify Errors as early as possible

1) The Developers push their Changes to the Source Code Repository
1) The Build Server pull the Changes from the Repository
1) The Build Server will build, test and deploy the Changes
   1.1) If there is an Error while Building or Testing the Changes the Build Server will not put the Changes in the Realese and will notify the Developers (Failure)
   1.1) If there is no Error the Build Server will put the Changes into the Release and will notify the Developers (Success)

![CICD](https://user-images.githubusercontent.com/29623199/119261067-f81cd780-bbd5-11eb-8cee-37b45fdcc944.JPG)

### Advantages of Continuous Integration

* Every Commit made in the Source Code is built and tested
* Developers know the Test Result of every Commit made in the Source Code on the Run
* Feedback from the Build Server is present

### Pipeline

* Pipeline is a Workflow which contains the Group of Events or Jobs that are chained and integrated with each other in a Sequence
* A Pipeline is the Process of Continuous Delivery Automation (using Jenkins some Jobs)
* Each Job contains some processing Inlet and Outlet
* The Continuous Delivery Pipeline chained the Jobs Build, Deploy, Test and Release

![Pipeline Architecture](https://user-images.githubusercontent.com/29623199/119261060-ec311580-bbd5-11eb-9441-4726f769e0ef.JPG)

#### Build Plugin Pipeline

* Build Plugin Pipeline is used if the Application have less Jobs to execute
* If the Application have multiple Jobs like Development, Code Review, Unit Test, Integration Test, Packaging, Build then should be a Declarative or else Scripted Pipelin been used

### Run Jenkin

* docker run --rm -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts
* Jenkins is run on localhost:8080
* Unlock Jenkins with the initial Password (from Console)
* Choose "Install suggested Plugins"
* Create a new Job
* Choose Freestyle Project
* Choose GitHub Project and provide the GitHub URL
* Source Code Management choose Git and provide the Git Repository URL (under Clone Code in GitHub and ends with .git)
* Add Credentials under Source Code Management
* Choose Poll Source Code Management(GitHub) as Schedule "* * * * *" (This Wildcard means that every Time the GitHub is checkout for Changes)
* Choose in Build Enviroment "Invoke top-level Maven Targets" in a SpringBoot Project and set as Goals "install"
* Optional: Choose in Post-buildActions the E-Mail Notification
* Finally click apply