package service.so;

import dao.GenericDao;
import dao.impl.GenericDaoImpl;
import java.sql.SQLException;
import database.connection.ConnectionFactory;
import java.sql.SQLIntegrityConstraintViolationException;

public abstract class AbstractGenericOperation {

    protected GenericDao genericDao;

    public AbstractGenericOperation() {
        genericDao = (GenericDao) new GenericDaoImpl();
    }

    public final Object execute(Object entity) throws Exception {
        try {
            preconditions(entity);
            startTransaction();
            Object result = executeOperation(entity);
            commitTransaction();
            return result;
        } catch (Exception ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                throw new Exception("Operacija ne moze da se izvrsi!");
            }
            ex.printStackTrace();
            rollbackTransaction();
            throw new Exception(ex.getMessage());
        }
    }

    protected abstract void preconditions(Object entity) throws Exception;

    private void startTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().setAutoCommit(false);
    }

    protected abstract Object executeOperation(Object entity) throws Exception;

    private void commitTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().commit();
    }

    private void rollbackTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().rollback();
    }

}
