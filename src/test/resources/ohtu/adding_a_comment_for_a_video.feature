Feature: user can add a comment for a video
	
	Scenario: user can add a comment for a video
		Given a video with a name "What is Agile?" and author "Mark Shead" and url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is added
		And the page of the new video with the name "What is Agile?" is entered
		When a comment with text "a very unique comment" is added
		Then the new comment with text "a very unique comment" is shown
		
	Scenario: user can add two comments for a blog
		Given a video with a name "What is Agile?" and author "Mark Shead" and url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is added
		And the page of the new video with the name "What is Agile?" is entered
		When a comment with text "a very unique comment" is added
		And a comment with text "an another very unique comment" is added
		Then the new comment with text "a very unique comment" is shown
		And the new comment with text "a very unique comment" is shown
		
	Scenario: an empty comment can't be added for a blog
		Given a video with a name "What is Agile?" and author "Mark Shead" and url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is added
		And the page of the new video with the name "What is Agile?" is entered
		When an empty comment is added
		Then an error message "Et voi kommentoida tyhjää kommenttia" will be shown