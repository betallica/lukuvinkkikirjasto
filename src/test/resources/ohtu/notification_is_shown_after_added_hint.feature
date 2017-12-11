Feature: User can see notification after adding a hint

  Scenario: User can see notification after adding a book
    Given command add book is selected
    When valid name "Clean Code" and valid author "Robert C. Martin" and valid isbn "978-0132350884" are entered
    Then notification "Kirjavinkki lisätty!" is shown

  Scenario: User can see notification after adding a blog
    Given command add blog is selected
    When valid name "A Simple Way to Run a Sprint Retrospective" and valid author "Mike Cohn" and valid url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" are entered
    Then notification "Blogivinkki lisätty!" is shown

  Scenario: User can see notification after adding a video
    Given command add video is selected
    When valid name "What is Agile?" and valid vidauthor "Mark Shead" and valid url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" are entered
    Then notification "Videovinkki lisätty!" is shown