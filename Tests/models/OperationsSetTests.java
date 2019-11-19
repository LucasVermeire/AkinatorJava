package models;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import interfaces.ITheme;


class OperationsSetTests {


    @Test
    public void intersectionSetPersonnage() {


        Set<ITheme> characters = new TreeSet<ITheme>();
        characters.add(new Character("Lucas","Etudiant 1"));
        characters.add(new Character("Bernard","Etudiant 4"));
        characters.add(new Character("Yann","Etudiant 7"));
        characters.add(new Character("Sam","Etudiant 6"));


        Set<ITheme>personnages2 = new TreeSet<ITheme>();
        personnages2.add(new Character("Lucas","Etudiant 1"));
        personnages2.add(new Character("Sam","Etudiant 6"));

        OperationsSet operations = new OperationsSet(characters);

        Set<ITheme> persoInters = operations.intersection(personnages2);

        assertTrue(persoInters.contains(new Character("Lucas","Etudiant 1")));
        assertFalse(persoInters.contains(new Character("Bernard","Etudiant 4")));
        assertFalse(persoInters.contains(new Character("Yann","Etudiant 7")));
        assertTrue(persoInters.contains(new Character("Sam","Etudiant 6")));
    }

    @Test
    public void differenceSetPersonnage() {

        Set<ITheme> characters = new TreeSet<ITheme>();
        characters.add(new Character("Lucas","Etudiant 1"));
        characters.add(new Character("Bernard","Etudiant 4"));
        characters.add(new Character("Yann","Etudiant 7"));

        Set<ITheme>personnages2 = new TreeSet<ITheme>();
        personnages2.add(new Character("Lucas","Etudiant 1"));
        personnages2.add(new Character("Sam","Etudiant 6"));

        OperationsSet operations = new OperationsSet(characters);

        Set<ITheme> persoDiff = operations.difference(personnages2);

        assertFalse(persoDiff.contains(new Character("Lucas","Etudiant 1")));
        assertFalse(persoDiff.contains(new Character("Bernard","Etudiant 4")));
        assertFalse(persoDiff.contains(new Character("Yann","Etudiant 7")));
        assertTrue(persoDiff.contains(new Character("Sam","Etudiant 6")));
    }
}
