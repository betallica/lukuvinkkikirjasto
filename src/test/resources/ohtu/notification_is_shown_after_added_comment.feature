Feature: User can see notification after adding a comment

  Scenario: User can see notification after commenting a book hint
    Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
    And the page of the new book with the name "Clean Code" is entered
    When a comment with text "a very unique comment" is added
    Then the new notification with text "Kommentti lisätty!" is shown

  Scenario: User can see notification after commenting a blog hint
    Given a blog with a name "Vincit blog" and author "Vincit" and url "www.vincit.com/blog" is added
    And the page of the new blog with the name "Vincit blog" is entered
    When a comment with text "a very unique comment" is added
    Then the new notification with text "Kommentti lisätty!" is shown

  Scenario: User can see notification after commenting a video hint
    Given a video with a name "What is Agile?" and author "Mark Shead" and url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is added
    And the page of the new video with the name "What is Agile?" is entered
    When a comment with text "a very unique comment" is added
    Then the new notification with text "Kommentti lisätty!" is shown