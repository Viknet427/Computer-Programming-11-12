import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class Tests {

    Planet planet;
    Planet planet1;
    Planet planet2;
    Planet planet3;
    Planet planet4;
    Planet planet5;
    Moon moon;
    Moon moon1;
    Moon moon2;
    Moon moon3;

    @Before
    public void setup() {

        planet = new GasPlanet(4332, "Jupiter", false, Color.orange);
        planet1 = new GasPlanet(4332, "Jupiter", false, Color.orange);
        planet2 = new RockPlanet(686, "Mars", false);
        planet3 = new RockPlanet(686, "Mars", false);
        planet4 = new GasPlanet(10755, "Saturn", true, Color.yellow);
        planet5 = new RockPlanet(365, "Earth", true);

        moon = new Moon(planet, 981, true, "Io");
        moon1 = new Moon(planet, 981, true, "Io");
        moon2 = new Moon(planet1, 981, true, "Io");
        moon3 = new Moon(planet4, 16, false, "Titan");

    }

    @Test
    public void testGasPlanetEquals() {

        //Check if the equal method can tell if two planets are equal
        Assert.assertEquals(planet, planet1);
        //Check if the equal method can differentiate between different class
        Assert.assertNotEquals(planet, planet2);
        //Check if the equal method can tell if the orbitTime, designation, hasRings, and color are different
        Assert.assertNotEquals(planet, planet4);

    }

    @Test
    public void testRockPlanetEquals() {

        //Check if the equal method can tell if two planets are equal
        Assert.assertEquals(planet2, planet3);
        //Check if the equal method can differentiate between different class
        Assert.assertNotEquals(planet2, planet4);
        //Check if the equal method can tell if the orbitTime, designation, and habitable are different
        Assert.assertNotEquals(planet2, planet5);

    }

    @Test
    public void testMoonEquals() {

        //Check if the equal method can tell if two moons are equal
        Assert.assertEquals(moon, moon1);
        //Check if the equal method can tell if two planets are equal and moons are equal
        Assert.assertEquals(moon, moon2);
        //Check if the equal method can tell if the orbitTime, planet, atmosphere, and designation are different
        Assert.assertNotEquals(moon, moon3);

    }

}
