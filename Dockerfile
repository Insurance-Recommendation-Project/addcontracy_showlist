FROM openjdk:11
ADD target/addcontracy_showlist.jar addcontracy_showlist.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "addcontracy_showlist.jar"]