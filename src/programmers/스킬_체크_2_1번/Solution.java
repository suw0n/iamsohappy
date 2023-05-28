package programmers.스킬_체크_2_1번;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    public String[] solution(String[] files) {
        Comparator<Num> comparator = (o1, o2) -> {
            if(o1.head.equals(o2.head)) {
                if(o1.number == o2.number) {
                    return 0;
                } else {
                    return o1.number-o2.number;
                }
            } else {
                return o1.head.compareTo(o2.head);
            }
        };

        List<Num> numList = new ArrayList<>();
        for (String file : files) {
            numList.add(new Num(file));
        }
        numList.sort(comparator);

        String[] result = new String[files.length];
        for(int i = 0; i<files.length; i++) {
            result[i] = numList.get(i).original;
        }
        return result;
    }

}

class Num {
    String head;
    int number;
    String tail;
    String original;

    public Num(String file) {
        this.original = file;

        boolean isFirst = true, isContinue = false;
        int start = 0, end = 0;

        for(int i = 0; i<file.length(); i++) {
            if(isFirst && '0'<=file.charAt(i) && file.charAt(i)<='9') {
                start = end = i;
                isFirst = false;
                isContinue = true;
            } else if('0'<=file.charAt(i) && file.charAt(i)<='9' && isContinue) {
                end++;
            } else {
                isContinue = false;
            }
        }

        this.head = file.substring(0, start).toLowerCase();
        this.number = Integer.parseInt(file.substring(start, end+1));
        this.tail = file.substring(end+1);
    }

}