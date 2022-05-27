Feature: Update Contact Info

Scenario: Verify that user is able to change phone no
Given User launches portal with "john" and "demo"
When User changes contact no to "310-447-4123"
Then Verify contact details is updated
