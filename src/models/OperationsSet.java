package models;

import java.util.*;

import interfaces.IOperationsSet;
import interfaces.ITheme;

public class OperationsSet implements IOperationsSet {

    private Set<ITheme> characters;

    public OperationsSet(Set<ITheme> characters) {
        this.characters = characters;
    }

    public Set<ITheme> getSetCharacters(){
        return characters;
    }

    @Override
    public Set<ITheme> intersection(Set<ITheme>p){
        p.retainAll(characters);
        return p;
    }


    @Override
    public Set<ITheme> difference(Set<ITheme>p){
        p.removeAll(characters);
        return p;
    }
}
