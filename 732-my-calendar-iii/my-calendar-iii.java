class MyCalendarThree {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendarThree() {
          calendar = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        calendar.put(startTime, calendar.getOrDefault(startTime, 0) + 1);
        calendar.put(endTime, calendar.getOrDefault(endTime, 0) - 1);

        int active = 0;
        int maxActive = Integer.MIN_VALUE;

         for (int count : calendar.values()) {
            active += count;
            maxActive = Math.max(active,maxActive);
        }

        return maxActive;
    }
}