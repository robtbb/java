
package exceptions;

public class ExceptionLavacao extends RuntimeException {
    
    private static final long sertalVersioUID = 1L;
    
    public ExceptionLavacao(String msg){
        super(msg);
    }
}
