package Day_29_Practice_Problem.java;

import java.io.*;
import java.util.Iterator;

public class StateCensusAnalyser {

    // UC1 – Load State Census CSV
    public int loadStateCensusData(String csvFilePath)
            throws CensusAnalyserException {

        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
        }

        try (Reader reader = new FileReader(csvFilePath)) {

            CensusCSVBuilder csvBuilder = new CensusCSVBuilder();
            Iterator<CSVStateCensus> iterator =
                    csvBuilder.getCSVIterator(reader, CSVStateCensus.class);

            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }
            return count;

        } catch (FileNotFoundException e) {
            throw new CensusAnalyserException(
                    "File not found",
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);

        } catch (RuntimeException e) {
            throw new CensusAnalyserException(
                    "Invalid CSV Header or Delimiter",
                    CensusAnalyserException.ExceptionType.INVALID_HEADER);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // UC2 – Load State Code CSV
    public int loadStateCodeData(String csvFilePath)
            throws CensusAnalyserException {

        if (!csvFilePath.endsWith(".csv")) {
            throw new CensusAnalyserException(
                    "Invalid file type",
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
        }

        try (Reader reader = new FileReader(csvFilePath)) {

            CensusCSVBuilder csvBuilder = new CensusCSVBuilder();
            Iterator<CSVStateCode> iterator =
                    csvBuilder.getCSVIterator(reader, CSVStateCode.class);

            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }
            return count;

        } catch (FileNotFoundException e) {
            throw new CensusAnalyserException(
                    "File not found",
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);

        } catch (RuntimeException e) {
            throw new CensusAnalyserException(
                    "Invalid CSV Header or Delimiter",
                    CensusAnalyserException.ExceptionType.INVALID_HEADER);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
