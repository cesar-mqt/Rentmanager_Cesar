# Rentmanager_Cesar
Projet Rentmanager Min 4A

Toutes les fonctionnalités du projets sont fonctionnelles :

- Accueil : Les trois compteurs fonctionnent
- User : Affichage, création, édit , details et delete sont fonctionnels
- Voitures : Affichage, création, édit , details et delete sont fonctionnels
- Reservation : Affichage, création, édit et delete sont fonctionnels (je n'ai pas mis de détails pour les réservations car toutes les informations sont déja présentes lors de l'affichage) l'affichages se fait en fonction de l'ID des clients ou des voitures mais pour des raisons de visibilité ce sont les noms qui apparaissent. (La méthode mettant uniquement les ID est disponible dans le servlet en commentaire)
Pour l'affichage web j'ai fait une autre classe avec un autre constructeur pour montrer la différence mais pour que ce soit plus clair j'aurais surchargé le constructeur.


Les contraintes fonctionnelles sont  : 

- On ne peut pas créer un utilisateur qui a moins de 18 ans (création et edit)
- Le nom et le prénom de l'utilisateur doivent faire au minimum 3 caractères (création et edit)
- Le nombre de place d'une voiture est forcément entre 2 et 9 (création et edit)
- Un client ou une voiture ne peut pas être supprimé s'il y a une réservation en cours

Ces contraintes fonctionnent mais n'affichent pas de message d'erreur sur le site.




Les contraintes non fonctionnelles sont  :

- une voiture ne peux pas être réservé 2 fois le même jour
- une voiture ne peux pas être réservé plus de 7 jours de suite par le même utilisateur
- une voiture ne peux pas être réservé 30 jours de suite sans pause
- un client ayant une adresse mail déjà prise ne peut pas être créé
- si un client ou un véhicule est supprimé, alors il faut supprimer les réservations associées
