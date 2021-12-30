# SDET_test
# REQUREMENTS : 
The application is prepared to be run using docker-compose. So having docker and docker-compose configured is mandatory.

https://docs.docker.com/compose/install/

The application is run on Eclipse that supports TestNG.

Java 1.7+ is required for running the TestNG for Eclipse plugin. Eclipse 4.2 and above is required. Eclipse 3. x is NOT supported any more, please update your Eclipse to 4.2 or above.

Link to dounload Eclipse https://www.eclipse.org/downloads/

After downloading eclipse tar file follow the below commands on your terminal :

    $ tar zxf eclipse-inst-jre-linux64.tar.
    $ cd eclipse-install
    $ ./eclipse-inst

After the all extraction **Install and Launch** the application.

On the pop-up select the default workspace or create your own.

# APPLICATION START

* * *

After having docker configured, there is only a command needed to start the application.

       $ docker-compose up
       
Then the application should be available at http://localhost:8088 (a Spring whitelabel error is expected)

* * *

# ECLIPSE CONFIGURATION

Click the **HELP** icon and proceed to **Eclipse Marketplace...**

![image](https://user-images.githubusercontent.com/49020846/147745427-209dfeec-75db-4b0f-82d1-b0693011f75a.png)


On the **Eclipse Marketplace** pop-up navitagate to the search fild and type TestNG and proceed to search.

Proceed to install TestNG for Eclipse.

![image](https://user-images.githubusercontent.com/49020846/147746227-af414d31-a4c1-45d4-a878-90ec0282816d.png)


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




