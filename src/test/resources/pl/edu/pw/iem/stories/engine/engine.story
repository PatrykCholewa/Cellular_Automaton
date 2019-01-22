Narrative: A Game of Life structures appear on the board

Scenario: a star structure appears a the board during Game of Life

Given a table of Void boundary and Moore neighbourhood and a board of 5 x 5

Given rules:
|rule|
|1/3/1/0|
|1/23/1/0|

Given a board:
|0|1|2|3|4|
|0|0|0|0|0|
|0|0|1|0|0|
|0|0|1|0|0|
|0|0|1|0|0|
|0|0|0|0|0|

When a next generation is simulated
Then a board should be:
|0|1|2|3|4|
|0|0|0|0|0|
|0|0|0|0|0|
|0|1|1|1|0|
|0|0|0|0|0|
|0|0|0|0|0|

When a next generation is simulated
Then a board should be:
|0|1|2|3|4|
|0|0|0|0|0|
|0|0|1|0|0|
|0|0|1|0|0|
|0|0|1|0|0|
|0|0|0|0|0|

Scenario: a glider structure appears a the board during Game of Life

Given a table of Planet boundary and Moore neighbourhood and a board of 5 x 5

Given rules:
|rule|
|1/3/1/0|
|1/23/1/0|

Given a board:
|0|1|2|3|4|
|0|0|0|0|0|
|0|0|1|0|0|
|0|0|0|1|0|
|0|1|1|1|0|
|0|0|0|0|0|

When a next generation is simulated
Then a board should be:
|0|1|2|3|4|
|0|0|0|0|0|
|0|0|0|0|0|
|0|1|0|1|0|
|0|0|1|1|0|
|0|0|1|0|0|

When a next 19 generations are simulated
Then a board should be:
|0|1|2|3|4|
|0|0|0|0|0|
|0|0|1|0|0|
|0|0|0|1|0|
|0|1|1|1|0|
|0|0|0|0|0|