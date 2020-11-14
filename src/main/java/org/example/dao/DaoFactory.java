package org.example.dao;

public class DaoFactory {
    public static Brands brandsDao;
    public static Employees employeesDao;
    private static Config config = new Config();

    public static Brands getBrandsDao(){
        if(brandsDao == null){
            brandsDao = new MySQLBrandsDao(config);
        }
        return brandsDao;
    }

    public static Employees getEmployeesDao () {
        if (employeesDao == null){
            employeesDao = new MySQLEmployeesDao(config);
        }
        return employeesDao;
    }
}
