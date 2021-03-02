package dz.walid.masant.main.model;

/**
 * Created by Walid on 28/02/2021.
 */
public class BloodGroup {

    private int father_bg;
    private int mother_bg;

    public void setFatherBg(int f_bg) {
        this.father_bg = f_bg;
    }

    public void setMotherBg(int m_bg) {
        this.mother_bg = m_bg;
    }

    //A = 0; B = 1; AB = 2; O = 3

    public int getChildBg() {

        int child_bg = -1;

        if ((father_bg == 0) && (mother_bg == 0))
            child_bg = 0;
        if ((father_bg == 0) && (mother_bg == 1))
            child_bg = 0;
        if ((father_bg == 0) && (mother_bg == 2))
            child_bg = 2;
        if ((father_bg == 0) && (mother_bg == 3))
            child_bg = 0;
        if ((father_bg == 1) && (mother_bg == 0))
            child_bg = 2;
        if ((father_bg == 1) && (mother_bg == 1))
            child_bg = 1;
        if ((father_bg == 1) && (mother_bg == 2))
            child_bg = 2;
        if ((father_bg == 1) && (mother_bg == 3))
            child_bg = 1;
        if ((father_bg == 2) && (mother_bg == 0))
            child_bg = 2;
        if ((father_bg == 2) && (mother_bg == 1))
            child_bg = 2;
        if ((father_bg == 2) && (mother_bg == 2))
            child_bg = 2;
        if ((father_bg == 2) && (mother_bg == 3))
            child_bg = 2;
        if ((father_bg == 3) && (mother_bg == 0))
            child_bg = 0;
        if ((father_bg == 3) && (mother_bg == 1))
            child_bg = 1;
        if ((father_bg == 3) && (mother_bg == 2))
            child_bg = 0;
        if ((father_bg == 3) && (mother_bg == 3))
            child_bg = 3;

        return child_bg;

    }


}
