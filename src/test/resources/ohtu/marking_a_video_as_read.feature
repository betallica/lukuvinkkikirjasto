Feature: User can mark video as read in individual video hint page        

        Scenario: User can mark video as read
               Given a video with a name "What is Agile?" and author "Mark Shead" and url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is added
		And the page of the new video with the name "What is Agile?" is entered
		When the mark as read button is clicked
		Then the button's text changes to mark as unread

        Scenario: User can mark video as unread
               Given a video with a name "What is Agile?" and author "Mark Shead" and url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is added
		And the page of the new video with the name "What is Agile?" is entered
                And the mark as read button is clicked
		When the mark as read button is clicked
		Then the button's text changes to mark as read