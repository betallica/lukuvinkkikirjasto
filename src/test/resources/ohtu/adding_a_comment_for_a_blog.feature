Feature: user can add a comment for a blog
	
	Scenario: user can add a comment for a blog
		Given a blog with a name "Vincit blog" and author "Vincit" and url "www.vincit.com/blog" is added
		And the page of the new blog with the name "Vincit blog" is entered
		When a comment with text "a very unique comment" is added
		Then the new comment with text "a very unique comment" is shown
		
	Scenario: user can add two comments for a blog
		Given a blog with a name "Vincit blog" and author "Vincit" and url "www.vincit.com/blog" is added
		And the page of the new blog with the name "Vincit blog" is entered
		When a comment with text "a very unique comment" is added
		And a comment with text "an another very unique comment" is added
		Then the new comment with text "a very unique comment" is shown
		And the new comment with text "a very unique comment" is shown
		
	Scenario: an empty comment can't be added for a blog
		Given a blog with a name "Vincit blog" and author "Vincit" and url "www.vincit.com/blog" is added
		And the page of the new blog with the name "Vincit blog" is entered
		When an empty comment is added
		Then an error message "Et voi kommentoida tyhjää kommenttia" will be shown