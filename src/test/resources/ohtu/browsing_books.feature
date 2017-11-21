Feature: User can browse books in home page

        Scenario: User can see one added book
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                When at the home page
                Then a new book is listed with the isbn "978-0132350884"

        Scenario: User can see two added books
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                And a book with a name "Testing Computer Software" and author "Cem Kaner" and isbn "978-0-471-35846-6" is added
                When at the home page
                Then a new book is listed with the isbn "978-0132350884"
                And a new book is listed with the isbn "978-0-471-35846-6"