Feature: User can filter hints by read status

        Scenario: User can see unread hints 
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                And a book with a name "Design for Service" and author "Daniela Sangiorgi" and isbn "978-1474250153" is added
                When the book with name "Clean Code" is marked as read
                And hints are filtered by being unread
                Then a book with the name "Design for Service" is shown
                And a book with the name "Clean Code" is not shown
        Scenario: User can see read hints
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                And a book with a name "Design for Service" and author "Daniela Sangiorgi" and isbn "978-1474250153" is added
                When the book with name "Clean Code" is marked as read
                And hints are filtered by being read
                Then a book with the name "Clean Code" is shown
                And a book with the name "Design for Service" is not shown
        Scenario: User can see all hints
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                And a book with a name "Design for Service" and author "Daniela Sangiorgi" and isbn "978-1474250153" is added
                When the book with name "Clean Code" is marked as read
                And hints are filtered by all
                Then a book with the name "Clean Code" is shown
                And a book with the name "Design for Service" is shown