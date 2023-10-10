package editstring;

import models.HistoricalFigure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringSorterIgnoreCase {

    public void sortAlphabeticallyIgnoreCase(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1 == null && s2 == null) {
                    return 0;
                } else if (s1 == null) {
                    return 1;
                } else if (s2 == null) {
                    return -1;
                } else {
                    return s1.compareToIgnoreCase(s2);
                }
            }
        });
    }


    public void sortFiguresByNameIgnoreCase(ArrayList<HistoricalFigure> list) {
        Collections.sort(list, new Comparator<HistoricalFigure>() {
            @Override
            public int compare(HistoricalFigure f1, HistoricalFigure f2) {
                String name1 = f1.getName();
                String name2 = f2.getName();

                if (name1 == null && name2 == null) {
                    return 0;
                } else if (name1 == null) {
                    return 1;
                } else if (name2 == null) {
                    return -1;
                } else {
                    return name1.compareToIgnoreCase(name2);
                }
            }
        });
    }


}

