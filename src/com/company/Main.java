package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.*;
import com.company.repositories.interfaces.*;

public class Main {
    //The main method is the entry point from which the program starts executing
    public static void main(String[] args)
    //String args are the command line arguments that the application starts with.
    {
        IDB db = new PostgresDB();
        IOrderRepo repo = new OrderRepo(db);
        IMedicamentRepo repo1 = new MedicamentRepo(db);
        IBindRepo repo2=new BindRepo(db);
        MyApplication app = new MyApplication(repo,repo1,repo2);
        app.start();
    }
}