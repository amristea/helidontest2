FROM elementalconcept/java8-mysql

COPY quickstart-mp.jar /app/
COPY libs /app/

ENTRYPOINT service mysql start && /bin/bash

CMD ["/startup.sh"]
CMD ["java", "-jar", "/app/quickstart-mp.jar"]
