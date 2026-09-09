package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void unePileFraichementCreeeEstVide() {
        Stack pile = new ArrayStack();

        assertTrue(pile.isEmpty());
        assertEquals(0, pile.getSize());
    }
    @Test
    void pushAugmenteLaTailleEtRendLaPileNonVide() {
        Stack pile = new ArrayStack();

        pile.push(42);

        assertFalse(pile.isEmpty());
        assertEquals(1, pile.getSize());
    }
    @Test
    void peekRetourneLeDernierElementEmpileSansLeRetirer() {
        Stack pile = new ArrayStack();
        pile.push(1);
        pile.push(2);

        assertEquals(2, pile.peek());
        assertEquals(2, pile.getSize()); // peek ne retire rien
    }
    @Test
    void popRetireEtRetourneLeDernierElementEmpile() {
        Stack pile = new ArrayStack();
        pile.push(1);
        pile.push(2);

        int sommet = pile.pop();

        assertEquals(2, sommet);
        assertEquals(1, pile.getSize());
        assertEquals(1, pile.peek()); // il ne reste plus que le 1
    }
    @Test
    void peekSurPileVideLeveEmptyStackException() {
        Stack pile = new ArrayStack();

        assertThrows(EmptyStackException.class, () -> pile.peek());
    }

    @Test
    void popSurPileVideLeveEmptyStackException() {
        Stack pile = new ArrayStack();

        assertThrows(EmptyStackException.class, () -> pile.pop());
    }
    @Test
    void peekAvecIndexRetourneLElementALaPositionDonnee() {
        Stack pile = new ArrayStack();
        pile.push(10); // index 0, le fond
        pile.push(20);
        pile.push(30); // le sommet, index 2

        assertEquals(10, pile.peek(0));
        assertEquals(20, pile.peek(1));
        assertEquals(30, pile.peek(2));
    }

    @Test
    void peekAvecIndexInvalideLeveNoSuchElementException() {
        Stack pile = new ArrayStack();
        pile.push(10);

        assertThrows(NoSuchElementException.class, () -> pile.peek(5));
        assertThrows(NoSuchElementException.class, () -> pile.peek(-1));
    }
}