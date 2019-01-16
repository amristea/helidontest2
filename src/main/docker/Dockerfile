FROM elementalconcept/java8-mysql

COPY target/quickstart-se.jar /app
COPY target/libs /app/libs

ENTRYPOINT service mysqld start && /bin/bash

CMD ["/startup.sh"]
CMD ["java", "-jar", "/app/quickstart-se.jar"]
