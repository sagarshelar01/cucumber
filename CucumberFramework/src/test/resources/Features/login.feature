@loginpage

Feature: login functionity

Scenario: verify_title_TC01
Given user should be login page
And user can verify Title

Scenario: Verify_logo_TC02
Given user should be login page
And user can verify Logo

Scenario: Verify_KeyModule_Text_TC03
Given user should be login page
And user can verify KeyModule Text

Scenario Outline: Verify_all_login_page_texts_TC04
Given user should be login page
And user can verify the existing text "<Text>"
Examples: 
|Text|
|Key Modules|
|vtiger CRM Add-ons|
|:: Sales Force Automation|
|:: vtiger Customer Portal|

@test5
Scenario: verify_selected_theme_TC05
Given user should be login page
And user can verify size of dropdown list
And user can verify Expected and Actual list in dropdown
And User can verify dropdown list are sorted
And User can verify default selected item





@test1
Scenario: Valid Login
Given user should be login page
When user enters valid credentials
And click on login button
Then should navigated to home page
And user can click on logout link

@test2
Scenario Outline: InValid Login
Given user should be login page
When user enters Invalid userid as "<userid>" and password as "<password>"
And click on login button
And user can validate error message on login page
Examples: 
|userid |password |
|admin1 |pwd1 |
|admin2 |pwd2 |
|admin3 |pwd3 |
