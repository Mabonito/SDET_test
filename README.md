# SDET_test

* * *
# Context 

Our application is a payment gateway which allows merchants to charge their users with a single integration.

Right now we are able to charge users, and we want to add the refund feature.

Following User Story describes the expected behavior and what needs to be tested.

* * *

# User Story

As a Merchant

In order to revert a previous transaction

I need to be able to refund a charge operation by its id.

## Acceptance criteria

   - API should expose the following endpoint POST /operations/{id}/refund
   - The "id" should be a valid uuid v4 (ex. d1e90d8f-11f7-41e0-92ff-235e2a85ab3b) to get 201 OK
   - With an invalid uuid you should get a 400
   - Only one concurrent refund operation (on the same transaction id) can be performed, so the resource should be blocked if another refund is being processed. Failing concurrencies should get a 423





* * *
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

### Both the server and Eclipse application have to run simultaneously/parallel.

**Docker compose has to be running before the tests are ran.**

After having docker configured, there is only a command needed to start the application.

       $ docker-compose up
       
Then the application should be available at http://localhost:8088 (a Spring whitelabel error is expected)

* * *

# ECLIPSE CONFIGURATION

Click the **HELP** icon and **Eclipse Marketplace...** will pop-up

* * *

![image](https://user-images.githubusercontent.com/49020846/147745427-209dfeec-75db-4b0f-82d1-b0693011f75a.png)

* * *

On the **Eclipse Marketplace** pop-up navitagate to the search field and type TestNG then proceed to search.

Install TestNG for Eclipse.

* * *

![image](https://user-images.githubusercontent.com/49020846/147746227-af414d31-a4c1-45d4-a878-90ec0282816d.png)

* * *

Right click the Project then click **Bild Path** >> **Configure Build Path...**

On the following pop-up click **Java Build Path**

Then click **Libraries**

Then click **Add Libraries**

* * *

![image](https://user-images.githubusercontent.com/49020846/147746654-25d59c06-d0cc-46a1-9319-7fd9b403746c.png)

* * *

On the following pop-up click the Library **TestNG**


Then click **Next**


Then on the above pop-up click **Apply and Close**

* * *

![image](https://user-images.githubusercontent.com/49020846/147746758-e73c29d9-53e4-4c0a-969c-4474c3f90776.png)

* * *

A warning Message during the installation phase will pop-up click install anyways.

A pop-up to restart Eclipse IDE so that the installations can take effect proceed to restart.


# RUNNING REST-ASSURED API TEST

* * *

Upon the relunch of Eclipse IDE, **TestNG** will be amongst the Libraries of the project.

As per below Screenshot open the folder **src/test/java**.

Then open **serviceRequest** pakage under.

Click **postData.java** file to open the file.

* * *
![image](https://user-images.githubusercontent.com/49020846/147748753-8393d2b4-0948-4186-80bf-dad091dd8a8c.png)
* * *


On the **postData.java** file right click on the code.

Then click **Run As**.

Then click **1 TestNG Test**. 

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










