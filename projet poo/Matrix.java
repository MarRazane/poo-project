public class Matrix extends AbstractMatrix {
    @Override
    public AbstractMatrix Add(AbstractMatrix M) {
        Matrix A = this;
        if (M.ncolomn != A.nline || M.nline != A.ncolomn)
            throw new RuntimeException("change matrix dimensions plz!!");
        AbstractMatrix C;
        C = new AbstractMatrix(nline, ncolomn) {
            @Override
            public AbstractMatrix Add(AbstractMatrix M) {
                return M;
            }

            @Override
            public AbstractMatrix Multiply(AbstractMatrix M) {
                return M;
            }
        };
        for (int i = 0; i < nline; i++)
            for (int j = 0; j < ncolomn; j++)
                C.data[i][j] = A.data[i][j] + M.data[i][j];
        return C;
    }

    @Override
    public AbstractMatrix Multiply(AbstractMatrix M) {
        Matrix A = this;
        if (A.ncolomn != M.nline)
            throw new RuntimeException("change matrix dimensions plz !!");
        AbstractMatrix C = new AbstractMatrix(A.nline, M.ncolomn) {
            @Override
            public AbstractMatrix Add(AbstractMatrix M) {
                return M;
            }

            @Override
            public AbstractMatrix Multiply(AbstractMatrix M) {
                return M;
            }
        };
        for (int i = 0; i < C.nline; i++)
            for (int j = 0; j < C.ncolomn; j++)
                for (int k = 0; k < A.ncolomn; k++)
                    C.data[i][j] += (A.data[i][k] * M.data[k][j]);
        return C;
    }


}
