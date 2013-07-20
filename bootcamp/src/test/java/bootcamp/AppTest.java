package bootcamp;

import bootcamp.entities.Hotel;
import bootcamp.entities.Rate;
import bootcamp.service.HotelRoomReservationService;
import bootcamp.service.HotelRoomReservationServiceImpl;
import bootcamp.utils.HotelConstants;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    public void shouldResolveTheCheapestHotelPassingAMapOFHotelFloat(){
        
        HotelRoomReservationServiceImpl service = new HotelRoomReservationServiceImpl();
        
        Hotel hotel1 = new Hotel(1, "Lakewood", HotelConstants.THREE_STAR, new Rate(new Float(110),new Float(90)), new Rate(new Float(80),new Float(80)));
        Hotel hotel2 = new Hotel(2, "Bridgewood", HotelConstants.FOUR_STAR, new Rate(new Float(160),new Float(60)), new Rate(new Float(110),new Float(50)));
        Hotel hotel3 = new Hotel(3, "Ridgewood", HotelConstants.FIVE_STAR, new Rate(new Float(220),new Float(150)), new Rate(new Float(100),new Float(40)));
        
        Map<Hotel,Float> hotelRate = new HashMap<Hotel,Float>();
        
        hotelRate.put(hotel1, 102F);
        hotelRate.put(hotel2, 1049F);
        hotelRate.put(hotel3, 103F);
        
        String  hotel = service.obtainTheCheapestHotel(hotelRate);
        assertEquals("Lakewood", hotel);
    }
 
    public void shouldResolveTheCheapestHotelPassingAMapOFHotelFloatWithTheSameValue(){
        
        HotelRoomReservationServiceImpl service = new HotelRoomReservationServiceImpl();
        
        Hotel hotel1 = new Hotel(1, "Lakewood", HotelConstants.THREE_STAR, new Rate(new Float(110),new Float(90)), new Rate(new Float(80),new Float(80)));
        Hotel hotel2 = new Hotel(2, "Bridgewood", HotelConstants.FOUR_STAR, new Rate(new Float(160),new Float(60)), new Rate(new Float(110),new Float(50)));
        Hotel hotel3 = new Hotel(3, "Ridgewood", HotelConstants.FIVE_STAR, new Rate(new Float(220),new Float(150)), new Rate(new Float(100),new Float(40)));
        
        Map<Hotel,Float> hotelRate = new HashMap<Hotel,Float>();
        
        hotelRate.put(hotel1, 463F);
        hotelRate.put(hotel2, 463F);
        hotelRate.put(hotel3, 463F);
        
        String  hotel = service.obtainTheCheapestHotel(hotelRate);
        assertEquals("Ridgewood", hotel);
    }
 
    
    public void shouldObtainTheCheapestHotelPassingAnStringWithClientTypeRegularAndAListOfDateMonTuesWed()
    {
        HotelRoomReservationService service = new HotelRoomReservationServiceImpl();
        String hotel = service.obtainTheCheapestHotel("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
        assertEquals("Lakewood", hotel);
    }

    public void shouldObtainTheCheapestHotelPassingAnStringWithClientTypeRegularAndAListOfDateFriSatSun()
    {
        HotelRoomReservationService service = new HotelRoomReservationServiceImpl();
        String hotel = service.obtainTheCheapestHotel("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)");
        assertEquals("Bridgewood", hotel);
    }

    public void shouldObtainTheCheapestHotelPassingAnStringWithClientTypeRewardsAndAListOfDateThurFriSat()
    {
        HotelRoomReservationService service = new HotelRoomReservationServiceImpl();
        String hotel = service.obtainTheCheapestHotel("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
        assertEquals("Ridgewood", hotel);
    }
    
}
