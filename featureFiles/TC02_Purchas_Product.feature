Feature: ABHI Active Health Product Functionality.

  @ENHANCED_New_Business
  Scenario: verify Standalone Active health product for ENHANCED_New_Business.
    Given user launched the brower and entered url.
    When agent enterd userid As "5100003" password as this "Test@1234".
    And agent click on login button.
    Then verify agent landed on dashboard.
    And click on plus button and get quote.
    And select standalone product type.
    Then verify agent landed on Insured Members page.
    And choose active health platinum type as "ENHANCED".
    And select policy type as "New Business".
   # And enter proposer details.
    And enter proposer details Select Policy Type as "FAMILY FLOATER" and Select Sum Insured for Family as "600000" and pincode as "508217".

  @ESSENTIAL_New_Business
  Scenario: verify Standalone Active health product for ENHANCED_New_Business.
    Given user launched the brower and entered url.
    When agent enterd userid As "5100003" password as this "Test@1234".
    And agent click on login button.
    Then verify agent landed on dashboard.
    And click on plus button and get quote.
    And select standalone product type.
    Then verify agent landed on Insured Members page.
    And choose active health platinum type as "ESSENTIAL".
    And select policy type as "New Business".
   # And enter proposer details.
    And enter proposer details Select Policy Type as "FAMILY FLOATER" and Select Sum Insured for Family as "1000000" and pincode as "508217".

  @PREMIER_New_Business
  Scenario: verify Standalone Active health product for ENHANCED_New_Business.
    Given user launched the brower and entered url.
    When agent enterd userid As "5100003" password as this "Test@1234".
    And agent click on login button.
    Then verify agent landed on dashboard.
    And click on plus button and get quote.
    And select standalone product type.
    Then verify agent landed on Insured Members page.
    And choose active health platinum type as "PREMIER".
    And select policy type as "New Business".
  #  And enter proposer details.
    And enter proposer details Select Policy Type as "FAMILY FLOATER" and Select Sum Insured for Family as "1000000" and pincode as "508217".
 #   And enter member details                                    
