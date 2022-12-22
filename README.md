# JapanEarthquakes
This is a fun project that I've been working on recently to practice and because I enjoy looking at earthquake data in Japan. Plus, I live in Japan and I'm interested in this for safety. :)

I am accessing earthquake data from Japan's Meteorological Agency; there is no API for this so I am getting the JSON data directly from the site. One thing that I am proud of is that this is the first time that I've reused code - my APIConnector class is used in another project. It's nice to use that and also learn why writing code that can be used in any project is important.

## Areas I am happy with:
- My APIConnector class. I would like to learn how to centralize utility classes so that way when I make changes to it every project that uses it will inherit those changes, too.

- Dealing with raw JSON data is new to me and I'm happy that I've been able to make it this far.

- I've implemented tests to learn more about that. It's been nice making tests for methods instead of having to add "test" methods in my Main class. Not sure if this is correct but it feels like a reliable process.

- First real use of a HashMap. I usually stick to ArrayLists because I'm familiar with them but I wanted to use one here and I think my implementation is a good use case for one.

## Future goals:

- Create a user interface.

- Convert the String dates to actual Date objects so date ranges can be searched for.

- Possibly publish this as my very first app.

- One of my original goals is to have the program e-mail me when a new earthquake is detected. Not as a safety service but just because I think that would be fun to do, especially because I live in Japan!

- Insert the data into a database for historical purposes.
