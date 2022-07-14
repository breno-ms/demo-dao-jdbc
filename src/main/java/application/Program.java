package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        System.out.println("Testando o sellerDao.findById():");
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller1 = sellerDao.findById(1);
        Seller seller2 = sellerDao.findById(2);
        Seller seller3 = sellerDao.findById(3);
        Seller seller4 = sellerDao.findById(4);
        System.out.println(seller1);
        System.out.println(seller2);
        System.out.println(seller3);
        System.out.println(seller4);

        System.out.println("\nTestando o sellerDao.findByDepartment():");

        System.out.println("\nDepartamento de Id 1:");
        Department department1 = new Department(1, null);
        List<Seller> sellers1 = sellerDao.findByDepartment(department1);
        for (Seller s : sellers1) {
            System.out.println(s);
        }

        System.out.println("\nDepartamento de Id 2:");
        Department department2 = new Department(2, null);
        List<Seller> sellers2 = sellerDao.findByDepartment(department2);
        for (Seller s : sellers2) {
            System.out.println(s);
        }

        System.out.println("\nDepartamento de Id 3:");
        Department department3 = new Department(3, null);
        List<Seller> sellers3 = sellerDao.findByDepartment(department3);
        for (Seller s : sellers3) {
            System.out.println(s);
        }

        System.out.println("\nDepartamento de Id 4:");
        Department department4 = new Department(4, null);
        List<Seller> sellers4 = sellerDao.findByDepartment(department4);
        for (Seller s : sellers4) {
            System.out.println(s);
        }

        System.out.println("\nTestando o sellerDao.findAll():");
        List<Seller> allSellers = sellerDao.findAll();
        for (Seller s : allSellers) {
            System.out.println(s);
        }

        System.out.println("\nTestando o sellerDao.insert():");
        Seller seller5 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department1);
        sellerDao.insert(seller5);
        System.out.println("New seller inserted in the database. New id: " + seller5.getId());

    }

}
