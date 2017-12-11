Feature: user can edit blogs

        Scenario: user can edit a blog
                Given command edit blog is selected
                When valid name "A Simple Way to Run a Sprint Retrospective" and valid author "Mike Cohn" and valid url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" are entered
                Then user is redirected to blog page

        Scenario: editing blog fails with empty name
                Given command edit blog is selected
                When  empty name "" and valid author "Mike Cohn" and valid url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" are entered
                Then  error message "Name can not be empty" is shown

        Scenario: editing blog fails with empty author
                Given command edit blog is selected
                When  valid name "A Simple Way to Run a Sprint Retrospective" and empty author "" and valid url "https://www.mountaingoatsoftware.com/blog/a-simple-way-to-run-a-sprint-retrospective" are entered
                Then  error message "Author can not be empty" is shown

        Scenario: editing blog fails with empty url
                Given command edit blog is selected
                When  valid name "A Simple Way to Run a Sprint Retrospective" and valid author "Mike Cohn" and empty url "" are entered
                Then  error message "url can not be empty" is shown