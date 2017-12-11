Feature: user can filter by keywords

  Scenario: User can filter by keyword in author field
    Given a new book with a name "Quality Code: Software Testing Principles, Practices, and Patterns" and author "Stephen Vance" and isbn "9780133017045" is added
    And a new book with a name "Succeeding with Agile: Software Development Using Scrum" and author "Mike Cohn" and isbn "9786612430565" is added
    And user is at home page
    When user enters "Cohn" to search field
    And user selects filter
    Then a book with the name "Quality Code: Software Testing Principles, Practices, and Patterns" is not shown
    And a book with the name "Succeeding with Agile: Software Development Using Scrum" is shown

  Scenario: User can filter by keyword in name field
    Given a new book with a name "Agile Project Management for Dummies" and author "Mark C Layton" and isbn "9781118235850" is added
    And a new book with a name "Scrum: The Art of Doing Twice the Work in Half the Time" and author "Jeff Sutherland" and isbn "9781847941091" is added
    And user is at home page
    When user enters "Dummies" to search field
    And user selects filter
    Then a book with the name "Agile Project Management for Dummies" is shown
    And a book with the name "Scrum: The Art of Doing Twice the Work in Half the Time" is not shown
