import java.util.Objects;

public class Numbers implements Comparable<Numbers> { //
    Integer n;

    public Numbers(Integer n) {
        this.n = n;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Number n= " + n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return this.n == n;
    }

    @Override
    public int compareTo(Numbers o) {
        int res = this.n - o.n;
        return res;
    }

}
