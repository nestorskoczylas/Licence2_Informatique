TP Huffman
=================
Skoczylas Nestor Vasco Lucas
============================

Question 2.2
===============

Dans le dernier, on avait définit qu'un codage optimal permettait une amélioration de :

-4.39% pour notre WAV
-0.50% pour notre MP3
-0.88% pour notre OGG

-0.13% pour notre PNG
-1.24% pour notre JPEG
-5.93% pour notre BMP

-0.01% pour notre ZIP

-Notre fichier WAV original occupe 49193 Ko et une fois compressé il occupe 47208 Ko soit une amélioration de 4.03%

-Notre fichier MP3 original occupe 54256 Ko et une fois compressé il occupe 54154 Ko soit une amélioration de 0.19%

-Notre fichier OGG original occupe 14594 Ko et une fois compressé il occupe 14518 Ko soit une amélioration de 0.52%

-Notre fichier PNG original occupe 1850 Ko et une fois compressé il occupe 1851 Ko soit une amélioration de -0.05%

-Notre fichier JPEG original occupe 35 Ko et une fois compressé il occupe 36 Ko soit une amélioration de -2.86%

-Notre fichier BMP original occupe 707 Ko et une fois compressé il occupe 669 Ko soit une amélioration de 5.37%

-Notre fichier ZIP original occupe 117229 Ko et une fois compressé il occupe 117230 Ko soit une amélioration de 0%


Conclusion
===============
On remarque que les améliorations prévu par le codage optimal correspondent à nos résultats. 
On notera cependant que nos prévisons, ne prennent pas en compte le fait de stocker le nombres d'occurences des caractères dans le fichier. Ceci explique le fait que nos prévions soit plus haute que ce que nous observons.

Dans le cas des fichiers déjà compressés on remarque une augmentation du poids. 
Cela est dû au fait que la compression fait gagner un moins grand nombre d'octet que celui nécessaire pour stocker le nombre d'occurences des caractères.


