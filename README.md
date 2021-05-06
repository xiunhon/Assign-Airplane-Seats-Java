# Airplane Seats Assignment
Write a program that assigns seats on an airplane.
Assume the airplane has 20 seats in first class (5 rows of 4 seats each, separated by an aisle) and 90 seats in economy class (15 rows of 6 seats each, separated by an aisle).
Your program should take three commands: add passengers, show seating, and quit.
When passengers are added,
ask for the class (first or economy),
the number of passengers traveling together (1 or 2 in first class; 1 to 3 in economy),
and the seating preference (aisle or window in first class; aisle, center, or window in economy).
Then try to find a match and assign the seats.
If no match exists, print a message.
Print an error message if the user enters an incorrect value.
Allow the user to re-enter a value if an incorrect value was entered.
Your solution should include a class Airplane that is not coupled with the Scanner or PrintStream classes.
Sample Output
A)dd  S)how  Q)uit
s
 1:. . . .
 2:. . . .
 3:. . . .
 4:. . . .
 5:. . . .
 6:... ...
 7:... ...
 8:... ...
 9:... ...
10:... ...
11:... ...
12:... ...
13:... ...
14:... ...
15:... ...
16:... ...
17:... ...
18:... ...
19:... ...
20:... ...
A)dd  S)how  Q)uit
a
F)irst  E)conomy
f
Passengers? (1-2)
1
A)isle  W)indow
a

A)dd  S)how  Q)uit
a
F)irst  E)conomy
f
Passengers? (1-2)
2

A)dd  S)how  Q)uit
a
F)irst  E)conomy
e
Passengers? (1-3)
1
A)isle  C)enter  W)indow
a
A)dd  S)how  Q)uit
a
F)irst  E)conomy
e
Passengers? (1-3)
2
A)isle  C)enter  W)indow
c
A)dd  S)how  Q)uit
a
F)irst  E)conomy
e
Passengers? (1-3)
3
A)dd  S)how  Q)uit
s
 1:. * * *
 2:. . . .
 3:. . . .
 4:. . . .
 5:. . . .
 6:*** ***
 7:... ...
 8:... ...
 9:... ...
10:... ...
11:... ...
12:... ...
13:... ...
14:... ...
15:... ...
16:... ...
17:... ...
18:... ...
19:... ...
20:... ...
A)dd  S)how  Q)uit
q
Press any key to continue . . .
