# iManage Interview Application

This is my entry for the iManage technical challenge. There are two parts to this entry, the first and main part is located in the stack-api folder. This is a Gradle project using Spring Boot to run an API that creates and manages a stack written using the basic Java array. The second part is a very basic User Interface (UI) written using React JS. 

## API

The API can be started by running the following command in the stack-api folder:

```bash
./gradlew bootRun
```

There are a collection of tests that have also been written that can be run by using the command: 

```bash
./gradlew test
```

The API exposes three HTTP REST end-point:

- GET /stack - this retrieves the current state of the stack
- POST /stack/push/{value} - this will push the {value} onto the stack 
- GET /stack/pop - this will pop the last value in the stack off and return in the body of the response

All the HTTP end-point will return a copy of the stack in the body of the response in JSON format.

## UI

The UI can be started by running the following command in the stack-react folder:

```bash
npm start
```

This command will automatically open the page in you default browser. If the page fails to load then you can load it by going to : http://localhost:3000 in your browser. 

Please note that the User Interface has not been written to handle the error messages thrown by the stack-api application. To get this project running I learned the very basics of how a React JS application worked in order to demonstrate my ability to learn new technologies. Further work on the UI would include adding catch statements to the fetch statements to correctly handle these error message and display the messages to the end user. 

