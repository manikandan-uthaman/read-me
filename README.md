# Book Listing Application

This is a book listing application.

## Requirements
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Angular CLI](https://cli.angular.io/)
- [Node.js](https://nodejs.org/en/)
- [NPM](https://www.npmjs.com/)

## Docker
Also this application is dockerised. To run the application in docker, open the parent folder in command prompt and type the following command:

```shell
docker-compose up
```

and then hit [http://localhost](http://localhost) in your browser.

To stop the application, press `ctrl+c` and then type
```shell
docker-compose down
```

Instruction to run the front end and back end seperately can be found in the `README.md` files inside the corresponding folder.

## Note: 
- To run docker containers with on-disk db (mysql), add `sql` to spring profiles in `readme-api\config\application.properties`.
- To run docker containers with in-memory db (h2), add `h2` to spring profiles in `readme-api\config\application.properties` and remove `readme-db` section from `docker-compose.yml` file.
- Both `sql` and `h2` profiles should not be enabled at the same time.