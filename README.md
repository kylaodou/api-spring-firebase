# Spring Boot + Firebase Firestore

Exemple minimal d'API REST Spring Boot qui enregistre et lit des utilisateurs dans Cloud
Firestore grâce au SDK Firebase Admin. Il sert de point de départ pour brancher une application
Spring sur Firebase.

## Routes

| Méthode | Route | Rôle |
|---|---|---|
| POST | `/api/v1/users` | Crée un utilisateur dans la collection Firestore |
| GET | `/api/v1/users/{userId}` | Lit un utilisateur |

Exemple :

```bash
curl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{"username": "awa", "emailId": "awa@example.com"}'
```

## Structure

```text
src/main/java/.../
├── SpringWithFirebaseApplication.java   # Point d'entrée
├── FirebaseConfig.java                  # Bean Firestore
├── UserController.java                  # Routes REST
├── User.java                            # Modèle
└── UserService.java                     # Accès à Firestore
```

## Stack technique

- Java 21, Spring Boot 3.4 (Web)
- Firebase Admin SDK 9
- Gradle

## Prérequis

- JDK 21
- Un projet Firebase avec Cloud Firestore activé
- Le fichier JSON d'un compte de service (console Firebase → Paramètres du projet → Comptes de
  service → Générer une nouvelle clé privée)

## Lancement

Définissez les variables d'environnement :

```bash
export GOOGLE_APPLICATION_CREDENTIALS=/chemin/vers/compte-de-service.json
export GOOGLE_CLOUD_PROJECT=identifiant-du-projet
```

Puis :

```bash
git clone https://github.com/kylaodou/api-spring-firebase.git
cd api-spring-firebase
./gradlew bootRun
```

Sous Windows, utilisez `set` pour les variables et `gradlew.bat bootRun`.

L'API écoute sur http://localhost:8080.

## Auteur

[@kylaodou](https://github.com/kylaodou)
