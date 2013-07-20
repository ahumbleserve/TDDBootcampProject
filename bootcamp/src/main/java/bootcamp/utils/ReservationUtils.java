/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.utils;

/**
 *
 * @author Administrador
 */
public class ReservationUtils {
    
    public static String WEEKEND_SUNDAY = "(sun)"; 
    public static String WEEKEND_SATURDAY = "(sat)"; 
    
    public static boolean isWeekend(String day){
    
        if(null != day && (day.contains(WEEKEND_SUNDAY) || day.contains(WEEKEND_SATURDAY))){
            return true;
        }
        return false;
    }
    
}
