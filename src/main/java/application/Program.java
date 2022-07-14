package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
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

        //System.out.println("\nTestando o sellerDao.insert():");
        //Seller seller5 = new Seller(null, "Greg Grey", "greg@gmail.com", new Date(), 4000.0, department1);
        //sellerDao.insert(seller5);
        //System.out.println("New seller inserted in the database. New id: " + seller5.getId());

        System.out.println("\nTestando o sellerDao.update():");
        Seller seller6 = new Seller(8, "Sophia Pink", "sophia@gmail.com", new Date(), 4500.0, department4);
        sellerDao.update(seller6);

        System.out.println("\nTestando o sellerDao.deleteById():");
        sellerDao.deleteById(9);

        System.out.println("\nTestando os métodos do DepartmentDaoJDBC");

        System.out.println("\nTestando o departmentDao.findById():");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        List<Department> departments = new ArrayList<>();

        Department department1_ = departmentDao.findById(1);
        Department department2_ = departmentDao.findById(2);
        Department department3_ = departmentDao.findById(3);
        Department department4_ = departmentDao.findById(4);
        Department department5_ = departmentDao.findById(5);
        Department department6_ = departmentDao.findById(6);

        System.out.println(department1_);
        System.out.println(department2_);
        System.out.println(department3_);
        System.out.println(department4_);
        System.out.println(department5_);
        System.out.println(department6_);

        System.out.println("\nTestando o departmentDao.findAll():");
        departments = departmentDao.findAll();
        for (Department d : departments) {
            System.out.println(d);
        }

        System.out.println("\nTestando o departmentDao.insert():");
        Department department7 = new Department(7, "Operacional");
        departmentDao.insert(department7);
        departments = departmentDao.findAll();
        for (Department d : departments) {
            System.out.println(d);
        }

        System.out.println("\nTestando o departmentDao.update():");
        Department department8 = new Department(6, "Relações Públicas");
        departmentDao.update(department8);
        departments = departmentDao.findAll();
        for (Department d : departments) {
            System.out.println(d);
        }

        System.out.println("\nTestando o departmentDao.removeById():");
        departmentDao.deleteById(7);
        departments = departmentDao.findAll();
        for (Department d : departments) {
            System.out.println(d);
        }

    }

}
