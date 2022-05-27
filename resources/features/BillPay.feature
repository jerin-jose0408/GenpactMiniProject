Feature: Bill Pay

Scenario: User pays the bill with different data
Given User launches portal with "john" and "demo"
When user enters following bill pay details
|John Snow	|8239 greenhollow ln	|Dallas	|Texas	|75240	|9481776013	|1001	|1001	|	100|
Then bill pay should be successful