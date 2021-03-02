RQ : JAVA 1.8 obligatoire 
--------------------------------------------------
MainActivity (Page principale) :

Proposition de 5 services :

* 4 Intent explicite : 
 - Vérifier si je dois rester confiné ou pas 
 - Savoir les possibilités du groupe sanguin de des enfants 
 - Vérifier ma température est-elle normale ou pas ?
 - Vérifier mon IMC, est ce que mon poids est bien ou pas ?

* 1 Intent implicite : 
 - Un bouton qui méne vers le site de notre univesité UPVD.
----------------------------------------------------

ConfinementActivity (Service du confinement) :

L'utilisateur fait rentrer le nombre de jours depuis son dernier test positif, 
L'application va lui répondre si'il doit rester confiné ou pas, si oui elle va
lui dire le nombre de jours restant pour la fin de son confinement.

----------------------------------------------------

ChildsBgActivity (Service groupe sanguin de mon enfant) :

L'utilisateur doit choisir le groupe sanguin du pére et celui de la mére a travers les Spinners, 
Un simple click sur le bouton check, application répond en bas de la page le groupe sanguin de l'enfant 
( groupe sanguin le plus probable ).

----------------------------------------------------
TemperatureActivity (Service de temperature ) :

L'utilisateur doit faire rentrer sa température dans l'EditText, et choisir son sexe dans le Spinner,
Une fois avoir cliquer sur le bouton check, l'application lui répond si sa température est normale ou bien qu'il doir 
consulter un médecin.

----------------------------------------------------

ImcActivity (Service de l'IMC) :

L'utilisateur doit faire rentrer son poids en KG et sa taille en M, l'application va calculer son IMC, 
Et va afficher un message si il est : maigre, normal, proche de l'obésité, obése.

-----------------------------------------------------------------------
Application Myhealth créee par Walid MOKHTARI Rédigée par Mr Grabolosa
-----------------------------------------------------------------------
