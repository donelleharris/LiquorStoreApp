package org.example.dao;

public class DaoFactory {
    public static Brands brandsDao;
    public static Users usersDao;
    private static Config config = new Config();

    public static Brands getBrandsDao(){
        if(brandsDao == null){
            brandsDao = new MySQLBrandsDao(config);
        }
        return brandsDao;
    }

    public static Users getUsersDao () {
        if (usersDao == null){
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
