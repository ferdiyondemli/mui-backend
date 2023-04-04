FROM openjdk:17
COPY ./target/mui-0.0.1-SNAPSHOT.jar mui-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","mui-0.0.1-SNAPSHOT.jar"]


#docker image build -t mui .
#docker   run   -p 8090:8088 -d mui