/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.service;

import bootcamp.entities.Hotel;
import bootcamp.entities.Rate;
import bootcamp.utils.HotelConstants;
import bootcamp.utils.ReservationUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Administrador
 */
public class HotelRoomReservationServiceImpl implements HotelRoomReservationService{

    public String obtainTheCheapestHotel (String input){
    
        //Obtain the hotels
        Set<Hotel> hotelList = new HashSet<Hotel>(); 
        hotelList.add(new Hotel(1, "Lakewood", HotelConstants.THREE_STAR, new Rate(new Float(110),new Float(90)), new Rate(new Float(80),new Float(80))));
        hotelList.add(new Hotel(2, "Bridgewood", HotelConstants.FOUR_STAR, new Rate(new Float(160),new Float(60)), new Rate(new Float(110),new Float(50))));
        hotelList.add(new Hotel(3, "Ridgewood", HotelConstants.FIVE_STAR, new Rate(new Float(220),new Float(150)), new Rate(new Float(100),new Float(40))));
        
        //Obtain data from requisition
        String costumer = input.substring(0, input.indexOf(":")).trim().toLowerCase();
        String dates = input.substring(input.indexOf(":")+1).trim().toLowerCase();
        
        
        //Resolve the rates per hotel
        Map<Hotel,Float> hotelRate = new HashMap<Hotel,Float>();
        
        for(Hotel hotel : hotelList){
            Float totalPerHotel = 0F;
            for(String date : dates.split(",")){
                if(costumer.equals(HotelConstants.REGULAR_CLIENT)){
                    if(ReservationUtils.isWeekend(date)){
                        totalPerHotel += hotel.getRegularClientRate().getWeekendRate();
                    }else{
                        totalPerHotel += hotel.getRegularClientRate().getWeekdayRate();
                    }
                }else{
                    if(ReservationUtils.isWeekend(date)){
                        totalPerHotel += hotel.getLoyalClienteRate().getWeekendRate();
                    }else{
                        totalPerHotel += hotel.getLoyalClienteRate().getWeekdayRate();
                    }
                }
                hotelRate.put(hotel, totalPerHotel);
            }
        }
        
        String cheapestHotel = obtainTheCheapestHotel(hotelRate);
        
        return cheapestHotel.toString();
    }
    
    public String obtainTheCheapestHotel (Map<Hotel,Float> hotelRate){

        Float cheapestRate = 0F;
        Hotel cheapestHotel = null;
        for(Hotel hotel : hotelRate.keySet()){
            if(cheapestRate.equals(0F)){
                cheapestRate = hotelRate.get(hotel);
                cheapestHotel = hotel;
            }else{
                if(cheapestRate > hotelRate.get(hotel)){
                    cheapestRate = hotelRate.get(hotel);
                    cheapestHotel = hotel;
                }else if(cheapestRate.equals(hotelRate.get(hotel))){
                    if(cheapestHotel.getStars() < hotel.getStars()){
                        cheapestHotel = hotel;
                    }
                }
            }
        }
        
        return cheapestHotel.toString();

    }
    
}
