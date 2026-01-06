package Day_29_Practice_Problem.test;

import Day_29_Practice_Problem.java.CensusAnalyserException;
import Day_29_Practice_Problem.java.StateCensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {

    private static final String STATE_CENSUS_CSV =
            "src/main/resources/IndiaStateCensusData.csv";
    private static final String STATE_CODE_CSV =
            "src/main/resources/IndiaStateCode.csv";

    // TC 1.1 – Happy Case
    @Test
    public void givenStateCensusCSV_WhenCorrect_ShouldReturnCount()
            throws CensusAnalyserException {

        StateCensusAnalyser analyser = new StateCensusAnalyser();
        int count = analyser.loadStateCensusData(STATE_CENSUS_CSV);
        Assert.assertEquals(29, count);
    }

    // TC 1.2 – Wrong File Path
    @Test
    public void givenWrongFile_ShouldThrowFileNotFoundException() {
        try {
            new StateCensusAnalyser()
                    .loadStateCensusData("wrong.csv");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND,
                    e.type);
        }
    }

    // TC 1.3 – Wrong File Type
    @Test
    public void givenWrongFileType_ShouldThrowInvalidTypeException() {
        try {
            new StateCensusAnalyser()
                    .loadStateCensusData("IndiaStateCensusData.txt");
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
                    e.type);
        }
    }

    // UC2 – Happy Case
    @Test
    public void givenStateCodeCSV_WhenCorrect_ShouldReturnCount()
            throws CensusAnalyserException {

        StateCensusAnalyser analyser = new StateCensusAnalyser();
        int count = analyser.loadStateCodeData(STATE_CODE_CSV);
        Assert.assertEquals(37, count);
    }
}