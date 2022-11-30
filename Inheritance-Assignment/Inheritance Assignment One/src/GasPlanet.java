import java.awt.*;

public class GasPlanet extends Planet {

    private boolean hasRings;
    private Color color;

    GasPlanet(int orbitTime, String designation, boolean hasRings, Color color) {

        super(orbitTime, designation);
        this.hasRings = hasRings;
        this.color = color;

    }

    public boolean isHasRings() {

        return hasRings;

    }

    public void setHasRings(boolean hasRings) {

        this.hasRings = hasRings;

    }

    public Color getColor() {

        return color;

    }

    public void setColor(Color color) {

        this.color = color;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof GasPlanet) {

            GasPlanet other = (GasPlanet)obj;

            if (this.hasRings == other.hasRings && this.color.equals(other.color) &&
                this.getOrbitTime() == other.getOrbitTime() && this.getDesignation().equals(other.getDesignation()) &&
                this.getMoons().equals(other.getMoons())) {

                return true;

            }

        }

        return false;

    }

    public String toString() {

        return "Gas Planet[Has Rings:" + hasRings + ", Color:" + color + "]";

    }

}
