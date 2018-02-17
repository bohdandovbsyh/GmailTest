package testdata.parsers;

import org.apache.commons.io.FilenameUtils;
import testdata.parsers.csvparsers.UserCsvParser;
import testdata.parsers.xmlparsers.UserXmlParser;
import testdata.xmlmodels.User;

import java.util.List;

public class UserParserFactory {
    public static List<User> createUsers(String filePath) {
        switch (FilenameUtils.getExtension(filePath)) {
            case "xml": {
                return UserXmlParser.unmarshalUser(filePath);
            }
            case "csv": {
                return UserCsvParser.parseUserCsv(filePath);
            }
            default: {
                throw new RuntimeException();
            }
        }

    }
}