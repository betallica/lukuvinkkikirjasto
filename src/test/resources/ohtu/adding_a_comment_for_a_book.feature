Feature: user can add a comment for a book
	
	Scenario: user can add a comment for a book
		Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
		And the page of the new book with the name "Clean Code" is entered
		When a comment with text "a very unique comment" is added
		Then the new comment with text "a very unique comment" is shown
		
	Scenario: user can add two comments for a book
		Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
		And the page of the new book with the name "Clean Code" is entered
		When a comment with text "a very unique comment" is added
		And a comment with text "an another very unique comment" is added
		Then the new comment with text "a very unique comment" is shown
		And the new comment with text "a very unique comment" is shown
		
	Scenario: an empty comment can't be added for a book
		Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
		And the page of the new book with the name "Clean Code" is entered
		When an empty comment is added
		Then an error message "Et voi lisätä tyhjää kommenttia" will be shown