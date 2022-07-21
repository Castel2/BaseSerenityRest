Feature: Validate that the JSONPlaceHolder API returns the registered users

  Scenario Outline: Search users by id in the JSONPlaceHolder API
    When the channel request the user with id <id>
    Then the user information should contains the user with name <name> email <email> and city <city>

    Examples:
      | id | name             | email                  | city          |
      | 3  | Clementine Bauch | Nathan@yesenia.net     | McKenziehaven |
      | 7  | Kurtis Weissnat  | Telly.Hoeger@billy.biz | Howemouth     |