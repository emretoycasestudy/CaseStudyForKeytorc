# CaseStudyForKeytorc
I use Java language to write my test code. While writing code i use Intellij IDE tool.  
I use Selenium web driver to interact with browsers. 
As a tester, I use maven to create my test automation framework, I manage my dependencies, run my tests, and generate reports. 
For reporting, I use Cucumber framework and Maven verify which creates JSON file that has fancy features and also a simple HTML file I use Junit assertion to verify actual result with expected result. 
In page folder I have abstract BasePage and inside it I use Page Factory class to create Page Object classes in order to put the common locators and methods in one place. Each of my Pages inherits from BasePage. 
In utilities package I have also utilities classes such as driver utility, configuration reader utility, BrowserUtils In features package I store my cucumber feature file, and I utilize it in step definition class. 
In Step-definition for different functions. class java method in a class with @hepsiburada annotation above it. It has also Hooks class in order to call methods before and after steps. I am also handling the taking screen shot and failed steps inside the Hooks class. 
I have configuration.properties file for keeping information and such as url, username and password As a design pattern for the Driver, I utilize Singleton object structure so that I can use the same driver object for my test case with the usage of encapsulation and polymorphism OOP Concepts.
Webdriver get method and each driver object created in polymorphic way by implementing the Webdriver interface. I have a runner class to run all tests from one location and it is kind of like bridge between feature files and step defs. 
For failed tests, my framework has failed test runner so that I can rerun failed test scenarios as well.
