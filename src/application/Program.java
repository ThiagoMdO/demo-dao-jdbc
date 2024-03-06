package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args){

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

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

        System.out.println("\n==== TEST 4: Seller insert ====");
        Seller newSeller = new Seller(null, "Greg", "grteg@hmail.com", new Date(), 3000.0, new Department(2, null));
//        sellerDao.insert(newSeller);
        System.out.println("Inseted! New seller id = " + newSeller.getId());

        System.out.println("\n==== TEST 5: Seller update ====");
//        Seller newSeller2 = new Seller(18, "Greg2", "grteg@hmail.com", new Date(), 3500.0, new Department(2, null));
        seller = sellerDao.findById(1);
        seller.setName("Joao da Vila");
        sellerDao.update(seller);
        System.out.println("The seller was updated with success");

        System.out.println("\n==== TEST 6: Seller delete ====");
//        sellerDao.deleteById(3);
        System.out.println("The seller was deleted with success");


        // Department

        System.out.println("\n==== TEST 07: Department findById ====");
        Department department1 = departmentDao.findById(2);
        System.out.println(department1);

        System.out.println("\n==== TEST 08: Department findAll ====");
        List<Department> departmentList = departmentDao.findAll();
        for (Department dep : departmentList){
            System.out.println(dep);
        }

        System.out.println("\n==== TEST 09: Department insert ====");
        Department newDepartment = new Department();
        newDepartment.setName("Tools");
//        departmentDao.insert(newDepartment);
        System.out.println("Success to add new department");


        System.out.println("\n==== TEST 10: Department update ====");
        Department updateDepartment = departmentDao.findById(1);
        updateDepartment.setName("PCS");
//        departmentDao.update(updateDepartment);
        System.out.println("Success to update department");


        System.out.println("\n==== TEST 10: Department deleteById ====");
        departmentDao.deleteById(6);
        System.out.println("Success to delete department");


    }
}
