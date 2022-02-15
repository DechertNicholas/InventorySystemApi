FROM openjdk:17-alpine
EXPOSE 8090
COPY target/inventorysystemapi.jar inventorysystemapi.jar
ENTRYPOINT ["java","-jar","/inventorysystemapi.jar"]
