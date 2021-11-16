package kr.dogfoot.hwplib.tool.textextractor.paraHead;

import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphNumberFormat;

public class ParaHeadNumber {
    private static String[] circledNumbers;
    private static String[] circledUppercaseAlphabets;
    private static String[] circledLowercaseAlphabets;
    private static String[] hangul;
    private static String[] circledHangul;
    private static String[] hangulJamo;
    private static String[] circledHangulJamo;
    private static String[] hangulNumber;
    private static String[] hanjaNumber;
    private static String[] circledHanjaNumber;
    private static String[] sibGanHangul;
    private static String[] sibGanHanja;

    static {
        setCircledNumbers();
        setCircledUppercaseAlphabets();
        setCircledLowercaseAlphabets();
        setHangul();
        setCircledHangul();
        setHangulJamo();
        setCircledHangulJamo();
        setHangulNumber();
        setHanjaNumber();
        setCircledHanjaNumber();
        setSibGanHangul();
        setSibGanHanja();
    }

    private static void setCircledNumbers() {
        String chars = "①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮⑯⑰⑱⑲⑳";

        circledNumbers = new String[chars.length()];
        for (int index = 0; index < circledNumbers.length; index++) {
            circledNumbers[index] = chars.substring(index, index + 1);
        }
    }

    private static void setCircledUppercaseAlphabets() {
        String chars = "ⒶⒷⒸⒹⒺⒻⒼⒽⒾⒿⓀⓁⓂⓃⓄⓅⓆⓇⓈⓉⓊⓋⓌⓍⓎⓏ";

        circledUppercaseAlphabets = new String[chars.length()];
        for (int index = 0; index < circledUppercaseAlphabets.length; index++) {
            circledUppercaseAlphabets[index] = chars.substring(index, index + 1);
        }
    }

    private static void setCircledLowercaseAlphabets() {
        String chars = "ⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ";

        circledLowercaseAlphabets = new String[chars.length()];
        for (int index = 0; index < circledLowercaseAlphabets.length; index++) {
            circledLowercaseAlphabets[index] = chars.substring(index, index + 1);
        }
    }

    private static void setHangul() {
        String chars = "가나다라마바사아자차카타파하거너더러머버서어저처커터퍼허고노도로모보소오조초코토포호구누두루무부수우주추쿠투푸후그느드르므브스으즈츠크트프흐기니디리미비시이지치키피피히";

        hangul = new String[chars.length()];
        for (int index = 0; index < hangul.length; index++) {
            hangul[index] = chars.substring(index, index + 1);
        }
    }

    private static void setCircledHangul() {
        String chars = "㉮㉯㉰㉱㉲㉳㉴㉵㉶㉷㉸㉹㉺㉻";

        circledHangul = new String[chars.length()];
        for (int index = 0; index < circledHangul.length; index++) {
            circledHangul[index] = chars.substring(index, index + 1);
        }
    }

    private static void setHangulJamo() {
        String chars = "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ";

        hangulJamo = new String[chars.length()];
        for (int index = 0; index < hangulJamo.length; index++) {
            hangulJamo[index] = chars.substring(index, index + 1);
        }
    }

    private static void setCircledHangulJamo() {
        String chars = "㉠㉡㉢㉣㉤㉥㉦㉧㉨㉩㉪㉫㉬㉭";

        circledHangulJamo = new String[chars.length()];
        for (int index = 0; index < circledHangulJamo.length; index++) {
            circledHangulJamo[index] = chars.substring(index, index + 1);
        }
    }

    private static void setHangulNumber() {
        String chars = "일이삼사오육칠팔구십";

        hangulNumber = new String[chars.length()];
        for (int index = 0; index < hangulNumber.length; index++) {
            hangulNumber[index] = chars.substring(index, index + 1);
        }
    }

    private static void setHanjaNumber() {
        String chars = "一二三四五六七八九十";

        hanjaNumber = new String[chars.length()];
        for (int index = 0; index < hanjaNumber.length; index++) {
            hanjaNumber[index] = chars.substring(index, index + 1);
        }
    }

    private static void setCircledHanjaNumber() {
        String chars = "㊀㊁㊂㊃㊄㊅㊆㊇㊈㊉";

        circledHanjaNumber = new String[chars.length()];
        for (int index = 0; index < circledHanjaNumber.length; index++) {
            circledHanjaNumber[index] = chars.substring(index, index + 1);
        }
    }

    private static void setSibGanHangul() {
        String chars = "갑을병정무기경신임계";

        sibGanHangul = new String[chars.length()];
        for (int index = 0; index < sibGanHangul.length; index++) {
            sibGanHangul[index] = chars.substring(index, index + 1);
        }
    }

    private static void setSibGanHanja() {
        String chars = "甲乙丙丁戊己庚辛壬癸";

        sibGanHanja = new String[chars.length()];
        for (int index = 0; index < sibGanHanja.length; index++) {
            sibGanHanja[index] = chars.substring(index, index + 1);
        }
    }

    public static String toString(int value, ParagraphNumberFormat format) {
        switch (format) {
            case Number:
                return String.valueOf(value);
            case CircledNumber:
                return circledNumber(value);
            case UppercaseRomanNumber:
                return romanNumber(value, true);
            case LowercaseRomanNumber:
                return romanNumber(value, false);
            case UppercaseAlphabet:
                return uppercaseAlphabet(value);
            case LowercaseAlphabet:
                return lowercaseAlphabet(value);
            case CircledUppercaseAlphabet:
                return circledUppercaseAlphabet(value);
            case CircledLowercaseAlphabet:
                return circledLowercaseAlphabet(value);
            case Hangul:
                return hangul(value);
            case CircledHangul:
                return circledHangul(value);
            case HangulJamo:
                return hangulJamo(value);
            case CircledHangulJamo:
                return circledHangulJamo(value);
            case HangulNumber:
                return hangulNumber(value);
            case HanjaNumber:
                return hanjaNumber(value);
            case CircledHanjaNumber:
                return circledHanjaNumber(value);
            case SibGanHangul:
                return sibGanHangul(value);
            case SibGanHanja:
                return sibGanHanja(value);
        }
        return String.valueOf(value);
    }

    private static String romanNumber(int value, boolean uppercase) {
        String[] roman;
        if (uppercase) {
            roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL",
                    "X", "IX", "V", "IV", "I"};
        } else {
            roman = new String[]{"m", "cm", "d", "cd", "c", "xc", "l", "xl",
                    "x", "ix", "v", "iv", "i"};
        }

        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String romanNumber = "";
        for (int i = 0; i < 13; i++) {
            while (value >= decimal[i]) {
                romanNumber = romanNumber + roman[i];
                value = value - decimal[i];
            }
        }
        return romanNumber;
    }

    private static String circledNumber(int value) {
        return circledNumbers[(value - 1) % 20];
    }

    private static String uppercaseAlphabet(int value) {
        return new Character((char) ('A' + (value - 1) % 26)).toString();
    }

    private static String lowercaseAlphabet(int value) {
        return new Character((char) ('a' + (value - 1) % 26)).toString();
    }

    private static String circledUppercaseAlphabet(int value) {
        return circledUppercaseAlphabets[(value - 1) % 26];
    }

    private static String circledLowercaseAlphabet(int value) {
        return circledLowercaseAlphabets[(value - 1) % 26];
    }

    private static String hangul(int value) {
        return hangul[(value - 1) % 84];
    }

    private static String circledHangul(int value) {
        return circledHangul[(value - 1) % 14];
    }

    private static String hangulJamo(int value) {
        return hangulJamo[(value - 1) % 14];
    }

    private static String circledHangulJamo(int value) {
        return circledHangulJamo[(value - 1) % 14];
    }

    private static String hangulNumber(int value) {
        int value2 = ((value - 1) % 99 + 1);
        if (value2 <= 10) {
            return hangulNumber[value2 - 1];
        } else if (value2 <= 19) {
            return hangulNumber[9] + hangulNumber[(value2 - 1) % 10];
        } else {
            if (value2 % 10 == 0) {
                return hangulNumber[value2 / 10 - 1] + hangulNumber[9];
            } else {
                return hangulNumber[value2 / 10 - 1] + hangulNumber[9] + hangulNumber[(value2 - 1) % 10];
            }
        }
    }

    private static String hanjaNumber(int value) {
        int value2 = ((value - 1) % 99 + 1);
        if (value2 <= 10) {
            return hanjaNumber[value2 - 1];
        } else if (value2 <= 19) {
            return hanjaNumber[9] + hanjaNumber[(value2 - 1) % 10];
        } else {
            if (value2 % 10 == 0) {
                return hanjaNumber[value2 / 10 - 1] + hanjaNumber[9];
            } else {
                return hanjaNumber[value2 / 10 - 1] + hanjaNumber[9] + hanjaNumber[(value2 - 1) % 10];
            }
        }
    }

    private static String circledHanjaNumber(int value) {
        return circledHanjaNumber[(value - 1) % 10];
    }

    private static String sibGanHangul(int value) {
        return sibGanHangul[(value - 1) % 10];
    }

    private static String sibGanHanja(int value) {
        return sibGanHanja[(value - 1) % 10];
    }

}
