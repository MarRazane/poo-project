import java.util.stream.IntStream;

public abstract class AbstractMatrix {
    public double [][] data;
    public int nline,ncolomn;

    public AbstractMatrix(){
        nline = 1;
        ncolomn = 1;
        data = new double[nline][ncolomn];
        int i=0;
        while (i<nline) {
            int j =0;
            while (j<ncolomn) {
                this.data[nline][ncolomn] = 0;
                j++;
            }
            i++;
        }
    }

    public AbstractMatrix(int nline,int ncolomn ){
        nline = nline;
        ncolomn = ncolomn;
        data = new double[nline][ncolomn];
        int i=0;
        while (i<nline) {
            int j =0;
            while (j<ncolomn) {
                this.data[nline][ncolomn] = 0;
                j++;
            }
            i++;
        }
    }
    public int getNline() {
        return nline;
    }
    public int getNcolomn() {
        return ncolomn;
    }
    public double getData(int i, int j) {
        return data[i][j];
    }

    public void setData(int i, int j, double value) {
        this.data[nline][ncolomn] = value;
    }
    void print(){
        IntStream.range(0, nline).forEach(i -> IntStream.range(0, ncolomn).mapToObj(j -> data).forEach(System.out::println));
    }
    public abstract AbstractMatrix Add(AbstractMatrix M);
    public abstract AbstractMatrix Multiply(AbstractMatrix M);
}
