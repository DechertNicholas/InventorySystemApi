FROM openjdk:17-alpine
EXPOSE 80
COPY target/inventorysystemapi.jar inventorysystemapi.jar
ENTRYPOINT ["java","-jar","/inventorysystemapi.jar"]
