/*
 * P218 Exercise1
 * Practice for generic type in ArrayList
 */

package com.chapter11;

import java.util.*;

public class P218 {
    public static void main(String[] args) {
        int i = 0;
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        Gerbil a = new Gerbil(1);
        Gerbil b = new Gerbil(2);
        Gerbil c = new Gerbil(3);

        gerbils.add(a);
        gerbils.add(b);
        gerbils.add(c);

        for (i = 0; i < gerbils.size(); i++) {
            gerbils.get(i).hop();
        }

        for (Gerbil g : gerbils) {
            g.hop();
        }

    }
}

class Gerbil {
    int gerbilNumber;

    public Gerbil(int number) {
        this.gerbilNumber = number;
    }

    public Gerbil() {

    }

    public int getGerbilNumber() {
        return gerbilNumber;
    }

    public void hop() {
        System.out.println("gerbil number: " + gerbilNumber + " is hopping!");
    }

}
