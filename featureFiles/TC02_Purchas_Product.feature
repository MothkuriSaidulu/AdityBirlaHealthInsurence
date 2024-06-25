Feature: ABHI Purches Policy.

  Scenario: ABHI Purchas product.
    Given user launched the brower and entered url.
    When agent enterd userid As "<username>" password as this "<password>".
    And agent click on login button.
    Then verify agent landed on dashboard.
    And click on plus button and get quote.
    And select standalone product type.
    
    

