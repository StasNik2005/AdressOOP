package com.company;

public class Address {
    private String index;
    private String city;
    private String country;
    private String street;
    private String house;
    private String apartment;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        //System.out.println("\n"+index);
        int digits = 0;
        if (index.length() == 5) {
            //  System.out.println("Lenghs is 5 chars");
            if (index.charAt(0) != '0') {
                //      System.out.println("Индекс начинается не с нуля");
                for (int i = 0; i < index.length(); i++) {
                    if (Character.isDigit(index.charAt(i))) {
                        //   System.out.println("Digit");
                        digits++;
                    } else {
                        this.index = "00000";
                        //  System.out.println("Not digit");
                    }
                }
                if (digits == 5) {
                    this.index = index;
                }
            } else {
                this.index = "00000";
                //    System.out.println("0 it's first");
            }
        } else {
            this.index = "00000";
            //System.out.println("Bigger or smaller than 5 chars");
        }
    }


    public String getCity() {

        return city;
    }

    public String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void setCity(String city) {
        this.city = capitalizeFirstLetter(city);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = capitalizeFirstLetter(country);
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {
        for (int i = 0; i < street.length(); i++) {
            if (Character.isUpperCase(street.charAt(i))) {
                this.street = street;
                break;
            } else {
                this.street = "";
            }
        }
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        if (correctHouseAptNumber(house, true))
            this.house = house;
    }

    private boolean correctHouseAptNumber(String house, boolean withletters) {
        //     System.out.println("\n"+house);
        String digits = "0123456789";
        String letters = "ABCDEFJHIGKLMNOPQRSTUWVXYZabcdefjhigklmnopqrstuwvxyz/";
        if (Character.isDigit(house.charAt(0))) {
            for (int i = 0; i < house.length(); i++) {
                if (digits.indexOf(house.charAt(i)) != -1) {
                    //   System.out.println("YES!!!");
                    if (withletters)
                        for (int j = 0; j < house.length(); j++) {
                            if (letters.indexOf((house.charAt(j))) != -1) {
                                //           System.out.println("yes!!!");
                                return true;
                            }
                        }
                    else
                        return true;
                    break;
                } else {
                    //  System.out.println("NO!!!");
                }
            }
        }
        return false;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        if (correctHouseAptNumber(apartment, false))
            this.apartment = apartment;
    }

    public Address() {
    }

    public Address(String index, String city, String country, String street, String house, String apartment) {
        this.setIndex(index);
        this.setCity(city);
        this.setCountry(country);
        this.setStreet(street);
        this.setHouse(house);
        this.setApartment(apartment);
    }


    @Override
    public String toString() {
        return "Address{" +
                "index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}

/*
        int chislo = 0;
        if(index.length()==5)
        {
            for (int i = 0; i < index.length(); i++) {
                if(Character.isDigit(index.charAt(i)) && index.charAt(0) != '0'){
                    chislo++;
                }
            }
            if(chislo == index.length()){
                this.index = index;
            }else{
                this.index = "00000";
            }
        }
        else{
            this.index = "00000";
        }
*/