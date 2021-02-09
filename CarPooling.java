/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpooling_package;
import java.io.IOException;
import java.util.*;
/**
 *
 *
 */
/** This exception catcher class will be used to throw messages to any exceptions in the system */
 class ExceptionCatcher extends Exception{
    public ExceptionCatcher(String message)
    {
        super(message);
    }
}
public class CarPooling {
    
    public static void main(String[] args)
    {
        Passenger passenger[] = new Passenger[4];
        //polymorphism
        
        passenger[0]= new subscriber();
        passenger[2]= new subscriber();
        passenger[1]= new nonsubscriber();
        passenger[3]= new nonsubscriber();
        
        ArrayList<Route> routes = new ArrayList<>();
        Route route;
        
        route = new Route("Giza","Cairo",3);
        routes.add(route);
         route = new Route("Abbasiya","Ramses",1);
        routes.add(route);
         route = new Route("Alf Maskan","Abassiya",2);
        routes.add(route);
         route = new Route("Qalyoub","Cairo",3);
        routes.add(route);
       
        
        ArrayList<Car> cars = new ArrayList<>();
        Car car;
        
        car = new Car(3,4,"James Gosling",routes.get(0));
        cars.add(car);
        car = new Car(2,3,"Guido van Rossum",routes.get(1));
        cars.add(car);
        car = new Car(1,2,"Bjarne Stroustrup",routes.get(2));
        cars.add(car);
        car = new Car(5,4,"Dennis Ritchie",routes.get(3));
        cars.add(car);
        
        
        System.out.print("Here's a list of available cars \n");
       for (int i=0; i<cars.size(); i++)
       {
          cars.get(i).showCarInfo();
       }
       
        for (int i=0; i<50; i++)
        {
            System.out.print("--");
        }
        System.out.println("");
       passenger[0].PurchaseTicket(cars.get(0));
       passenger[0].ticket.showTicketInfo();
         for (int i=0; i<50; i++)
        {
            System.out.print("--");
        }
         System.out.println("");
         
         
       passenger[0].Subscribe(30, 20); //exception (user defined)
        for (int i=0; i<50; i++)
        {
            System.out.print("--");
        }
         System.out.println("");
         
       
       passenger[1].SearchRoute("Giza","Cairo");
       for (int i=0; i<50; i++)
        {
            System.out.print("--");
        }
         System.out.println("");
       
       passenger[1].report(" "); //exception (built in)
        for (int i=0; i<50; i++)
        {
            System.out.print("--");
        }
         System.out.println("");
         
       passenger[2].report("A good service thanks!");
        for (int i=0; i<50; i++)
        {
            System.out.print("--");
        }
         System.out.println("");
       
       
    passenger[3].PurchaseTicket(cars.get(3)); //purchasing a ticket for a non subsriber
    System.out.println("");
    passenger[3].ticket.showTicketInfo();
    
    System.out.println("");
    passenger[3].Subscribe(20, 30);
    System.out.println("");
    passenger[3].ticket.showTicketInfo(); //after 
    
         
         
    }
    
        
    
}

/** the main Route class in the system */
 class Route 
{
    protected String FromLocation;
    protected String ToLocation;
    private int RouteDegree; //if its 1 the Route is long, 2 it's not really long, 3 its long.
    /**A linked list for the departure locations to store in the system*/
    public static LinkedList<String> FromLocations = new LinkedList<String>();
     /**A linked list for the arrival locations to store in the system*/
    public static LinkedList<String> ToLocations = new LinkedList<String>();

    /** default constructor used to create an instance */
    public Route(String FromLocation, String ToLocation, int RouteLength) {
        this.FromLocation = FromLocation;
        this.ToLocation = ToLocation;
        this.RouteDegree = RouteLength;
       FromLocations.add(FromLocation);
       ToLocations.add(ToLocation);
    }
     
     public Route()
     {
         this.FromLocation="";
         this.ToLocation="";
         this.RouteDegree=0;
     }

  
    
    //final setters and getters to not ovveride 
      /** @return the departure location */
       public String getFromLocation() {
        return FromLocation;
    }

    /** @return the arrival location */ 
    public final String getToLocation() {
        return ToLocation;
    }
    public final void setToLocation(String ToLocation) {
        this.ToLocation = ToLocation;
    }
/** @return the RouteDegree location */
    public final int getRouteDegree() {
        return RouteDegree;
    }

    public void setRouteDegree(int RouteDegree) {
        this.RouteDegree = RouteDegree;
    }
  
 //end of Route class   
}


/** main class to handle cars in the system*/
 class Car {
    /** incrementing 8 to  909 just to look like a cool Car code*/
  private static int ID=8;
  public  int carCode =909;
  private int TripsPerDay;
  private int MaxCap;
  private String DriverName;
  private Route CarRoute;

    public Car(int TripsPerDay, int MaxCap, String DriverName, Route CarRoute) {
        this.TripsPerDay = TripsPerDay;
        this.MaxCap = MaxCap;
        this.DriverName = DriverName;
        this.CarRoute = CarRoute;
        ID+=8;
        ID += carCode;
        carCode = ID;
    }
/**shows the Car information */
    public void showCarInfo()
    {
    System.out.println("*****Car Information:*****");
    System.out.println("Car code is: " + " " + carCode);
    System.out.println("Car Maximum capacity:" + " " + MaxCap);
    System.out.println("Driven by captian:" + " " + DriverName);
    System.out.println("Car line:" + " " + "From"+ " " + CarRoute.getFromLocation() +  " " +  "To" + " " + CarRoute.getToLocation());
    
    }
    
    public void getcarCode() {
        System.out.println(carCode);
    }
    /** if a captain wanted to change his Route we use this function */
    public void ChangeRoute(Route CarRoute) {
        this.CarRoute = CarRoute;
    }
    
    

/** @return the Car's trips per day*/
    public int getTripsPerDay() {
        return TripsPerDay;
    }

    public void setTripsPerDay(int TripsPerDay) {
        this.TripsPerDay = TripsPerDay;
    }
/** @reutrn the car's maximum capacity */
    public int getMaxCap() {
        return MaxCap;
    }

    public void setMaxCap(int MaxCap) {
        this.MaxCap = MaxCap;
    }
/** @return the captain's of the Car name */
    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String DriverName) {
        this.DriverName = DriverName;
    }
 /** @return the Car's Route */ 
    public Route getCarRoute() {
        return CarRoute;
    }
   
}


/** main Ticket class to handle the price calculation and ticketing system */
 class Ticket 
{
    private Car Car;
    private float price;
    private static int ID=19;
  public  int TicketCode =782;
  public boolean SubscriberTicket;
public static float discount=0.5f;

    public Ticket(Car Car) {
        this.Car = Car;
        ID+=8;
        ID += TicketCode;
        TicketCode = ID;
        SubscriberTicket=false;
    }
    
    private void CalcPrice()
    {
        switch (Car.getCarRoute().getRouteDegree()) {
            case 1:
                this.price=50f;
                break;
            case 2:
                this.price=70f;
                break;
            case 3:
                this.price=100f;
                break;
            default:
                System.out.println("Error please insert a vaild route degree! \t (1-3)");
                break;
        }
        if (SubscriberTicket)
        {
            price-=discount*price;
        }
    }
    
    public void showTicketInfo()
    {
        CalcPrice();
        System.out.println("*****Ticket Information:*****");
    System.out.println("Ticket code is: " + " " + TicketCode);
    System.out.println("Ticket Price: " + " " + price);
    System.out.println("Car driven by captian:" + " " + Car.getDriverName());
    System.out.println("Car line:" + " " + "From"+ " " + Car.getCarRoute().getFromLocation() +  " " +  "To" + " " + Car.getCarRoute().getToLocation());
    }
    

}

/** abstract class for the Passenger, we will inherit the subscriber and the non subscriber from it */
 abstract class Passenger {
    
    protected Ticket ticket;
    protected boolean Subscriber;
    protected final float SubscribeFeesTax;
    protected String review;
    
    
    public Passenger()
    {
       SubscribeFeesTax=80f; 
    }
    
    //abstract method
    public abstract void PurchaseTicket(Car car);
    
    //final method, same for both children 
    public final void SearchRoute(String FromLocation, String ToLocation)
    {
        boolean LocationFound = false;
        for (int i=0; i<Route.FromLocations.size(); i++)
            if (FromLocation.equals(Route.FromLocations.get(i)))
                for (String To : Route.ToLocations) {
                    if(ToLocation.equals(Route.ToLocations.get(i)))
                        LocationFound = true;
        }
        
        System.out.println((LocationFound)?"This route is available in our system": "Sorry, we don't support this route yet");
    }
    
    /** the function that handles the subscribing process and calculates the fees
    * @param first User age
    * @param second Number of trips
     */
    public final void Subscribe(int UserAge, int NoOfTrips)
    {
        
        boolean isSubscriber = false;
        try {
            if (Subscriber)
            {      isSubscriber=true;
            throw new ExceptionCatcher("You are already a subscriber! \n");
            }
        }
        catch (ExceptionCatcher AlSubscriber) {
            System.out.print("Error!" + AlSubscriber.getMessage());
            
        }
       if (!isSubscriber)
       {
         float fees = ((UserAge /9) + NoOfTrips) * SubscribeFeesTax; //Calculated Data Memeber
        Subscriber = ticket.SubscriberTicket=true;
        System.out.println("Congratulations you are now a subscriber! Total Price: " + fees );
        
      
    }
    }
    public final void unsubscribe()
    {
        boolean isSubscriber = true;
        try {
            if (!Subscriber)
            {    
                isSubscriber=false;
            
            throw new ExceptionCatcher("You are already a non subscriber!");
            }
        }
        catch (ExceptionCatcher AlSubscriber) {
            System.out.print("Error!" + AlSubscriber.getMessage());
            
        }
        if (!isSubscriber)
        {
            System.out.println("You are now unsubscribed");
            ticket.SubscriberTicket=false;
            
        }
    }
    
    
 
    public final void report(String Message)
    {
        boolean textNotFound = false;
        try {
            if (Message.equals(" "))
            {     textNotFound=true;
            throw new IOException("No Input is found, please type a message! \n" );
        }}
        catch (IOException NoMessage)
        {
         System.out.println("Error!!" + NoMessage.getMessage());
         
        }
       if (!textNotFound)
        {
     
            this.review=Message;
            System.out.println("Thanks for taking time to share a report, Our agents will reply as soon as possible");
        }
    }
    
}
// inheritance 

/** the child class of a subscribed Passenger */
 class subscriber extends Passenger {
private final float discount;

public subscriber()
{
    discount = 0.5f;
    Ticket.discount = this.discount;
    Subscriber=true;
} 
@Override
    public void PurchaseTicket(Car car)
    {
       
        ticket = new Ticket(car);
        ticket.SubscriberTicket=(Subscriber)?true:false;
        
        
    }
   
}
/** the child class of a NON-subscribed Passenger */
 class nonsubscriber extends Passenger
{
 nonsubscriber()
 {
     Subscriber=false;
 }
    @Override
    public void PurchaseTicket(Car car) {
        ticket = new Ticket(car);
        ticket.SubscriberTicket=(Subscriber)?true:false;
        System.out.print("Ticket Purchased with Sucessfully!, to get 50$ off the next time you purchase, make sure that you are a subscriber");
       
    }
    
}


/** interface class for those who want to work in the system */
interface captains {
    public void showmessage();
}
class worker implements captains {
    
    @Override
    public void showmessage() {
       System.out.print("To work with us, please contact us at: carpooling@fcisasu.com");
    }
}

    