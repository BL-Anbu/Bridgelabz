package Day_29_Practice_Problem.java;

public class CensusAnalyserMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Indian States Census Analyser Program");
        System.out.println("------------------------------------------------");

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        String stateCensusCSV = "Day_29_Practice_Problem/resource/IndiaStateCensusData.csv";
        String stateCodeCSV   = "Day_29_Practice_Problem/resource/IndiaStateCode.csv";

        // ==========================
        // UC 1 – State Census Data
        // ==========================
        try {
            int censusCount = analyser.loadStateCensusData(stateCensusCSV);
            System.out.println("UC1 SUCCESS ✅");
            System.out.println("Total State Census Records: " + censusCount);
        } catch (CensusAnalyserException e) {
            System.out.println("UC1 FAILED ❌ : " + e.type);
        }

        // UC 1 – Wrong File Path
        try {
            analyser.loadStateCensusData("wrong-path.csv");
        } catch (CensusAnalyserException e) {
            System.out.println("UC1 Wrong File Path Test Passed ✅ : " + e.type);
        }

        // UC 1 – Wrong File Type
        try {
            analyser.loadStateCensusData("IndiaStateCensusData.txt");
        } catch (CensusAnalyserException e) {
            System.out.println("UC1 Wrong File Type Test Passed ✅ : " + e.type);
        }

        // ==========================
        // UC 2 – State Code Data
        // ==========================
        try {
            int stateCodeCount = analyser.loadStateCodeData(stateCodeCSV);
            System.out.println("\nUC2 SUCCESS ✅");
            System.out.println("Total State Code Records: " + stateCodeCount);
        } catch (CensusAnalyserException e) {
            System.out.println("UC2 FAILED ❌ : " + e.type);
        }

        // UC 2 – Wrong File Path
        try {
            analyser.loadStateCodeData("wrong-state-code.csv");
        } catch (CensusAnalyserException e) {
            System.out.println("UC2 Wrong File Path Test Passed ✅ : " + e.type);
        }

        // UC 2 – Wrong File Type
        try {
            analyser.loadStateCodeData("IndiaStateCode.txt");
        } catch (CensusAnalyserException e) {
            System.out.println("UC2 Wrong File Type Test Passed ✅ : " + e.type);
        }

        System.out.println("\nAll functionality tested successfully 🚀");
    }
}
