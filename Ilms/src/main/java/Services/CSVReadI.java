package Services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.domain.UserDomain;

public interface CSVReadI {
	List<UserDomain> readCsvUserFile() throws IOException, ParseException, NullPointerException;
}
