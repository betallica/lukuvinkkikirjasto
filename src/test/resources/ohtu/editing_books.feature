Feature: user edit add books

  Scenario: user can edit a book
    Given a book with a name "Cucumber" and author "Matt and Aslak" and isbn "9781111578350" is added
    And user is at the books "Cucumber" info page
    And command edit book is selected
    When valid name "The Cucumber Book" and valid author "Matt Wynne and Aslak Hellesoy" and valid isbn "978-1-93435-680-7" are entered
    Then user is redirected to books "The Cucumber Book" page

  Scenario: editing book fails with empty name
    Given a book with a name "Cucumber" and author "Matt and Aslak" and isbn "9781111578350" is added
    And user is at the books "Cucumber" info page
    And command edit book is selected
    When empty name "" and valid author "Matt Wynne and Aslak Hellesoy" and valid isbn "978-1-93435-680-7" are entered
    Then error message "Name can not be empty" is shown

  Scenario: editing book fails with empty author
    Given a book with a name "Cucumber" and author "Matt and Aslak" and isbn "9781111578350" is added
    And user is at the books "Cucumber" info page
    And command edit book is selected
    When valid name "The Cucumber Book" and empty author "" and valid isbn "978-1-93435-680-7" are entered
    Then error message "Author can not be empty" is shown

  Scenario: editing book fails with invalid isbn
    Given a book with a name "Cucumber" and author "Matt and Aslak" and isbn "9781111578350" is added
    And user is at the books "Cucumber" info page
    And command edit book is selected
    When valid name "The Cucumber Book" and empty author "Matt Wynne and Aslak Hellesoy" and invalid isbn "12345" are entered
    Then error message "Not a valid isbn" is shown
