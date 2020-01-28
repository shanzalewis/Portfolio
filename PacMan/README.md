605.201 Intro to Java Mini-Project 1:

Purpose:
The purpose of this project is to provide non-trivial practice in the use of Java programming constructs

Program Specification:
1. Create a new Java program which implements a simple PacMan-type text game which contains the
following functionality:
  
  A) At program startup, constructs and displays a 2-dimensional grid using standard array(s) (no
collection classes allowed) with the size dynamically specified by the user (X and Y sizes can
be different). Places the PacMan in the upper-left corner of the grid facing left All grid cells
should have the empty cell character of ‘.’ except for the start position of the PacMan which
will have the appropriate PacMan symbol (see below). Also 8% of your grid (rounded down if
necessary) should contain cookies randomly located on the grid except for the initial PacMan
position. The grid must be displayed after each command.
 
 B) Use these symbols for the grid:
    1. Cookie symbol – shows were cookies are in the grid ('O')
    2. Empty symbol – shows empty unvisited grid cells ('.') (dot)
    3. Visited symbol – shows grid cells where the PacMan has visited (' ') (space)
    4. PacMan symbol depends on the current PacMan facing direction.
      1. Left ‘>’
      2. Up ‘V’
      3. Right ‘<’
      4. Down ‘^’
  
 C) The following menu of commands must be provided and must be displayed when appropriate.
The command number is what the user should enter to execute the command. Just display the
command number and text (ex. 1: Menu), not the explanation of what the command does:
    1. Menu – Display the menu of commands.
    2. Turn Left – turns the PacMan left (counter-clockwise) but the PacMan stays in its current
location
      1. Current: up, new: left
      2. Current: right, new up
      3. Current: down, new right
      4. Current: left, new down
    3. Turn Right – turns the PacMan right (clockwise) but the PacMan stays in its current location
      1. Current: up, new: right
      2. Current: right, new down
      3. Current: down, new left
      4. Current: left, new up
    4. Move – Moves the PacMan one grid location in the facing direction if possible. Adds one
to the count of move commands if successful or not. If the move command is successful,
the previous location is replaced with Visited Symbol (see above). If the move command
results in the PacMan moving to a cell where a cookie is located, the cookie is “eaten” and
the number of cookies eaten is increased by one.
    5. Exit – exits the program displaying the game statistics of the number of total moves and the
average number of moves per cookie obtained.

2. The main processing cycle is the following:
  A) The grid must be displayed after each command showing the effects of the command.
  B) Optionally display the list of commands
  C) Display the grid
  D) Accept user input. Code will be provided for reading user input.
    1. If an invalid command number is entered, an appropriate error message should be displayed
and the menu of commands and grid gets redisplayed. An invalid command does not count
as a command in the statistics.
    2. Process the command and add one to the number of move commands entered if it is a move
command.
    3. If the user enters the Exit command, the program will display the number of commands and
the average number of commands per cookie.
  E) If the resulting move places the PacMan over a cookie, indicate the cookie was eaten and add
one to the number of cookies eaten for the program statistics.
