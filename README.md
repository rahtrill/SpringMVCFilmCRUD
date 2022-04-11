#### Spring MVC Film CRUD

### Description
The goal for this project was to create a web application that allowed the user to search for a film from a database. The user was presented a home page directory that would allow them to choose from five options to access the film data or modify it, and a sixth option to access or modify actor data.

The first option provided to the user is search film by ID, this allows the the user to enter a film ID to pull up the associated film. If no film was found by the ID, then the user was presented a message to notify them that there was no film found. Otherwise, if the application found that film, the user was presented all the details for the film, and given an option to update the film from there.

The second option allowed the user to search for a film by entering a keyword that would search through the database and match that keyword to either the film title or the description. If the keyword returned no results then the user was notified with the correct message. Otherwise, the user was presented a full list of every match to the keyword. Each item in the list was hyperlinked, this allows the user to select the film they wished to see the full details for, and again are presented the option to update the film.

The third option allowed the user to add a film to the database by filling out a form to enter the values for each column in the database. The user was presented with text boxes to fill in the correct string values, a radio button to select the film's language, and a checkbox to add any special features the film may have. Once the user filled out the form, they could submit the film to the data base, and can go back to the search film options to find the film they added.

The fourth option allowed the user to delete a film from the database by entering the film ID that they wanted to remove. However, the user can only delete a film that they added to the database, this is because the first 1000 films in the database are tied to a child table that won't allow the user to delete from.

The fifth option presented is update film, this allows the user to search the film they want to update by its ID. Once that film is found the user is presented a form that is already filled out with the current values of the film, from there they can modify any of the values they want and update that film.

The final option opens another menu that allows the user to access or modify data for the actors in the database. Those menu options reflect some of the options given for the film database. Such as, adding an actor, finding an actor by ID, removing an actor, and updating an actor.

There are some additional options in the result pages after the database displays film information. The user can add an actor to that film, update the film, or remove the film all on that page. Removing the film will not be accessible for the user if the film ID is less than 1000, due to issues with child data pertaining to the film data.


### Technologies Used

The following technologies were required to make this program function properly:

- Object Oriented Programming (Java)
- Interfaces
- Databases
- JDBC
- MySQL queries
- MySQL transactions
- DriverManager
- Prepared Statements
- Gradle
- HTML/CSS
- JSP
- Git
- Spring Servlets
- Spring Controller
- Spring Mapping
- MAMP
- Atom
- ZSH Shell
- SpringToolSuite4
- Tomcat v8.5 local server
- Slack for organization


### Lessons Learned

Collaborating as a group presented challenges when it came to pushing and pulling our work to git. Since this was our first group project we came to better understand the importance of pushing our work often, providing well detailed commits for our partners to understand, and pulling from the repository before pushing to make sure everything was up to date. Merge conflicts also became an issue when working on a class that a member had already altered without pulling from the repository before pushing the work. However, this was an easy fix once we communicated through slack to pull the current changes before proceeding to the next user story.

This was also our first project where we implemented a full stack program. Tying in every element at times could be difficult, however working as a team and debugging our project together was a major factor in this project. Each member contributed to a major role when implementing the front end and back end of the code, breaking user stories into several tasks and executing them as a collective.


### Meet The Team

**Rahil Ali**
- Student at Skill Distillery
- LinkedIn - https://www.linkedin.com/in/rahil-ali-35b480224
- GitHub - https://github.com/rahtrill

**Zack Gaddy**
- Student at Skill Distillery
- LinkedIn - TBD
- GitHub - https://github.com/ZackTheAwkward

**Daniel Kregstein**
- Student at Skill Distillery
- LinkedIn - TBD
- GitHub - https://github.com/Akregstein
