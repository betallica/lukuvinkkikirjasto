Feature: user can add videos

        Scenario: user can add a video
                Given command add video is selected
                When valid name "What is Agile?" and valid vidauthor "Mark Shead" and valid url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" are entered
                Then user is redirected to front page

        Scenario: adding video fails with empty name
                Given command add video is selected
                When  empty name "" and valid vidauthor "Mark Shead" and valid url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" are entered
                Then  error message "Name can not be empty" is shown

        Scenario: adding video fails with empty author
                Given command add video is selected
                When  valid name "What is Agile?" and empty vidauthor "" and valid url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" are entered
                Then  error message "Author can not be empty" is shown

        Scenario: adding video fails with empty url
                Given command add video is selected
                When  valid name "What is Agile?" and valid vidauthor "Mark Shead" and empty url "" are entered
                Then  error message "url can not be empty" is shown