@runAll
Feature: Finding And Comparing Movie In Menu And Search Function

  @Case1
  Scenario: Find The Circus Movie by using menu and by using search button and compare if both of them are the same
    Given the user is on the main page
    When click on Menu
    And click on "Oscars" in Menu
    And click on "1929" in Events History
    And click on "The Circus" in page
    And save "The Circus" information
    When click on Home Page
    And search "The Circus" movie
    And click on "The Circus" in search
    Then compare "The Circus" director, writer and stars
    When click on See all photos
    Then check links are not broken "The Circus"

  @Case2
  Scenario: Find The Jazz Singer Movie by using menu and by using search button and compare if both of them are the same
    Given the user is on the main page
    When click on Menu
    And click on "Oscars" in Menu
    And click on "1929" in Events History
    And click on "The Jazz Singer" in page
    And save "The Jazz Singer" information
    When click on Home Page
    And search "The Jazz Singer" movie
    And click on "The Jazz Singer" in search
    Then compare "The Jazz Singer" director, writer and stars
    When click on See all photos
    Then check links are not broken "The Jazz Singer"

  @Case3
  Scenario Outline: Find Movies by using menu and by using search button and compare if both of them are the same
            and photos links are not broken
    Given the user is on the main page
    When click on Menu
    And click on "<menu>" in Menu
    And click on "<year>" in Events History
    And click on "<movie>" in page
    And save "<movie>" information
    When click on Home Page
    And search "<movie>" movie
    And click on "<movie>" in search
    Then compare "<movie>" director, writer and stars
    When click on See all photos
    Then check links are not broken "<movie>"

    Examples:
      | menu   | year | movie           |
      | Oscars | 1929 | The Circus      |
      | Oscars | 1929 | The Jazz Singer |









