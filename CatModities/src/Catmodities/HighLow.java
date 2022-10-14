package Catmodities;

public class HighLow {

    private int[][] yesterday = new int[3][5];
    private int[][] today = new int[3][5];

    private int[] highLowMarkers = new int[15];
    
    void recordOld(int[] fishArrayYesterday, int[] toyArrayYesterday, int[] treatArrayYesterday){
        
        // Set temporary arrays
        int[] fishTemp = new int[5];
        int[] toyTemp = new int[5];
        int[] treatTemp = new int[5];

        // Deep copy into array holding yesterday's figures
        for (int i = 0; i < 5; i++){
            fishTemp[i] = fishArrayYesterday[i];
        }

        for (int i = 0; i < 5; i++){
            toyTemp[i] = toyArrayYesterday[i];
        }

        for (int i = 0; i < 5; i++){
            treatTemp[i] = treatArrayYesterday[i];
        }

        yesterday[0] = fishTemp;
        yesterday[1] = toyTemp;
        yesterday[2] = treatTemp;
    }

    int[] getHighLow(int[] fishArrayToday, int[] toyArrayToday, int[] treatArrayToday){

        // Set temporary arrays
        today[0] = fishArrayToday;
        today[1] = toyArrayToday;
        today[2] = treatArrayToday;

        // Compare arrays - 0 for lower, 1 for the same, or 2 for higher than yesterday's
        int index = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 5; j++){
                if (yesterday[i][j] < today[i][j]){
                    highLowMarkers[index++] = 0;
                } else if (yesterday[i][j] > today[i][j]){
                    highLowMarkers[index++] = 2;
                } else {
                    highLowMarkers[index++] = 1;
                }
            }
        }
        return highLowMarkers;
    }    
}
