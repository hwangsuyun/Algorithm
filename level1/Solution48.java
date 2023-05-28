package programmers.level1;

// 공원 산책
public class Solution48 {
    public static void main(String[] args) {
        //String[] park = {"SOO", "OOO", "OOO"};
        //String[] routes = {"E 2", "S 2", "W 1"};
        // [2, 1]
        //String[] park = {"SOO", "OXX", "OOO"};
        //String[] routes = {"E 2", "S 2", "W 1"};
        // [0, 1]
        //String[] park = {"OSO", "OOO", "OXO", "OOO"};
        //String[] routes = {"E 2", "S 3", "W 1"};
        // [0, 0]
        //String[] park = {"OSO", "OOO", "OOO", "OOO"};
        //String[] routes = {"W 2"};
        // [0, 1]
        //String[] park = {"OSO", "OOO", "OOO", "OOO"};
        //String[] routes = {"N 2"};
        // [0, 1]
        //String[] park = {"OSO", "OOO", "OOO", "OOO"};
        //String[] routes = {"S 5"};
        // [0, 1]
        //String[] park = {"OSO", "OOO", "OOO", "OOO"};
        //String[] routes = {"E 5"};
        // [0, 1]
        //String[] park = {"XXX", "XSX", "XXX"};
        //String[] routes = {"E 1"};
        // [1, 1]
        String[] park = {"XXX", "XSX", "XXX"};
        String[] routes = {"W 1"};
        // [1, 1]

        if (park.length < 3 || park.length > 50) return;
        if (routes.length < 1 || routes.length > 50) return;

        int[] result = solution(park, routes);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(String[] park, String[] routes) {
        int rowS = 0, columnS = 0;
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                rowS = i;
                columnS = park[i].indexOf("S");
            }
        }
        System.out.println("rowsS : " + rowS);
        System.out.println("columnS : " + columnS);

        for (int i = 0; i < routes.length; i++) {
            int value = Integer.valueOf(routes[i].charAt(2) + "");

            if (routes[i].contains("E")) {
                if (isInsideLines("E", park[rowS].length(), rowS, columnS, value)
                        && isMoving("E", park, rowS, columnS, value)) columnS += value;
            } else if (routes[i].contains("W")) {
                if (isInsideLines("W", park[rowS].length(), rowS, columnS, value)
                        && isMoving("W", park, rowS, columnS, value)) columnS -= value;
            } else if (routes[i].contains("S")) {
                if (isInsideLines("S", park.length, rowS, columnS, value)
                        && isMoving("S", park, rowS, columnS, value)) rowS += value;
            } else if (routes[i].contains("N")) {
                if (isInsideLines("N", park.length, rowS, columnS, value)
                        && isMoving("N", park, rowS, columnS, value)) rowS -= value;
            }
        }

        System.out.println("S low : " + rowS);
        System.out.println("S column : " + columnS);

        return new int[] {rowS, columnS};
    }

    private static boolean isInsideLines(String way, int parkLen, int rowS, int columnS, int value) {
        switch (way) {
            case "E":
                return columnS + value < parkLen;
            case "W":
                return columnS - value >= 0;
            case "S":
                return rowS + value < parkLen;
            case "N":
                return rowS - value >= 0;
        }
        return false;
    }

    private static boolean isMoving(String way, String[] park, int rowS, int columnS, int value) {
        int i = 0;
        switch (way) {
            case "E":
                i = columnS + 1;
                while (value > 0) {
                    if (park[rowS].charAt(i) == 'X') return false;
                    i++;
                    value--;
                }
                break;
            case "W":
                i = columnS;
                while (value >= 0) {
                    if (park[rowS].charAt(i) == 'X') return false;
                    i--;
                    value--;
                }
                break;
            case "S":
                i = rowS + 1;
                while (value > 0) {
                    if (park[i].charAt(columnS) == 'X') return false;
                    i++;
                    value--;
                }
                break;
            case "N":
                i = rowS;
                while (value >= 0) {
                    if (park[i].charAt(columnS) == 'X') return false;
                    i--;
                    value--;
                }
                break;
        }
        return true;
    }
}