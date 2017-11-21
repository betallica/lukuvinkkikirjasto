Feature: user can add books

        Scenario: user can add a book
                Given command add book is selected
                When valid name "Clean Code" and valid author "Robert C. Martin" and valid isbn "978-0132350884" are entered
                Then user is redirected to front page
                And  a new book is listed with the isbn "978-0132350884"

        Scenario: adding book fails with empty name
                Given command add book is selected
                When  empty name "" and valid author "Robert C. Martin" and valid isbn "978-0132350884" are entered
                Then  error message "Name can not be empty" is shown

        Scenario: adding book fails with empty author
                Given command add book is selected
                When  valid name "Clean Code" and empty author "" and valid isbn "978-0132350884" are entered
                Then  error message "Author can not be empty" is shown

        Scenario: adding book fails with invalid isbn
                Given command add book is selected
                When  valid name "Clean Code" and empty author "Robert C. Martin" and invalid isbn "12345" are entered
                Then  error message "Not a valid isbn" is shown