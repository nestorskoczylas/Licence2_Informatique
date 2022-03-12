# -*- coding: utf-8 -*-

"""
:mod:`test` module : test module for quicksort assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january
"""

import math
import sorting
import generate
import copy
from element import Element

global cpt

def cmp(a,b):
    """
    A comparison function

    :param a: First element    
    :param b: Second element
    :return: 0 if a == b, 1 if a > b, -1 if a < b
    :rtype: int

    >>> from element import Element
    >>> cpt = 0
    >>> cmp(Element(10),Element(5))
    1
    >>> cmp(Element(5),Element(5))
    0
    >>> cmp(Element(5),Element(10))
    -1
    """
    global cpt
    cpt = cpt + 1
    return Element.cmp(a,b)

if __name__ == "__main__":
    cpt = 0

    import doctest
    doctest.testmod()

    t = generate.random_array(100)
    tt = sorting.merge_sort(t,cmp)
    print(tt)
    if generate.is_sorted(tt):
        print("Yes !!")
        print(cpt) 
    else:
        raise Exception("Array has not been correctly sorted by merge sort")
    
    cpt = 0
    t2 = copy.deepcopy(t)
    
    sorting.quicksort(t2,cmp,sorting.random_pivot)
    if generate.is_sorted (t2):
        print("Yes !!")
        print(cpt)
    else:
        raise Exception("Array has not been correctly sorted by quicksort")

    l1=[]
    l2=[]
    l3=[]
    l4=[]

    with open("random_100.dat","w") as f:
        for i in range(1,101):
            for j in range(0,100) :

                cpt = 0
                t = generate.random_array(i)
                tt = sorting.merge_sort(t,cmp)
                #print (tt)
                if generate.is_sorted (tt):
                    #print("Yes !!")
                    #print(cpt)
                    l1.append(cpt) 
                else:
                    raise Exception("Array has not been correctly sorted by merge sort")
            
                cpt = 0
                t2 = copy.deepcopy(t)
            
                sorting.quicksort(t2,cmp,sorting.naive_pivot)
                if generate.is_sorted (t2):
                    #print("Yes !!")
                    #print(cpt)
                    l2.append(cpt)
                else:
                    raise Exception("Array has not been correctly sorted by quicksort")

                cpt = 0
                t3 = copy.deepcopy(t)
            
                sorting.quicksort(t3,cmp,sorting.random_pivot)
                if generate.is_sorted (t3):
                    #print("Yes !!")
                    #print(cpt)
                    l3.append(cpt)
                else:
                    raise Exception("Array has not been correctly sorted by quicksort")
                

                cpt = 0
                t4 = copy.deepcopy(t)
            
                sorting.quicksort(t4,cmp,sorting.optimal_pivot)
                if generate.is_sorted (t4):
                    #print("Yes !!")
                    #print(cpt)
                    l4.append(cpt)
                else:
                    raise Exception("Array has not been correctly sorted by quicksort")

            """
            a = "Nombres de valeurs : " + str(i)
            f.write(a)
            f.write("\n")
            b = "merge_sort : " + str(round(sum(l1)/len(l1),2))
            f.write(b)
            f.write("\n")
            c = "quicksort_naive : " + str(round(sum(l2)/len(l2),2))
            f.write(c)
            f.write("\n")
            d = "quicksort_random : " + str(round(sum(l3)/len(l3),2))
            f.write(d)
            f.write("\n")
            e = "quicksort_optimal : " + str(round(sum(l4)/len(l4),2))
            f.write(e)
            f.write("\n")
            """

            f.write(str(i))
            f.write(" ")
            f.write(str(round(sum(l1)/len(l1),2)))
            f.write(" ")
            f.write(str(round(sum(l2)/len(l2),2)))
            f.write(" ")
            f.write(str(round(sum(l3)/len(l3),2)))
            f.write(" ")
            f.write(str(round(sum(l4)/len(l4),2)))
            f.write('\n')

    l1=[]
    l2=[]
    l3=[]
    l4=[]

    with open("increasing_100.dat","w") as f:
        for i in range(1,101):
            for j in range(0,100) :

            
                cpt = 0
                t = generate.increasing_array(i)
                tt = sorting.merge_sort(t,cmp)
                #print (tt)
                if generate.is_sorted (tt):
                    #print("Yes !!")
                    #print(cpt)
                    l1.append(cpt) 
                else:
                    raise Exception("Array has not been correctly sorted by merge sort")
            
                cpt = 0
                t2 = copy.deepcopy(t)
            
                sorting.quicksort(t2,cmp,sorting.naive_pivot)
                if generate.is_sorted (t2):
                    #print("Yes !!")
                    #print(cpt)
                    l2.append(cpt)
                else:
                    raise Exception("Array has not been correctly sorted by quicksort")

                cpt = 0
                t3 = copy.deepcopy(t)
            
                sorting.quicksort(t3,cmp,sorting.random_pivot)
                if generate.is_sorted (t3):
                    #print("Yes !!")
                    #print(cpt)
                    l3.append(cpt)
                else:
                    raise Exception("Array has not been correctly sorted by quicksort")


                cpt = 0
                t4 = copy.deepcopy(t)
            
                sorting.quicksort(t4,cmp,sorting.optimal_pivot)
                if generate.is_sorted (t4):
                    #print("Yes !!")
                    #print(cpt)
                    l4.append(cpt)
                else:
                    raise Exception("Array has not been correctly sorted by quicksort")
        
            f.write(str(i))
            f.write(" ")
            f.write(str(round(sum(l1)/len(l1),2)))
            f.write(" ")
            f.write(str(round(sum(l2)/len(l2),2)))
            f.write(" ")
            f.write(str(round(sum(l3)/len(l3),2)))
            f.write(" ")
            f.write(str(round(sum(l4)/len(l4),2)))
            f.write('\n')


    