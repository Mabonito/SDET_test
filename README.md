# SDET_test
# REQUREMENTS : 
The application is prepared to be run using docker-compose. So having docker and docker-compose configured is mandatory.

https://docs.docker.com/compose/install/

The application is run on Eclipse that supports TestNG.

Java 1.7+ is required for running the TestNG for Eclipse plugin. Eclipse 4.2 and above is required. Eclipse 3. x is NOT supported any more, please update your Eclipse to 4.2 or above.

Link to download Eclipse https://www.eclipse.org/downloads/

After downloading eclipse tar file follow the below commands on your terminal :

    $ tar zxf eclipse-inst-jre-linux64.tar.
    $ cd eclipse-install
    $ ./eclipse-inst

After all extraction **Install and Launch** the application.

On the pop-up select the default workspace or create your own.

# APPLICATION START

* * *

Both the server and Eclipse application have to run at simultaneously/parallel.

Docker compose has to be running before the tests are ran.

After having docker configured, there is only a command needed to start the application.

       $ docker-compose up
       
Then the application should be available at http://localhost:8088 (a Spring whitelabel error is expected)

* * *

# ECLIPSE CONFIGURATION

Click the **HELP** icon and proceed to **Eclipse Marketplace...**

* * *

![image](https://user-images.githubusercontent.com/49020846/147745427-209dfeec-75db-4b0f-82d1-b0693011f75a.png)

* * *

On the **Eclipse Marketplace** pop-up navitagate to the search fild and type TestNG and proceed to search.

Proceed to install TestNG for Eclipse.

* * *

![image](https://user-images.githubusercontent.com/49020846/147746227-af414d31-a4c1-45d4-a878-90ec0282816d.png)

* * *

Right click the and proceed to click **Bild Path** >> **Configure Build Path...**

On the following pop-up click **Java Build Path**

Then click **Libraries**

Then click **Add Libraries**

* * *

![image](https://user-images.githubusercontent.com/49020846/147746654-25d59c06-d0cc-46a1-9319-7fd9b403746c.png)

* * *

On the following pop-up proceed to click the Library **TestNG**


Then click **Next**


Then on the above pop-up proceed to click **Apply and Close**

* * *

![image](https://user-images.githubusercontent.com/49020846/147746758-e73c29d9-53e4-4c0a-969c-4474c3f90776.png)

* * *

A warning will pop-up during the installation phase proceed to install anyways.

A pop-up to restart Eclipse IDE so that the installations can take effect proceed to restart.


# RUNNING REST-ASSURED API TEST

* * *

Upon the relunch of Eclipse IDE, **TestNG** will be amongst the Libraries of the project.

As per below Screenshot open the folder **src/test/java**.

Open the **serviceRequest** pakage under.

Then proceed to double click **postData.java** file to open the file.

* * *
![image](https://user-images.githubusercontent.com/49020846/147748753-8393d2b4-0948-4186-80bf-dad091dd8a8c.png)
* * *


On the **postData.java** file proceed to right click on the code.

Then proceed to click **Run As**.

Then proceed to click **1 TestNG Test**. 

The test will run for a few seconds and show resulsts on the console.


# TEST REPORT

To see the report of the test cases with details on what was the input that was sent to the server : 

1. Right click the the project and refresh the project.

2. Proceed to click **test-output** folder.

3. Then double click **emailable-report.html**.

* * *
![image](https://user-images.githubusercontent.com/49020846/147749504-ba3ac089-6852-44d4-ab6a-3f2c9f7e319d.png)
* * *

A browser will open with the report of the of the test.

A report of this manner will show up on your browser.

* * *

![image](https://user-images.githubusercontent.com/49020846/147749809-2adf47f0-b171-4040-ad38-8a287a3d335f.png)

* * *










