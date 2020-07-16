# APIAutomationTesting

## ASSIGNMENT: API for CRUD operations for employee Record 

### Q1) Define the Approach for Automation Testing of this Functionality and share the challenges anticipated.

Automation Testing Approach for API:
QA can develop Hybrid Automation Test Framework.

Hybrid Approach includes:
1. Rest Assured
1. TestNG and JUnit
1. Maven

Step by Step Development of Automation Hybrid Framework:
1. Development of Framework and Test Cases
1. Create Maven Project
1. Update pom.xml
1. Create Test cases
1. Execution of Test Cases
    - Execute using TestNG or JUnit
1. Maintenance of Test Cases
    - keep updating Test Suit according to CRs/Incidents


Challenges anticipated for Automation of API
1. Initial Setting up of API and Framework
1. Identifying Test Cases for CRUD 
1. Test Coverage for Input Data



### Q2) What is your approach to create an input Data set?

There are multiple ways to create a Test Data set like 
1. Test Data method (If data is limited)
1. By Excel (If Data is huge)

Currently I have developed a method called *getEmployeeData*
which holds a small Data Set. It has a local variable called *empData* which is a String 2D array. This dataset returns 2D data to another method called *PostEmployee*. 
*PostEmployee* method Post data to server.






### Q3) Optionally consider using an Excel for Input and Output of Data and Results.

As mentioned in Q2) Test Data method is implemented. Not Excel. Due to limited data.


### Q4) Create a Maven Project which will have the tests. 

Created a Maven Project named APIAutomationProject.
  
Created 5 Classes named: 
1.   GET_EMPLOYEE
1.   POST_EMPLOYEE
1.   PUT_EMPLOYEE
1.   DELETE_EMPLOYEE
1.   GET_EMPLOYEE1

### Q5) The System under Test must support 10K concurrent requests. How will you validate this need? 

We can distribute the 10K requests according to the capacity of each machine configuration (CPU, RAM, etc). So we will figure out the number of concurrent requests that a single machine can generate then decide how many machines will be required.

We can use JMeter for non-functional testing.

Assuming a single machine can generate 1K concurrent API calls. We will require 10 machines.

Steps to test 10K concurrent API:
1. Install JMeter on all identified 10 machines
1. Create 1K concurrent Thread per machine. 
1. Total 10K concurrent requests will be created.
1. Create 1 listener per machine to validate the performance
1. Monitor the performance.
