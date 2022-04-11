#### SpringMVCFilmCRUD

#### Description
The goal for this project was to create a web application that allowed the user to search for a film from a database. The user was presented a home page directory that would allow them to choose from five options to access the film data or modify it. The first option provided to the user is search film by ID, this allows the the user to enter a film ID to pull up the associated film. If no film was found by the ID, then the user was presented a message to notify them that there was no film found. Otherwise if the application found that film, the user was presented all the details for the film, and given an option to update the film from there. The second option allowed the user to search for a film by entering a keyword that would search through the database and match that keyword to either the film title or the description. If the keyword returned no results then the user was notified with the correct message, otherwise the user was presented a full list of every match to the keyword. Each item in the list was hyperlinked allowing the user to select the film they wished to see the full details for, and again presented the option to update the film. The third option allowed the user to add a film to the data base by filling out a form to enter the values for each column in the database. The user was presented with text boxes to fill in the correct string values, a radio button to select the film's language, and a checkbox to add any special features the film may have. Once the user filled out the form, they could submit the film to the data base, and can go back to the search film options to find the film they added. The fourth option allowed the user to delete a film from the database by entering the film ID that they wanted to remove. However, the user can only delete a film that they added to the database, this is because the first 1000 films in the database are tied to a child table that won't allow the user to delete from. The last option presented is update film, this allows the user to search the film they want to update by its ID. Once that film is found the user is presented a form that is already filled out with the current values of the film, from there they can modify any of the values they want and update that film.


#### Technologies Used
- Object Oriented Programming
- Interfaces
- Databases
- JDBC
- MySQL
- MySQL queries
- Prepared Statements
- Gradle
- HTML/CSS
- Git


#### Lessons Learned
Collaborating as a group for the first time presented challenges when it came to pushing and pulling our work to git. Since this was our first group project we came to better understand the importance of pushing our work often, providing well detailed commits for our partners to understand, and pulling from the repository before pushing to make sure everything was up to date.
