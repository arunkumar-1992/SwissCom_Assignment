#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: Search Functionality.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Search
Feature: Search Functionality
  I want to use this template for my feature file

  @EndToEnd
  Scenario: search for iphone and internet in Swisscom homepage and verifies them
    Given User Navigates to Swisscom Homepage
    When User Searches for "iPhone"
    Then Verify search returned "iPhone" result
    When user navigates Swisscom homepage in another tab
    And User Selects "Apple iPhone 13"
    Then Verify different storage options avaialble for different colors
    When User Searches for "Internet"
    Then Verify search returned "Internet" result
