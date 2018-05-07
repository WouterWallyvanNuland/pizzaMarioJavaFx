package dal;

import java.sql.CallableStatement;
import java.sql.Connection;

public final class Proc {
    public static void Execute(IExcecuteQueryHandler handler){
        try (
                Connection con = DbConn.connect();
                CallableStatement cmd = con.prepareCall(handler.GetSpName()))
        {
            boolean success = cmd.execute();
            if (success) {
                handler.ProcessResult(cmd.getResultSet());
            }
            else{
                System.out.println("something went wrong with the database");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

