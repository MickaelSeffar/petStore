# PetStore 

## Description

PetStore est une application de gestion pour une animalerie. Elle permet de gérer les produits, les clients et les ventes de manière efficace.

## Fonctionnalités

Gestion des produits : ajout, modification, suppression et consultation des produits.
Gestion des clients : ajout, modification, suppression et consultation des informations des clients.
Gestion des ventes : enregistrement et suivi des ventes.
Prérequis

Java 21
Maven 3.6 ou supérieur
PostgreSQL
Installation

### Clonez le dépôt :

- HTTP : git clone <[clone http](https://github.com/MickaelSeffar/petStore.git)>
- SSH : git clone git@github.com:MickaelSeffar/petStore.git
- GitHub CLI : gh repo clone MickaelSeffar/petStore


## Accédez au répertoire du projet :

- Copier le code
- cd petStore
- Configurez votre base de données PostgreSQL et mettez à jour les informations de connexion dans le fichier de configuration de l'application (src/main/resources/META-INF/persistence.xml)

## Compilez le projet avec Maven :

- mvn clean install

## Structure du projet
src : Contient le code source de l'application.
pom.xml : Fichier de configuration Maven.
.gitignore : Fichier spécifiant les fichiers à ignorer par Git.
target : Répertoire où Maven génère les fichiers compilés.
.git : Répertoire contenant les informations du contrôle de version.
.idea : Répertoire contenant les configurations du projet pour l'IDE IntelliJ IDEA.
Dépendances

Hibernate 6.5.2
PostgreSQL JDBC 42.7.3
Contribution

### Author
- **Mickaël Seffar**
