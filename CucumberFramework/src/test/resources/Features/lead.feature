@leadFunctionality


Feature: lead functionity



@test3
Scenario: create lead with mandatory fields TC01
Given user should be login page
When user enters valid credentials
And click on login button
When user click on new leads
And fill all mandatory field and click on save button
Then lead should be created sucesstully

@test3
Scenario: create lead with mandatory fields TC02
Given user should be login page
When user enters valid credentials
And click on login button
When user click on new leads
And fill all mandatory fielda and click on save button
Then lead should be created sucesstully



@test4
Scenario: create lead with mandatory fields with step parameterization
Given user should be login page
When user enters valid credentials
And click on login button
When user creates multiple leads with "<lastname>" and "<company>" verified
|lastname| company|
|shree | Wipro|
|divya | KPIT|
|sonu | tudip|
And click on logout button


@test6
Scenario: Alert should be populated lastname field are missing 
Given user should be login page
When user enters valid credentials
And click on login button
When user click on new leads
And click on save button
Then Alert should be populated for Lastname field 
And user fill the lastname field 
And click on save button
Then Alert should be populated for company field 
And user fill the company field
And click on save button

@test7
Scenario: Delete Record
Given user should click on leads menu
When user enters lastname and company field
And user serch the record
Then user select the id and click the checkbox
And user should delete the record.








