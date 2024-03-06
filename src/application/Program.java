package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== TEST 1: Seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== TEST 2: Seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 3: Seller findAll ====");
        List<Seller> seller1 = sellerDao.findAll();
        for (Seller obj : seller1){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 4: Seller Insert ====");
        Seller newSeller = new Seller(null, "Greg", "grteg@hmail.com", new Date(), 3000.0, new Department(2, null));
//        sellerDao.insert(newSeller);
        System.out.println("Inseted! New seller id = " + newSeller.getId());

        System.out.println("\n==== TEST 5: Seller Update ====");
//        Seller newSeller2 = new Seller(18, "Greg2", "grteg@hmail.com", new Date(), 3500.0, new Department(2, null));
        seller = sellerDao.findById(1);
        seller.setName("Joao da Vila");
        sellerDao.update(seller);

    }
}
