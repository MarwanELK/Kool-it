# Utilisez l'image OpenJDK comme base
FROM openjdk:latest

# Définissez le répertoire de travail dans le conteneur
WORKDIR /app

# Copiez le fichier JAR de votre application Java dans le conteneur
COPY target/backend_koolit-0.0.1-SNAPSHOT.jar backend_koolit.jar

# Exécutez l'application Java au démarrage du conteneur
CMD ["java", "-jar", "backend_koolit.jar"]
