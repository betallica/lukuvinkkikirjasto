Feature: User can mark blog as read in individual blog hint page        

        Scenario: User can mark blog as read
                Given a blog with a name "Vincit blog" and author "Vincit" and url "www.vincit.com/blog" is added
		And the page of the new blog with the name "Vincit blog" is entered
		When the mark as read button is clicked
		Then the button's text changes to mark as unread

        Scenario: User can mark blog as unread
                Given a blog with a name "Vincit blog" and author "Vincit" and url "www.vincit.com/blog" is added
		And the page of the new blog with the name "Vincit blog" is entered
                And the mark as read button is clicked
		When the mark as read button is clicked
		Then the button's text changes to mark as read