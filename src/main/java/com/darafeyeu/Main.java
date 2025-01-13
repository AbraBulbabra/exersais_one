package com.darafeyeu;

public class Main {

    public static void main(String[] args) {
        String example1 = "I love Java";
        turnString(example1);

        int[] example2 = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        getDistinctNumbers(example2);

        int[] example3 = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        System.out.println(findSecondMaxElement(example3));


        String example4[] = {"Hello world", "    fly me    to the moon    ", "I love Java"};
        for (String s : example4) {
            System.out.printf("example 4\n%s\nThe last word consists of %d\n--------\n", s, lengthOfLastWord(s));
        }


        String example5[] = {
                "level",
                "radar",
                "deified",
                "civic",
                "rotor",
                "kayak",
                "madam",
                "refer",
                "racecar",
                "noon"};
        for (String s : example5) {
            System.out.printf("example 5\n-Is palindrom?\n%s -> %s\n--------\n", s, isPalindrome(s));
        }

        String noPalindrom[] = {
                "hello",
                "world",
                "java",
                "programming",
                "example",
                "string",
                "array",
                "non-palindrome",
                "test",
                "code",
                "1234"
        };
        for (String s : noPalindrom) {
            System.out.printf("example 5\n-Is palindrom?\n%s -> %s\n--------\n", s, isPalindrome(s));
        }


    }


    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        int sizeString = string.length() - 1;
        char stringChar[] = string.toCharArray();
        StringBuilder outString = new StringBuilder();

        for (int i = sizeString; i >= 0; i--) {
            outString.append(stringChar[i]);
        }
        System.out.println(outString);
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        String string = "";
        for (int i = 0; i < ints.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ints[i]);
            if (string.contains(stringBuilder)) {
                continue;
            }
            string += ints[i];
        }
        System.out.println(string);

    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        Integer afterMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                afterMax = max;
                max = i;
            } else if (i > afterMax) {
                afterMax = i;
            }
        }
        return afterMax;
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        string = string.trim();
        String[] words = string.split(" ");
        return words[words.length - 1].length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        int sizeString = string.length();

        int lastIndex = sizeString - 1;
        int mediumSize = sizeString / 2;

        boolean palindrome = false;

        for (int i = 0, j = lastIndex;
             i <= mediumSize && j >= mediumSize; i++, j--) {
            if (string.charAt(i) == string.charAt(j)) {
                palindrome = true;
            } else {
                return false;
            }
        }

        return palindrome;
    }
}