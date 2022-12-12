FROM openjdk:11
EXPOSE 8089
ADD ./target/DEVOPSS.jar DEVOPSS.jar
ENTRYPOINT ["java","-jar","/DEVOPSS.jar"]