Feature: User can view a specific hint

        Scenario: User can view the information of an added book
            Given a book with a name "Clean Code" and author "Robert C. Martin" and isbn "978-0132350884" is added
            And user is at home page
            When book name is clicked
            Then page with book information is presented

        Scenario: User can view the information of an added blog
            Given blog with valid name "A Simple Way to Run a Sprint Retrospective" and valid author "Mike Cohn" and valid url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" is entered
            And user is at home page
            When blog name is clicked
            Then page with blog information is presented

        Scenario: User can view the information of an added video
            Given video with valid name "What is Agile?" and valid vidauthor "Mark Shead" and valid url "https://www.youtube.com/watch?v=Z9QbYZh1YXY" is entered
            And user is at home page
            When video name is clicked
            Then page with video information is presented