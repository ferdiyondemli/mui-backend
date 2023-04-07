FROM openjdk:17

COPY ./target/mui-0.0.1-SNAPSHOT.jar mui-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","mui-0.0.1-SNAPSHOT.jar"]


#docker image build -t muibackend .
#docker   run --network=mui-backend_muinet  -p 8088:8088 -d muibackend