package main;

import java.util.List;

/**
 * Created by kevinmo on 12/14/15.
 *
 * Class representing a card with attributes that is used to create a set.
 */
public class Card {
    private List<String> attributes;

    public Card(List<String> attributes){
        this.attributes = attributes;
    }

    public List<String> getAttributes(){
        return attributes;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        if (!(o instanceof Card)) {
            return false;
        }

        Card c = (Card) o;

        for(int i = 0; i < c.getAttributes().size(); i++){
            if(!attributes.get(i).equals(c.getAttributes().get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[ ");
        for(String s : attributes){
            sb.append(s + " ");
        }
        sb.append("]");
        return sb.toString();
    }
}