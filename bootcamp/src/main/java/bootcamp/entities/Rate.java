/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.entities;

/**
 *
 * @author Administrador
 */
public class Rate {

    private Float weekdayRate;
    private Float weekendRate;
    
    public Rate(Float weekdayRate, Float weekendRate) {
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }
    
    public Float getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(Float weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

    public Float getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(Float weekendRate) {
        this.weekendRate = weekendRate;
    }
    
}
