Feature: ABHI New Bussiness Functionality.

  Scenario: verify Standalone Active health product for new bussiness type and active health platinum type Enhanced.
    Given user launched the brower and entered url.
    When agent enterd userid As "5100003" password as this "Test@1234".
    And agent click on login button.
    Then verify agent landed on dashboard.
    And click on plus button and get quote.
    And select standalone product type.
    Then verify agent landed on Insured Members page.
    And choose active health platinum type as "ESSENTIAL".
    And select policy type as "Portability".
    And enter proposer details.
 #   And enter member details.
 # Addnewly
 #new