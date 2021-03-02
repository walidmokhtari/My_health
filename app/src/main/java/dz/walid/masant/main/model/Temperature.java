package dz.walid.masant.main.model;

/**
 * Created by Walid on 28/02/2021.
 */
public class Temperature {

    final private float temp_min_h = 36.1f;
    final private float temp_max_h = 37.8f;
    final private float temp_min_f = 36.3f;
    final private float temp_max_f = 38.0f;

    private char sexe_c;
    private float temp_c;

    public void setSexe(char s) {
        this.sexe_c = s;
    }

    public void setTemp(float temp) {
        this.temp_c = temp;
    }

    public int checkTemp() {
        if (this.sexe_c == 'w') {
            if ((this.temp_c < this.temp_min_f) || (this.temp_c > this.temp_max_f)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if ((this.temp_c < this.temp_min_h)|| (this.temp_c > this.temp_max_h)) {
                return 1;
            } else {
                return 0;
            }
        }
    }


}
