Feature: user edit add books

        Scenario: user can edit a book
                Given command edit book is selected
                When valid name "Clean Code" and valid author "Robert C. Martin" and valid isbn "978-0132350884" are entered
                Then user is redirected to book page

        Scenario: editing book fails with empty name
                Given command edit book is selected
                When  empty name "" and valid author "Robert C. Martin" and valid isbn "978-0132350884" are entered
                Then  error message "Name can not be empty" is shown

        Scenario: editing book fails with empty author
                Given command edit book is selected
                When  valid name "Clean Code" and empty author "" and valid isbn "978-0132350884" are entered
                Then  error message "Author can not be empty" is shown

        Scenario: editing book fails with invalid isbn
                Given command edit book is selected
                When  valid name "Clean Code" and empty author "Robert C. Martin" and invalid isbn "12345" are entered
                Then  error message "Not a valid isbn" is shown