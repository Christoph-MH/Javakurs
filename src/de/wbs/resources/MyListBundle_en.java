package de.wbs.resources;

import java.util.ListResourceBundle;

public class MyListBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] bundle = new Object[][]{
                {"wert", "\n\t\ta String"}
        };
        return bundle;
    }
}
