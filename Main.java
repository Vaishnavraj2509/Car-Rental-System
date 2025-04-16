import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

class Car 
{
    private String carId;

    private String brand;

    private String model;

    private double basePricePerDay;

    private boolean isAvailable;

    //CONSTRUCTOR

    public Car(String carId, String brand, String model, double basePricePerDay, boolean isAvailable)
    {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;


    }

    public String getCarId()
    {
         return carId;
    }
    public String getBrand()
    {
         return brand;
    }
    public String getModel()
    {
         return model;
    }
    public double calculatePrice(int rentalDays)
    {
         return basePricePerDay * rentalDays;
    }
    public boolean isAvailable()
    {
         return isAvailable;
    }
    public void rent()
    {
        isAvailable = false;
    }
    public void returnCar()
    {
        isAvailable = true;
    }
}

//CUSTOMER CLASS
class Customer
{
    private String customerId;

    private String name;

//CONSTRUCTOR
    public Customer(String customerId, String name)
    {
        this.customerId = customerId; //ASSIGNED VARIABLES
        this.name = name;
    }

    //GETTER AND SETTER VALUES
    public String getCustomerId()
    {
        return customerId;
    }
    public String getname()
    {
        return name;
    }

    //RENTAL CLASS

    class Rental
    {
        private Car car;

        private Customer customer;

        private int days;

        //CONSTRUCTOR
        public Rental(Car car, Customer customer, int days)
        {
            this.car = car;
            this.customer = customer;
            this.days = days;
        }

        //GETTER AND SETTER
        public Car getCar()
        {
            return car;
        }
        public Customer getCustomer()
        {
            return customer;
        }
        public int getDays()
        {
            return days;
        }
    }

    //CAR RENTAL SYSTEM
    class CarRentalSystem
    {
        //ARRAYLIST TO STORE DATA
        private List<Car> cars;

        private List<Customer> customers;

        private List<Rental> rentals;

        public CarRentalSystem()
        {
            cars = new ArrayList<>();
            customers = new ArrayList<>();
            rentals = new ArrayList<>();
        }

        public void addCar(Car car)
        {
            cars.add(car);
        }
        public void addCustomer(Customer customer)
        {
            customers.add(customer);
        }
        public void rentCar(Car car, Customer customer, int days)
        {
            if(car.isAvailable())
            {
                car.rent();
                rentals.add(new Rental(car, customer, days));
            }
            else
            {
                System.out.println("car is not available for rent");
            }
        }

        //RETURN CAR

        public void returnCar(Car car)
        {
            car.returnCar();
            Rental rentalToRemove = null;
            for(Rental rental : rentals)
            {
                rentalToRemove = rental;
                break;
            }
        
        if(rentalToRemove!=null)
        {
            rentals.remove(rentalToRemove);
            System.out.println("car returned successfullu");
        }
        else
        {
            System.out.println("car was not rented");
        }
    }

    //MAIN METHOD MENU

    public void menu()
    {
        Scanner sc= new Scanner(System.in);

        while(true)
        {
            System.out.println("====== Car Rental System ======");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            sc.nextInt();//for a new line
        

        if(choice ==1 )
        {
            System.out.println("\n== Rent a Car ==\n");
            System.out.println("Enter your name : ");
            String customerName = sc.nextLine();

            System.out.println("\n Available Cars : ");
            for(Car car : cars)
            {
                if(car.isAvailable())
                {
                    System.out.println(car.getCarId() + " - " + car.getBrand() + " - " + car.getModel());

                }
            }
            System.out.println("\n Enter the car ID you want to rent :");
            String carId = sc.nextLine();

            System.out.println("Enter the number of days you want to rent :");
            int rentalDays = sc.nextInt();
            sc.nextLine();
        }
    }
}
}
}

