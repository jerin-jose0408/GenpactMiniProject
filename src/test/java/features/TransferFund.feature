Feature: Transfer Fund

Scenario Outline: User should be able to transfer fund
Given User launches "https://parabank.parasoft.com/parabank/index.htm" portal with "john" and "demo"
When User transfers fund of <value> from <from> to <to> 
Then Verify transfer is successful

Examples:
|value	|from		|to		|
|100	|0			|1		|
