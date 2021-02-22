To run the banking test app:
1. first download the TestProvider docker image, thesegovia/testprovider from Docker Hub
2. start the image: docker run -p 7902:7902 thesegovia/testprovider
3. cd to the root of the project and run mvn clean install
3. java -jar target/banking-0.0.1-SNAPSHOT.jar
4. curl http://localhost:8080/payment or use browser
5. in the window where you started the app, you will see the output. 

Alternatively, you could load up the project in your IDE and run it from there

