FROM amazoncorretto:11
CMD ["-jar", "/opt/app/app.jar"]
RUN mkdir /opt/app
COPY ./target/spring-*.jar /opt/app/app.jar
# EXPOSE 3306
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/opt/app/app.jar"]