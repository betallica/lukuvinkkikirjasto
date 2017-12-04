Feature: user can filter the hints by tags

	Scenario: user can filter hints by one tag
		Given a tag "programmingpractises" is added
		And a new book with name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" and the newest tag is added
		And a new book with a name "Testing Computer Software" and author "Cem Kaner" and isbn "978-0-471-35846-6" is added
		When the hints are filtered by the newest tag
		Then a book with the name "Clean Code" is shown
		And a book with the name "Testing Computer Software" is not shown
	
	