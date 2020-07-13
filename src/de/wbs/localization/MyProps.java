package de.wbs.localization;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

public class MyProps extends PropertyResourceBundle {

    public MyProps(InputStream stream) throws IOException {
        super(stream);
    }
}
