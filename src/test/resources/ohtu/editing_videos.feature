Feature: user edit add videos

  Scenario: user can edit a video
    Given video with valid name "What is Agility" and valid vidauthor "Mark" and valid url "https://www.youtube.com/watch?XYZ" is entered
    And the page of the new video with the name "What is Agility" is entered
    And command edit blog is selected
    When valid name "What is Agile?" and valid vidauthor "Mark Shead" and valid url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" are entered
    Then user is redirected to videos "What is Agile?" page

  Scenario: editing video fails with empty name
    Given video with valid name "What is Agility" and valid vidauthor "Mark" and valid url "https://www.youtube.com/watch?XYZ" is entered
    And the page of the new video with the name "What is Agility" is entered
    And command edit blog is selected
    When empty name "" and valid vidauthor "Mark Shead" and valid url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" are entered
    Then error message "Name can not be empty" is shown

  Scenario: editing video fails with empty author
    Given video with valid name "What is Agility" and valid vidauthor "Mark" and valid url "https://www.youtube.com/watch?XYZ" is entered
    And the page of the new video with the name "What is Agility" is entered
    And command edit blog is selected
    When valid name "What is Agile?" and empty vidauthor "" and valid url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" are entered
    Then error message "Author can not be empty" is shown

  Scenario: editing video fails with empty url
    Given video with valid name "What is Agility" and valid vidauthor "Mark" and valid url "https://www.youtube.com/watch?XYZ" is entered
    And the page of the new video with the name "What is Agility" is entered
    And command edit blog is selected
    When valid name "What is Agile?" and valid vidauthor "Mark Shead" and empty url "" are entered
    Then error message "url can not be empty" is shown
