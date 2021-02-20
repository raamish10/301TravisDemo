package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }
    
    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
    }

    @Test
    void testDelete() throws Exception {

        CityList cityList = mockCityList();

        //checks to see if mockcity() worked
        assertEquals(1, cityList.getCities().size());

        //creates a new city and adds it to the list
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        //checks to see if it was added to the list
        assertEquals(2, cityList.getCities().size());

        //deletes the recently added city
        cityList.delete(city);

        //checks to see if the city was deleted
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.hasCity(city));

    }

}
