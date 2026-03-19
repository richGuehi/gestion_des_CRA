#  Application de gestion des CRA (CBX)

##  Objectif
Développement d’une application full-stack de gestion des Comptes Rendus d’Activité (CRA) avec deux rôles :
- Admin
- Collaborateur

---

##  Stack technique
- Backend : Spring Boot 3 
- Frontend : Angular (en cours)
- Base de données :  PostgreSQL
- Authentification : JWT

---

##  Backend — Fonctionnalités implémentées

###  Authentification
- Authentification via JWT
- Gestion des rôles (Admin / Collaborateur)

###  Gestion des collaborateurs
- Création / modification / activation / désactivation
- Gestion des informations :
    - Nom, prénom, email
    - Statut, contrat, séniorité, salaire

### Gestion des missions
- CRUD complet
- Gestion des dates, description, TJM

###  Affectations
- Affectation des missions aux collaborateurs

###  Gestion des CRA
- Création automatique des CRA
- Gestion des états :
    - DRAFT
    - SUBMITTED
    - APPROVED
    - REJECTED
    - INVALIDATED
- Validation admin (approve / reject / invalidate avec motif)

###  Règles métier
- Fenêtre de saisie : 22 → 28 du mois
- Blocage modification selon état
- Gestion intercontrat automatique si aucune mission
- Respect des contraintes métier principales

---

##  Frontend — État actuel

Fonctionnalités implémentées :
- Interface de connexion
- Sidebar de navigation
- Liste des utilisateurs

 Le frontend n’est pas encore finalisé.  

