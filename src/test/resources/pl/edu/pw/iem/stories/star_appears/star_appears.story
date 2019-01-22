Narrative: A Game of Life structues appear

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