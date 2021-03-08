package com.company;

import com.company.controllers.*;
import com.company.repositories.interfaces.*;
import java.util.Scanner;


public class MyApplication {
    //This classes(private final) are not visible in their child class due to which are not eligible for overridden
    private final OrderController controller1;
    private final MedicamentController controller2;
    private final BindController controller3;
    private final Scanner scanner;

    public MyApplication(IOrderRepo orderRepo, IMedicamentRepo medicamentRepo,IBindRepo bindRepo) {
        controller1 = new OrderController(orderRepo,medicamentRepo);
        controller2 = new MedicamentController(medicamentRepo);
        controller3 = new BindController(bindRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            //This system out println need to interface between users and project
            System.out.println();
            System.out.println("Welcome to Pharmacy Management System");
            System.out.println("Select option:");//Selecting all options
            System.out.println("1. Get all orders");//To take all orders in this pharmacy
            System.out.println("2. Get order by id");//Take order by special id
            System.out.println("3. Create order");//Creating new order in this pharmacy
            System.out.println("4. Get all medicament");//Show to customers all medicament in this pharmacy
            System.out.println("5. Get medicament by id");//Getting medicament by id
            System.out.println("6. Create medicament");//Creating medicament
            System.out.println("7. Enter medicament to order");//Entering medicament to order of customers
            System.out.println("8. Select all medicament of selected order");//Show to customers all medicament which he or she choose
            System.out.println("9. Update Company by id");//Updating data by id
            System.out.println("0. Exit");//Exiting the program
            System.out.println();
            try {
                System.out.print("Enter option (1-8): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllOrders();
                } else if (option == 2) {
                    getOrder();
                } else if (option == 3) {
                    createOrder();
                }else if (option == 4) {
                    getAllMedicaments();
                }else if (option == 5) {
                    getMedicament();
                }else if (option == 6) {
                    createMedicament();
                }else if (option == 7) {
                    enterMedicamentToOrder();
                }else if (option == 8) {
                    getMedicamentsByCompany();
                }else if (option == 9) {
                    UpdateOrderById();
                }else {

                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*************************");

        }
    }

    private void UpdateOrderById() {
        System.out.println("Enter Order id which you want update");
        Integer id = scanner.nextInt();
        String response = controller1.UpdateOrderById(id);
        System.out.println(response);
    }

    public void enterMedicamentToOrder(){
        System.out.println("Please enter order_id");
        int id1 = scanner.nextInt();
        System.out.println("Please enter med_id");
        int id2 = scanner.nextInt();
        String response = controller3.enterMedicamentToOrder(id1,id2);
        System.out.println(response);
    }


    public void getAllOrders() {
        String response = controller1.getAllOrders();
        System.out.println(response);
    }

    public void getOrder() {
        System.out.println("Please enter needing order id");
        int id = scanner.nextInt();
        String response = controller1.getOrder(id);
        System.out.println(response);
    }

    public void getMedicamentsByCompany() {
        System.out.println("Please enter id of needing order's medicament");
        int id = scanner.nextInt();
        String response = controller1.getMedicamentsByCompany(id);
        System.out.println(response);
    }

    public void createOrder() {
        System.out.println("Please enter order name");
        String name = scanner.next();
        int cost=0;
        String response = controller1.createOrder(name,cost);
        System.out.println(response);
    }


    public void getAllMedicaments() {
        String response = controller2.getAllMedicaments();
        System.out.println(response);
    }

    public void getMedicament() {
        System.out.println("Please enter needing medicament id");
        int id = scanner.nextInt();
        String response = controller2.getMedicament(id);
        System.out.println(response);
    }

    public void createMedicament() {
        System.out.println("Please enter medicament name");
        String name = scanner.next();
        System.out.println("Please enter medicament cost");
        Integer cost = scanner.nextInt();
        System.out.println("Please enter medicament description");
        String description = scanner.next();
        String response = controller2.createMedicament(name,cost,description);
        System.out.println(response);
    }

}