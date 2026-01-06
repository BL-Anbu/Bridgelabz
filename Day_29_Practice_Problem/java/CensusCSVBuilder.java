package Day_29_Practice_Problem.java;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;

public class CensusCSVBuilder {

    public <T> Iterator<T> getCSVIterator(Reader reader, Class<T> csvClass) {
        return new CsvToBeanBuilder<T>(reader)
                .withType(csvClass)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .iterator();
    }
}