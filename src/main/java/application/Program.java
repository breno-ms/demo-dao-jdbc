package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Department department = new Department(1, "Administrativo");
        Seller seller = new Seller(1, "Bob", "bob@email.com", new Date(), 3000.0, department);

        SellerDao sellerDao = DaoFactory.createSellerDao();

    }

}
