package org.example.dao;

public class DaoFactory {
    public static Brands brandsDao;

    private static Config config = new Config();

    public static Brands getBrandsDao(){
        if(brandsDao == null){
            brandsDao = new MySQLBrandsDao(config);
        }
        return brandsDao;
    }
}
