package dz.walid.masant.main.model;

/**
 * Created by Walid on 28/02/2021.
 */
public class Imc {
    final private float max_skinny = 18.5f;
    final private float max_normal = 24.9f;
    final private float max_over_weight = 29.9f;

    private float imc_c;

    public void setImc(float imc) {
        this.imc_c = imc;
    }

    public int getResult() {

        int b = -1;

        if (this.imc_c <= max_skinny)
            b = 0;

        if ((this.imc_c > max_skinny) && (this.imc_c <= max_normal))
            b = 1;

        if ((this.imc_c > max_normal) && (this.imc_c <= max_over_weight))
            b = 2;

        if (this.imc_c > max_over_weight)
            b = 3;

        return b;
    }
}
