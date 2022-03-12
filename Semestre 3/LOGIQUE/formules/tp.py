from analyseur import formules_depuis_fichier

from formule import *


for f in formules_depuis_fichier("formules.txt"):
    print(f.to_string())
    print(f.hauteur())
    print(f.variables())
    print(f.eval({'a' : True, 'b' : False, 'c' : True, 'd' : False}))
    print("\n")
    
