
public class Carga {
    private float base;
    private byte exp;
    private float value;

    public Carga(float base, byte exp) {
        this.base = base;
        this.exp = exp;

        value = (exp < 0) ? powI(base, exp) : powS(base, exp);
    }

    private float powS(float q1, byte exp) {
        for (int i = exp; exp >= 1; exp--)
            q1 *= 10;

        return (float) q1;
    }

    private float powI(float q1, byte exp) {
        exp *= -1;
        for (int i = exp; exp >= 1; exp--)
            q1 /= 10;

        return (float) (q1);
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getBase() {
        return (base);
    }

    public byte getExp() {
        return (exp);
    }

    public float getValue() {
        return (value);
    }

    public String getDetails() {
        return "%.2fx10^%d C\n";
    }
}