Feature: User can browse videos in home page

        Scenario: User can see one added blog
                Given a blog with a name "A Simple Way to Run a Sprint Retrospective" and author "Mike Cohn" and url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" is added
                When at the home page
                Then a new blog is listed with the name "A Simple Way to Run a Sprint Retrospective"

        Scenario: User can see two added blogs
                Given a blog with a name "A Simple Way to Run a Sprint Retrospective" and author "Mike Cohn" and url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" is added
                And a blog with a name "Vincit blog" and author "Vincit" and url "www.vincit.com/blog" is added
                When at the home page
                Then a new blog is listed with the name "A Simple Way to Run a Sprint Retrospective"
                And a new blog is listed with the name "Vincit blog"
                
        Scenario: User can change between pages of blogs
        	Given ten blogs are created with same name "Vincit blog" same author "Vincit" and same url "www.vincit.com/blog"
        	And a blog with a name "A Simple Way to Run a Sprint Retrospective" and author "Mike Cohn" and url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" is added
        	When next page is selected
        	Then a new blog is listed with the name "A Simple Way to Run a Sprint Retrospective"