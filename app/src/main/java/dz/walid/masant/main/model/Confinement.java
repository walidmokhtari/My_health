package dz.walid.masant.main.model;

/**
 * Created by Walid on 28/02/2021.
 */
public class Confinement {

    final private int confinement_days = 10;
    private int days_since_test;

    public void setNbDays(int nbDays) {
        this.days_since_test = nbDays;
    }

    public int confinementOrNo() {

        if (days_since_test < confinement_days)
            return 1;
        else
            return 0;
    }

    public int daysLeft() {
        return (confinement_days - days_since_test);
    }

}
