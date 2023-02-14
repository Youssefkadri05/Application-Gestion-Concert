package dao_gestion_concert;


/**
 * Exception spécifique aux problèmes d'accès aux données via un DAO.
 * @author Eric
 */
public class DAOException extends java.lang.Exception {
    
	private static final long serialVersionUID = 309200220164832142L;

	public DAOException() {
        super();
    }
    
    public DAOException(String message) {
        super(message);
    }
}