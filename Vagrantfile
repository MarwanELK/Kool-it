# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "generic/fedora37"

  config.vm.provider "virtualbox" do |vb|
    vb.memory = "8192"
    vb.cpus = 4
  end

  config.vm.provision "shell", inline: <<-SHELL
    # Mise à jour du système
    sudo dnf update -y

    # Installation de Java 21 (OpenJDK 21)
    sudo dnf install -y java-23-openjdk

    # Installation de Docker
    sudo dnf install -y docker

    # Installation de MySQL
    sudo dnf install -y mysql-server
    sudo systemctl start mysqld
    sudo systemctl enable mysqld

    # Installation de Node.js v18.x
    curl -fsSL https://rpm.nodesource.com/setup_18.x | sudo bash -
    sudo dnf install -y nodejs

    # Installation de Git
    sudo dnf install -y git

    # Clonage du dépôt GitHub
    git clone https://github.com/MarwanELK/Kool-it.git

    # Installation des dépendances pour le projet
    cd Kool-it
    npm install -g @angular/cli
    cd /home/vagrant/Kool-it/backend_koolit
    mvn clean install
    cd /home/vagrant/Kool-it/frontend_koolit
    npm install
    npm install leaflet --force
    npm install file-saver --force
    npm audit fix --force
    npm install --save-dev @types/file-saver --force
    npm audit fix --force
    npm i --save-dev @types/leaflet --force
    npm audit fix --force
    npm install angularx-social-login --force
    npm audit fix --force
  SHELL
end
