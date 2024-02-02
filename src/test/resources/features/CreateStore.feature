@tag
Feature: Create Store Scenarios
  

 

  @tag2 
  Scenario Outline: Create Store using input values from examples
   Given store API is available
   And create request for the method using following values
   |name|address|city|state|zip|
   |<name>|<address>|<city>|<state>|<zip>|
   When I invoke stores api with post method
	Then the response code should be 201
	And verify the response details
    
   Examples:
   |name|address|city|state|zip|
   |BestBuy|Bramlea City Centre|Brampton|ON|LC3 X8R|
  
    
  