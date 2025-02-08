// import java.util.*;

class NumberContainers {
    HashMap<Integer, TreeSet<Integer>> map;
    HashMap<Integer, Integer> indexToNumber;

    public NumberContainers() {
        map = new HashMap<>();
        indexToNumber = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            map.get(oldNumber).remove(index);
            if (map.get(oldNumber).isEmpty()) {
                map.remove(oldNumber);
            }
        }

        indexToNumber.put(index, number);

        map.putIfAbsent(number, new TreeSet<>());
        map.get(number).add(index);
    }

    public int find(int number) {
        if (!map.containsKey(number) || map.get(number).isEmpty()) return -1;
        return map.get(number).first();
    }
}
