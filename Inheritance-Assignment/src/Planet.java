import java.util.ArrayList;
import java.util.List;

public class Planet {

    private int orbitTime;
    private ArrayList<Moon> moons;
    private String designation;

    Planet() {

        orbitTime = 0;
        this.moons = new ArrayList<>();
        designation = "";

    }

    Planet(int orbitTime, String designation) {

        this.orbitTime = orbitTime;
        this.moons = new ArrayList<>();
        this.designation = designation;

    }

    public String getDesignation() {

        return designation;

    }

    public void setDesignation(String designation) {

        this.designation = designation;

    }

    public int getOrbitTime() {

        return orbitTime;

    }

    public void setOrbitTime(int orbitTime) {

        this.orbitTime = orbitTime;

    }

    public void addMoon(Moon moon) {

        this.moons.add(moon);

    }

    public List<Moon> getMoons() {

        return moons;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Planet) {

            Planet other = (Planet)obj;
            if (this.orbitTime == other.orbitTime && this.designation.equals(other.designation) && this.moons.equals(other.moons)) {

                return true;

            }

        }

        return false;

    }

    public String toString() {

        return "Planet[Orbit time: " + orbitTime + ", Moons: " + moons + ", Designation: " + designation + "]";

    }

}
