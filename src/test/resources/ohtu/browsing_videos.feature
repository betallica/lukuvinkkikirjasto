Feature: User can browse videos in home page

        Scenario: User can see one added video
                Given a video with a name "What is Agile" and author "Mark Shead" and url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is added
                When at the home page
                Then a new video is listed with the name "What is Agile?"

        Scenario: User can see two added videos
                Given a video with a name "What is Agile" and author "Mark Shead" and url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is added
                And a video with a name "Intro to Scrum in Under 10 Minutes" and author "Axosoft" and url "https://www.youtube.com/watch?v=XU0llRltyFM" is added
                When at the home page
                Then a new video is listed with the name "What is Agile?"
                And a new video is listed with the name "Intro to Scrum in Under 10 Minutes"
                
        Scenario: User can change between pages of videos
        	Given ten videos are created with same name "What is Agile?" same author "Mark Shead" and same isbn "https://www.youtube.com/watch?v=Z9QbYZh1YXY"
        	And a video with a name "Intro to Scrum in Under 10 Minutes" and author "Axosoft" and url "https://www.youtube.com/watch?v=XU0llRltyFM" is added
        	When next page is selected
        	Then a new video is listed with the name "Intro to Scrum in Under 10 Minutes"