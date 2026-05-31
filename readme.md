# Project Password 🔐

**Project Password** est une application Java axée sur la cryptographie et la sécurisation des données d'authentification. L'objectif de ce projet est de poser les bases d'un gestionnaire de mots de passe local et open source, en mettant l'accent sur les bonnes pratiques de sécurité backend.

Ce dépôt fait office de **Proof of Concept (PoC)** fonctionnel sur la partie hachage et protection des données en mémoire.

## 🛠️ Fonctionnalités techniques intégrées

- **Hachage sécurisé :** Implémentation d'un système de hachage de mots de passe.
- **Gestion du SEL (Salage) :** Génération et application d'un sel unique par utilisateur pour contrer les attaques par dictionnaire et tables arc-en-ciel.
- **Protection Byte-à-Byte :** Manipulation sécurisée des données sensibles en mémoire via des tableaux de bytes pour éviter la persistance des chaînes de caractères (Strings) dans la Heap.

## 🚀 Objectifs de développement futurs

- [ ] **Générateur robuste :** Algorithme de génération de mots de passe aléatoires hautement sécurisés.
- [ ] **Chiffrement de base de données locale :** Stockage persistant et chiffré des identifiants sur la machine.

## 💻 Technologies utilisées

- **Langage :** Java (JDK 11+)
- **Cryptographie :** Bibliothèques natives de sécurité Java (sécurisation des flux de données).

## 📊 Statut du projet

Le projet valide avec succès la logique de hachage et de salage sécurisé en backend. Le développement global est actuellement en pause, mais la base cryptographique est fonctionnelle et prête pour une future extension vers une architecture MVC complète.
