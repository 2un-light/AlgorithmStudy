class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for(int hour = 0; hour < 12; hour++) {
            for(int minute = 0; minute < 60; minute++) {
                int hourBitCnt = Integer.bitCount(hour);
                int minuteBitCnt = Integer.bitCount(minute);

                if(hourBitCnt + minuteBitCnt == turnedOn) {
                    String time = hour + ":" + (minute < 10 ? "0"+minute : minute);
                    result.add(time);
                }
            }
        }

        return result;

    }
}