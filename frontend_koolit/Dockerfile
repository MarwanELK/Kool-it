# Utilisez l'image Node.js comme base pour la construction
FROM node:latest AS build

# Définissez le répertoire de travail dans le conteneur
WORKDIR /app

# Copiez les fichiers de package.json et package-lock.json dans le conteneur
COPY package*.json ./

# Installez les dépendances
RUN npm install --force \
    && npm install leaflet --force \
    && npm install file-saver --force \
    && npm audit fix --force \
    && npm install file-saver --force \
    && npm install --save-dev @types/file-saver --force \
    && npm audit fix --force \
    && npm install --save-dev @types/leaflet --force \
    && npm audit fix --force \
    && npm install -g @angular/cli 

# Copiez le reste des fichiers de l'application dans le conteneur
COPY . .

# Construisez l'application Angular
RUN npm run build --prod

# Utilisez l'image Nginx comme image finale
FROM nginx:latest

# Copiez les fichiers de l'application construite depuis l'étape précédente dans le répertoire de travail du serveur web Nginx
COPY --from=build /app/dist/* /usr/share/nginx/html/

# Exposez le port 80 pour permettre l'accès à l'application
EXPOSE 80
