package bootcamp;

import bootcamp.service.HotelRoomReservationService;
import bootcamp.service.HotelRoomReservationServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HotelRoomReservationService service = new HotelRoomReservationServiceImpl();
        
        //System.out.println(service.obtainTheCheapestHotel("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"));
        //System.out.println(service.obtainTheCheapestHotel("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"));
        //System.out.println(service.obtainTheCheapestHotel("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)"));
    }
}
