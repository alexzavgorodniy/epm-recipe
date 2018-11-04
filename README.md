# HOMEWORK 20
_____


### Description
In this homework, I created a new implementation for recipe-persistence: It based on the DB - **H2**-in-memory.
After the application context has been raised, the table is built and initialized with initial values (*DbManager* runs the SQL scripts placed in *resources/sql* in turn).

To implement the DAO pattern, another interface was created *EntityDao<T>*, which implements in the *RecipeDao* class. Here methods work using *JdbcTemplate* and *DataSource*.

To implement the service layer, I made another generic interface *EntityService<T>* with the implementation in *RecipeServiceImpl*.

To work through the browser, use the class *MyRecipeController* and a few more for auxiliary purposes. Start page mapping: **http://localhost/index**.

To implement the work via the restful API, *MyRestRecipeController* is made with all the necessary HTTP-methods. Request mapping starts at **http://localhost/rest/**.
Link to **Postman Collection**:
https://www.getpostman.com/collections/d7c6e225e2b78c20ed78