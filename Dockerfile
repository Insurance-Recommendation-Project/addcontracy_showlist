FROM openjdk:11
ADD target/addcontracy_showlist.jar addcontracy_showlist.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "addcontracy_showlist.jar"]