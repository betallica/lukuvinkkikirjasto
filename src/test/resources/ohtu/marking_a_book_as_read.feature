Feature: User can mark book as read in individual book hint page

        Scenario: User can mark book as read
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
		And the page of the new book with the name "Clean Code" is entered
		When the mark as read button is clicked
                Then the button's text changes to mark as unread

        Scenario: User can mark book as unread
                Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
                And the book with name "Clean Code" is marked as read
                When the mark as unread button is clicked
                Then the button's text changes to mark as read
                