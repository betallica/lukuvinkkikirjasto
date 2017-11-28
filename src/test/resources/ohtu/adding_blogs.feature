Feature: user can add blogs

        Scenario: user can add a blog
                Given command add blog is selected
                When valid name "A Simple Way to Run a Sprint Retrospective" and valid author "Mike Cohn" and valid url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" are entered
                Then user is redirected to front page

        Scenario: adding blog fails with empty name
                Given command add blog is selected
                When  empty name "" and valid author "Mike Cohn" and valid url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" are entered
                Then  error message "Name can not be empty" is shown

        Scenario: adding blog fails with empty author
                Given command add book is selected
                When  valid name "A Simple Way to Run a Sprint Retrospective" and empty author "" and valid url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" are entered
                Then  error message "Author can not be empty" is shown

        Scenario: adding book fails with empty url
                Given command add book is selected
                When  valid name "A Simple Way to Run a Sprint Retrospective" and empty author "" and invalid url "12345" are entered
                Then  error message "Not a valid url" is shown