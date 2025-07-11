class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Map<Integer, Integer> booked = new HashMap<>();
        PriorityQueue<Room> pq = new PriorityQueue<>(new Comparator<Room>() {
            public int compare(Room a, Room b) {
                if (a.end == b.end) {
                    return Integer.compare(a.id, b.id); 
                }
                return Long.compare(a.end, b.end);
            }
        });
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }
        Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));
        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            while (!pq.isEmpty() && pq.peek().end <= start) {
                freeRooms.add(pq.poll().id);
            }
            if (!freeRooms.isEmpty()) {
                int roomId = freeRooms.poll();
                booked.put(roomId, booked.getOrDefault(roomId, 0) + 1);
                pq.add(new Room(end, roomId));
            } else {
                Room room = pq.poll();
                booked.put(room.id, booked.getOrDefault(room.id, 0) + 1);
                pq.add(new Room(room.end + (end - start), room.id));
            }
        }
        int maxBookings = 0;
        int meetingRoom = -1;
        for (Map.Entry<Integer, Integer> entry : booked.entrySet()) {
            if (entry.getValue() > maxBookings) {
                maxBookings = entry.getValue();
                meetingRoom = entry.getKey();
            }
        }       
        return meetingRoom;
    }
    class Room {
        long end;
        int id;
        
        Room(long end, int id) {
            this.end = end;
            this.id = id;
        }
    }
}