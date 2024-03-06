package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

/**
 * Tests Unitaires pour la classe MyUnsortedList
 */
public class MyUnsortedListTest 
{

    @Test
    // Teste la méthode of avec des éléments en paramètre
    public void testOf() {
        
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);

        assertEquals(4, list.size());
    }

    @Test
    // Teste la méthode of sans éléments en paramètre
    public void testOfWithoutElements() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        assertEquals(0, list.size());
    }

    @Test
    // Teste la méthode of avec une liste d'éléments en paramètre
    public void testOfWithIterable() {
        
        ArrayList<Integer> liste = new ArrayList<Integer>();
        liste.add(1);
        liste.add(2);
        liste.add(3);
        liste.add(4);

        UnsortedList<Integer> list = MyUnsortedList.of(liste);

        assertEquals(4, list.size());
    }

    @Test
    // Teste la méthode of avec une liste vide en paramètre
    public void testOfWithEmptyIterable() {
        
        ArrayList<Integer> liste = new ArrayList<Integer>();

        UnsortedList<Integer> list = MyUnsortedList.of(liste);

        assertEquals(0, list.size());
    }

    @Test
    // Teste la méthode append avec un élément
    public void testAppend() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(6);

        assertEquals(1, list.size());
    }

    @Test
    // Teste la méthode append avec plusieurs éléments
    public void testMultipleAppend() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        assertEquals(4, list.size());
    }

    @Test
    // Teste la méthode prepend avec un élément
    public void testPrepend() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(6);

        assertEquals(1, list.size());
    }

    @Test
    // Teste la méthode prepend avec plusieurs éléments
    public void testMultiplePrepend() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        list.prepend(4);

        assertEquals(4, list.size());
    }

    @Test
    // Teste la méthode remove sur une liste vide (doit lever une exception IndexOutOfBoundsException)
    public void testRemoveEmptyList() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    // Teste la méthode remove sur un index supérieur à la taille de la liste (doit lever une exception IndexOutOfBoundsException)
    public void testRemoveInvalidIndex() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(10));
    }

    @Test
    // Teste la méthode remove sur un index égal à la taille de la liste (doit lever une exception IndexOutOfBoundsException)
    public void testRemoveIndexEqualToSize() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(4));
    }

    @Test
    // Teste la méthode remove sur un index négatif (doit lever une exception IndexOutOfBoundsException)
    public void testRemoveNegativeIndex() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    // Teste la méthode remove sur un élément
    public void testRemove() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(2);

        assertEquals(3, list.size());
    }

    @Test
    // Teste la méthode remove sur plusieurs éléments
    public void testMultipleRemove() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(0);
        list.remove(1);

        assertEquals(2, list.size());
    }

    @Test
    // Teste la méthode remove sur le premier élément de la liste
    public void testRemoveFirstElement() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(0);

        assertEquals(3, list.size());
    }

    @Test
    // Teste la méthode remove sur le dernier élément de la liste
    public void testRemoveLastElement() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(3);

        assertEquals(3, list.size());
    }

    @Test
    // Teste la méthode remove sur tous les éléments de la liste dans l'ordre
    public void testRemoveAll() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);

        assertEquals(0, list.size());
    }

    @Test
    // Teste la méthode remove sur tous les éléments de la liste dans l'ordre inverse
    public void testRemoveAllReverse() {

        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);
    }

    @Test
    // Teste la méthode remove sur tous les éléments de la liste puis ajout de nouveaux éléments
    public void testRemoveAllAndAppend() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);

        list.append(5);
        list.append(6);
        list.append(7);

        assertEquals(3, list.size());
    }

    @Test
    // Teste la méthode remove sur tous les éléments de la liste puis ajout de nouveaux éléments et supprimer quelques éléments
    public void testRemoveAllAndAppendAndRemove() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);

        list.append(5);
        list.append(6);
        list.append(7);

        list.remove(0);
        list.remove(1);

        assertEquals(1, list.size());
    }

    @Test
    // Teste la méthode remove sur tous les éléments de la liste puis ajout de nouveaux éléments et supprime tous ces éléments
    public void testRemoveAllAndAppendAndRemoveAll() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);

        list.append(5);
        list.append(6);
        list.append(7);

        list.remove(0);
        list.remove(0);
        list.remove(0);

        assertEquals(0, list.size());
    }

    @Test
    // Teste si la liste est vide
    public void testIsEmpty() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        assertEquals(true, list.isEmpty());
    }

    @Test
    // Teste si la liste n'est pas vide
    public void testIsNotEmpty() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);

        assertEquals(false, list.isEmpty());
    }

    @Test
    // Teste la méthode size après avoir ajouté plusieurs éléments
    public void testSize() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);
        list.append(14);

        assertEquals(5, list.size());
    }

    @Test
    // Teste la méthode size après avoir ajouté plusieurs éléments en utilisant prepend
    public void testSizeAfterPrepend() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(10);
        list.prepend(11);
        list.prepend(12);
        list.prepend(13);
        list.prepend(14);

        assertEquals(5, list.size());
    }

    @Test
    // Teste la méthode size après avoir ajouté plusieurs éléments en utilisant un mélange de prepend et append
    public void testSizeAfterMixedAdd() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(10);
        list.append(11);
        list.prepend(12);
        list.append(13);
        list.prepend(14);

        assertEquals(5, list.size());
    }

    @Test
    // Teste la méthode size après avoir ajouté plusieurs éléments en utilisant un mélange de prepend et append et en supprimant des éléments
    public void testSizeAfterMixedAddAndRemove() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(10);
        list.append(11);
        list.prepend(12);
        list.append(13);
        list.prepend(14);

        list.remove(0);
        list.remove(2);

        assertEquals(3, list.size());
    }

    @Test
    // Teste la méthode size après avoir ajouté plusieurs éléments en utilisant un mélange de prepend et append et en supprimant tous les éléments
    public void testSizeAfterMixedAddAndRemoveAll() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(10);
        list.append(11);
        list.prepend(12);
        list.append(13);
        list.prepend(14);

        list.toString();

        list.remove(4);
        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);

        assertEquals(0, list.size());
    }

    @Test
    // Teste la méthode size après avoir ajouté plusieurs éléments en utilisant un mélange de prepend et append et en supprimant tous les éléments puis en ajoutant de nouveaux éléments
    public void testSizeAfterMixedAddAndRemoveAllAndAdd() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(10);
        list.append(11);
        list.prepend(12);
        list.append(13);
        list.prepend(14);

        list.remove(0);
        list.remove(3);
        list.remove(1);
        list.remove(0);
        list.remove(0);

        list.append(15);
        list.append(16);
        list.append(17);

        assertEquals(3, list.size());
    }

    @Test
    // Teste la méthode pop sur une liste vide (doit lever une exception IndexOutOfBoundsException)
    public void testPopEmptyList() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        assertThrows(EmptyListException.class, () -> list.pop());
    }

    @Test
    // Teste la méthode pop sur une liste avec un seul élément
    public void testPopSingleElement() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);

        list.pop();

        assertEquals(0, list.size());
    }

    @Test
    // Teste la méthode pop sur une liste avec plusieurs éléments
    public void testPopMultipleElements() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);
        list.append(14);

        list.pop();
        list.pop();
        list.pop();

        assertEquals(2, list.size());
    }

    @Test
    // Teste la méthode popLast sur une liste vide (doit lever une exception IndexOutOfBoundsException)
    public void testPopLastEmptyList() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        assertThrows(IndexOutOfBoundsException.class, () -> list.popLast());
    }

    @Test
    // Teste la méthode popLast sur une liste avec un seul élément
    public void testPopLastSingleElement() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);

        list.popLast();

        assertEquals(0, list.size());
    }

    @Test
    // Teste la méthode popLast sur une liste avec plusieurs éléments
    public void testPopLastMultipleElements() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);
        list.append(14);

        list.popLast();
        list.popLast();
        list.popLast();

        assertEquals(2, list.size());
    }

    @Test
    // Teste la méthode insert sur une liste vide
    public void testInsertEmptyList() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.insert(10, 0);

        assertEquals(1, list.size());
    }

    @Test
    // Teste la méthode insert sur une liste avec un seul élément
    public void testInsertSingleElement() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);

        list.insert(11, 1);

        assertEquals(2, list.size());
    }

    @Test
    // Teste la méthode insert sur une liste avec plusieurs éléments
    public void testInsertMultipleElements() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);
        list.append(14);

        list.insert(15, 3);

        assertEquals(6, list.size());
    }

    @Test
    // Teste la méthode insert sur une liste avec plusieurs éléments en utilisant un mélange de prepend et append
    public void testInsertMixedAdd() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.prepend(10);
        list.append(11);
        list.prepend(12);
        list.append(13);
        list.prepend(14);

        list.insert(15, 3);

        assertEquals(6, list.size());
    }

    @Test
    // Teste la méthode insert sur un index supérieur à la taille de la liste (doit lever une exception IndexOutOfBoundsException)
    public void testInsertInvalidIndex() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);
        list.append(14);

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(15, 10));
    }

    @Test
    // Teste la méthode insert sur un index égal à la taille de la liste
    public void testInsertIndexEqualToSize() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);
        list.append(14);

        list.insert(15, 5);

        assertEquals(6, list.size());
    }

    @Test
    // Teste la méthode insert sur un index négatif (doit lever une exception IndexOutOfBoundsException)
    public void testInsertNegativeIndex() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);
        list.append(14);

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(15, -1));
    }

    @Test
    // Teste la méthode equals sur deux listes vides
    public void testEqualsEmptyLists() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();
        UnsortedList<Integer> list2 = MyUnsortedList.of();

        assertEquals(true, list1.equals(list2));
    }

    @Test
    // Teste la méthode equals sur deux listes avec un seul élément
    public void testEqualsSingleElementLists() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();
        UnsortedList<Integer> list2 = MyUnsortedList.of();

        list1.append(10);
        list2.append(10);

        assertEquals(true, list1.equals(list2));
    }

    @Test
    // Teste la méthode equals sur une même liste (doit retourner true)
    public void testEqualsSameList() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();

        list1.append(10);
        list1.append(11);
        list1.append(12);
        list1.append(13);
        list1.append(14);

        assertEquals(true, list1.equals(list1));
    }

    @Test
    // Teste la méthode equals sur deux listes différentes (doit retourner false)
    public void testEqualsDifferentLists() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();
        UnsortedList<Integer> list2 = MyUnsortedList.of();

        list1.append(10);
        list2.append(11);

        assertEquals(false, list1.equals(list2));
    }

    @Test
    // Teste la méthode equals sur deux listes avec plusieurs éléments
    public void testEqualsMultipleElementsLists() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();
        UnsortedList<Integer> list2 = MyUnsortedList.of();

        list1.append(10);
        list1.append(11);
        list1.append(12);
        list1.append(13);
        list1.append(14);

        list2.append(10);
        list2.append(11);
        list2.append(12);
        list2.append(13);
        list2.append(14);

        assertEquals(true, list1.equals(list2));
    }

    @Test
    // Teste la méthode equals sur deux listes avec plusieurs éléments mais pas dans le même ordre
    public void testEqualsMultipleElementsListsDifferentOrder() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();
        UnsortedList<Integer> list2 = MyUnsortedList.of();

        list1.append(10);
        list1.append(11);
        list1.append(12);
        list1.append(13);
        list1.append(14);

        list2.append(14);
        list2.append(13);
        list2.append(12);
        list2.append(11);
        list2.append(10);

        assertEquals(false, list1.equals(list2));
    }

    @Test
    // Teste la méthode equals sur une liste et un autre type de liste vide
    public void testEqualsDifferentTypeEmpty() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        UnsortedList<Integer> list2 = MyUnsortedList.of(arrayList);

        assertEquals(true, list1.equals(list2));
    }

    @Test
    // Teste la méthode equals sur une liste avec un autre type de liste
    public void testEqualsDifferentType2() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        list1.append(10);
        list1.append(11);
        list1.append(12);
        list1.append(13);
        list1.append(14);

        arrayList.add(10);
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);

        UnsortedList<Integer> list2 = MyUnsortedList.of(arrayList);

        assertEquals(true, list2.equals(list1));
    }

    @Test
    // Teste la méthode equals sur deux listes de tailles différentes
    public void testEqualsDifferentSize() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();
        UnsortedList<Integer> list2 = MyUnsortedList.of();

        list1.append(10);
        list1.append(11);
        list1.append(12);
        list1.append(13);
        list1.append(14);

        list2.append(10);
        list2.append(11);
        list2.append(12);
        list2.append(13);

        assertEquals(false, list1.equals(list2));
    }

    @Test
    // Teste la méthode equals entre une liste et null
    public void testEqualsNull() {
        
        UnsortedList<Integer> list1 = MyUnsortedList.of();

        assertEquals(false, list1.equals(null));
    }

    @Test
    // Teste la méthode toString sur une liste vide
    public void testToStringEmptyList() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        assertEquals("MyUnsortedList { size = 0, [] }", list.toString());
    }

    @Test
    // Teste la méthode toString sur une liste avec un seul élément
    public void testToStringSingleElementList() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);

        assertEquals("MyUnsortedList { size = 1, [10] }", list.toString());
    }

    @Test
    // Teste la méthode toString sur une liste avec plusieurs éléments
    public void testToStringMultipleElementsList() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);
        list.append(14);

        assertEquals("MyUnsortedList { size = 5, [10, 11, 12, 13, 14] }", list.toString());
    }

    @Test
    // Teste si l'ajoût d'un élément à une liste est bel et bien à la bonne position
    public void testAddElementAtPosition() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);

        list.insert(15, 2);

        assertEquals(10, list.pop());
        assertEquals(11, list.pop());
        assertEquals(15, list.pop());
        assertEquals(12, list.pop());
        assertEquals(13, list.pop());
    }

    @Test
    // Teste si l'ajoût d'un élément à une liste est bel et bien à la bonne position
    public void testAddElementAtPosition2() {
        
        UnsortedList<Integer> list = MyUnsortedList.of();

        list.append(10);
        list.append(11);
        list.append(12);
        list.append(13);

        list.insert(15, 0);

        assertEquals(15, list.pop());
        assertEquals(10, list.pop());
        assertEquals(11, list.pop());
        assertEquals(12, list.pop());
        assertEquals(13, list.pop());
    }
}