# theScore_MobileAutomation_Junit
In this small project, certain functionalities of TheScore mobile application were automated using simple JUnit framework with Appium Server.

Appium server, Appium Inspector, and Android Emmulator are set up with desired capabilities and connected to the server and some elements are inspected using inspecter successfully.
A Maven project was build and all dependencies are centralized in pom.xml file. 
Under java packeage, a test TheScore test class is created and desired capabelities are used to set up AppiumDriver, and connected to the server through Appium.
All locaters are identified using xpath/id of the elements and used Appium inspector for inspection. 
According to the user story, test cases and steps, test scripts are written using Java.
Corresponding web titles or required fields are validated suign JUnit assertions according to the acceptance criteria. 
After successfully executing the test case, the AppiumDriver is closed, and the project is uploaded to GitHub repository for further reviews and integrations.
