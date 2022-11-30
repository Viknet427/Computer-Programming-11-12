public class RockPlanet extends Planet {

    private boolean habitable;

    RockPlanet(int orbitTime, String designation, boolean habitable) {

        super(orbitTime, designation);
        this.habitable = habitable;

    }

    public boolean isHabitable() {

        return habitable;

    }

    public void setHabitable(boolean habitable) {

        this.habitable = habitable;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof RockPlanet) {

            RockPlanet other = (RockPlanet)obj;

            if (this.habitable == other.habitable && this.getOrbitTime() == other.getOrbitTime() &&
                this.getDesignation().equals(other.getDesignation()) && this.getMoons().equals(other.getMoons())) {

                return true;

            }

        }

        return false;

    }

    public String toString() {

        return "Rock Planet[Habitable: " + habitable + "]";

    }

}
