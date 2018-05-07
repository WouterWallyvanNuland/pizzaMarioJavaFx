package dal;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface IExcecuteQueryHandler<T> {
    void ProcessResult(ResultSet rs);
    ArrayList<T> getResults();
    String GetSpName();
}
