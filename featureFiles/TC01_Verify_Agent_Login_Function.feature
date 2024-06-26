Feature: ABHI Seller portal policy sale.

	@Login
  Scenario Outline: Verify Agent login functionality.
    Given user launched the brower and entered url.
    When agent enterd userid As "<username>" password as this "<password>".
    And agent click on login button.
    Then verify agent landed on dashboard.
    
    Examples:
			| username| password  |
    	| 5100003  | Test@1234 |
    	| 5200003  | Test@1236 |
    
    
    
