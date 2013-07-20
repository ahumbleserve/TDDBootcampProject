/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.entities;

/**
 *
 * @author Administrador
 */
public class Hotel {
    
    private int id;
    private String name;
    private int stars;
    private Rate regularClientRate;
    private Rate loyalClienteRate;

    public Hotel(int id, String name, int stars, Rate regularClientRate, Rate loyalClienteRate) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.regularClientRate = regularClientRate;
        this.loyalClienteRate = loyalClienteRate;
    }

    
    public Rate getLoyalClienteRate() {
        return loyalClienteRate;
    }

    public void setLoyalClienteRate(Rate loyalClienteRate) {
        this.loyalClienteRate = loyalClienteRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rate getRegularClientRate() {
        return regularClientRate;
    }

    public void setRegularClientRate(Rate regularClientRate) {
        this.regularClientRate = regularClientRate;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  name ;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        return hash;
    }
    
    
}
