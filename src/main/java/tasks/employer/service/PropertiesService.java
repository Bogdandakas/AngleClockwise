package tasks.employer.service;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class PropertiesService {

    private static final String FILE_NAME = "logger";

    public String get(String key) throws UnsupportedEncodingException {

        ResourceBundle bundle = getBundle(FILE_NAME);
        String value = bundle.getString(key);

        String language = bundle.getLocale().toString();

        if (language.equals("lt") || language.equals("pl")) {
            return new String(value.getBytes("ISO-8859-1"), "windows-1257");
        }

        if (language.equals("ru")) {
            return new String(value.getBytes("ISO-8859-1"), "UTF-8");
        }

        return value;
    }

}