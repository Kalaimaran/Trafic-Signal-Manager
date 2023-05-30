package Trafic;

import java.util.*;

public class User extends Thread{
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
         System.out.print("Enter the number of ways: ");
         int n = scanner.nextInt();

         if (n < 2 || n > 4) {
             System.out.println("Invalid input");
             return;
         }
        List<Signals> t=new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            t.add(new Signals("T" + i));
        }

        Manager manager =  new Manager(n,t,0); 
        manager.start();
        System.out.println("Initial State");
        manager.print();
        while (true) {
            try {
            	Thread.sleep(10000);
                manager.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
