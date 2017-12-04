Feature: User can filter hints by read status

        Scenario: User can see unread hints 
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                And a book with a name "Design for Service" and author "Daniela Sangiorgi" and isbn "978-1474250153" is added
                When the book with name "Clean Code" is marked as read
                And hints are filtered by being unread
                Then the book with the name "Design for Service" is visible
        Scenario: User can see read hints
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                And a book with a name "Design for Service" and author "Daniela Sangiorgi" and isbn "978-1474250153" is added
                When the book with name "Clean Code" is marked as read
                And hints are filtered by being read
                Then the book with the name "Clean code" is visible
        Scenario: User can see all hints
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                And a a book with a name "Design for Service" and author "Daniela Sangiorgi" and isbn "978-1474250153" is added
                When the book with name "Clean Code" is marked as read
                And hints are filtered by all
                Then the book with the name "Clean code" is visible
                And the book with the name "Design for Service" is visible