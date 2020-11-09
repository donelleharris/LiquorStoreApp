package org.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.example.model.LiquorType;

public class LiquorService {
    public List getAvailableBrands(LiquorType type){
        List <String> brands = new ArrayList <>();

        if(type.equals(LiquorType.WINE)) {
            brands.add("14 Hands");
            brands.add("Dark Horse");
            brands.add("Liberty Creek");
        } else if(type.equals(LiquorType.BEER)) {
            brands.add("Budweiser");
            brands.add("Coors");
            brands.add("Michelob");
        } else if(type.equals(LiquorType.WHISKEY)) {
            brands.add("Maker's Mark");
            brands.add("Elijah Craig");
            brands.add("Jack Daniel's");
        } else if(type.equals(LiquorType.BOURBON)){
            brands.add("1792");
            brands.add("Woodford Reserve");
            brands.add("Ranger Creek");
        } else if(type.equals(LiquorType.RUM)) {
            brands.add("Bacardi");
            brands.add("Captain Morgan");
            brands.add("Brugal");
        } else if(type.equals(LiquorType.VODKA)){
            brands.add("Ciroc");
            brands.add("Kettle One");
            brands.add("Grey Goose");
        } else if(type.equals(LiquorType.SCOTCH)) {
            brands.add("Johnnie Walker Red");
            brands.add("Glenfiddich");
            brands.add("MaCallan");
        } else if (type.equals(LiquorType.GIN)){
            brands.add("Beefeater");
            brands.add("Tanqueray");
            brands.add("Hendrick's");
        }
        return brands;
    }
    public int getBrandStock(LiquorType type){
        int stockCount = 0;
        if(type.equals(LiquorType.BOURBON)){
            stockCount = 40;
        } else if(type.equals(LiquorType.VODKA)){
            stockCount = 50;
        }
        return stockCount;
    }
}
