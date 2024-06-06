# Utilisez l'image officielle de Node.js pour construire votre application
FROM node:latest AS build

# Définissez le répertoire de travail dans le conteneur
WORKDIR /usr/src/app

# Copiez les fichiers de package.json et package-lock.json dans le répertoire de travail
COPY package*.json ./

# Installez les dépendances
RUN npm install
RUN npm install leaflet --force
RUN npm install file-saver --force
RUN npm audit fix --force
RUN npm install file-saver --force
RUN npm install --save-dev @types/file-saver --force
RUN npm audit fix --force
RUN npm i --save-dev @types/leaflet --force
RUN npm audit fix --force
RUN npm install angularx-social-login --force
RUN npm audit fix --force
RUN npm install -g @angular/cli

# Copiez le reste des fichiers de l'application dans le répertoire de travail
COPY . .

# Construisez l'application
RUN npm run build

# Utilisez un serveur HTTP léger pour servir l'application Angular
FROM nginx:alpine

# Copiez les fichiers de construction de l'application dans le répertoire de travail du serveur HTTP
COPY --from=build /usr/src/app/dist/* /usr/share/nginx/html/

# Exposez le port 80 pour que l'application soit accessible
EXPOSE 80

# Démarrez le serveur HTTP lors du démarrage du conteneur
CMD ["nginx", "-g", "daemon off;"]
