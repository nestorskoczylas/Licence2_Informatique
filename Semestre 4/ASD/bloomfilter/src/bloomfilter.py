# -*- coding: utf-8 -*-

""":mod:`bloomfilter` module : Implements a bloomfilter.

:author: `FIL - Univ. Lille <http://portail.fil.univ-lille1.fr>`_

:date: 2021

"""
import hash_functions

class BloomFilter:
    
    def __init__ (self, n, hashes):
        """
        Creates a new empty Bloom filter of size :math:`2^n`
        
        :param n: the log of the size of the filter (the filter will be of size :math:`2^n`)
        :type n: int
        :param hashes: the hash functions
        :type hashes: HashFunctions
        """
        f = {}
        for i in range(2**n) :
            f[i] = False
        self.filtre = f
        self.hashes = hashes


    def add (self, e):
        """
        Adds *e* to the Bloom filter.

        :param e: The element to be added
        :type e: Any
        :rtype: None
        """
        res = False
        for k in self.filtre.values() :
            if k == False :
                res = True
        if res == False :
            return False

        for i in range(self.hashes.nb_functions()) :
            cle = self.hashes.hash(i,e) % len(self.filtre)
            self.filtre[cle] = True
        return True

    def contains (self, e):
        """
        Returns True if *e* is stored in the Bloom filter

        :param e: The element to be tested
        :type e: Any
        :rtype: bool
        """
        for i in range(self.hashes.nb_functions()) :
            cle = self.hashes.hash(i,e) % len(self.filtre)
            if self.filtre[cle] == False :
                return False
        return True
    
    def __contains__(self, e):
        return self.contains(e)
