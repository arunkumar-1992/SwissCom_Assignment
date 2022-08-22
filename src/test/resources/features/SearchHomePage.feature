@Search
Feature: Search Functionality
  I want to use this template for my feature file

  @EndToEnd @tc_1
  Scenario: search for iphone and internet in Swisscom homepage and verifies them
    Given User Navigates to Swisscom Homepage
    When User Searches for "iPhone"
    Then Verify search returned "iPhone" result
    When user navigates Swisscom homepage in another tab
    And User Selects "Apple iPhone 13 mini – Smartphones"
    Then Verify different storage options avaialble for different colors
    When User Searches for "Internet"
    Then Verify search returned "Internet" result
    
 
   
