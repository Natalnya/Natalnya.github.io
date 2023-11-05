package lab5;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Пример использования методов
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog");
        List<String> duplicateStrings = Arrays.asList("apple", "banana", "apple", "dog");
        List<String> collection = Arrays.asList("apple", "banana", "cat", "dog");

        // Метод, возвращающий среднее значение списка целых чисел
        double average = getAverage(numbers);
        System.out.println("Average: " + average);

        // Метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс "_new_"
        List<String> upperCaseStrings = addPrefixToUpper(strings);
        System.out.println("Upper case strings: " + upperCaseStrings);

        // Метод, возвращающий список квадратов всех встречающихся только один раз элементов списка
        List<Integer> uniqueSquares = getUniqueSquares(numbers);
        System.out.println("Unique squares: " + uniqueSquares);

        // Метод, возвращающий все строки, начинающиеся с заданной буквы, отсортированные по алфавиту
        List<String> sortedStrings = getSortedStrings(collection, 'b');
        System.out.println("Sorted strings: " + sortedStrings);

        // Метод, возвращающий последний элемент из коллекции или кидающий исключение, если коллекция пуста
        try {
            String lastElement = getLastElement(collection);
            System.out.println("Last element: " + lastElement);
        } catch (NoSuchElementException e) {
            System.out.println("Collection is empty");
        }

        // Метод, возвращающий сумму четных чисел в массиве или 0, если четных чисел нет
        int[] array = {1, 2, 3, 4, 5};
        int sumOfEvens = getSumOfEvens(array);
        System.out.println("Sum of evens: " + sumOfEvens);

        // Метод, преобразовывающий все строки в списке в Map
        Map<Character, String> map = convertToMap(strings);
        System.out.println("Map: " + map);
    }

    // Метод, возвращающий среднее значение списка целых чисел
    public static double getAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    // Метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс "_new_"
    public static List<String> addPrefixToUpper(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    // Метод, возвращающий список квадратов всех встречающихся только один раз элементов списка
    public static List<Integer> getUniqueSquares(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> Collections.frequency(numbers, num) == 1)
                .map(num -> num * num)
                .collect(Collectors.toList());
    }

    // Метод, возвращающий все строки, начинающиеся с заданной буквы, отсортированные по алфавиту
    public static List<String> getSortedStrings(List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .sorted()
                .collect(Collectors.toList());
    }

    // Метод, возвращающий последний элемент из коллекции или кидающий исключение, если коллекция пуста
    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(NoSuchElementException::new);
    }

    // Метод, возвращающий сумму четных чисел в массиве или 0, если четных чисел нет
    public static int getSumOfEvens(int[] array) {
        return Arrays.stream(array)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    // Метод, преобразовывающий все строки в списке в Map
    public static Map<Character, String> convertToMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1)
                ));
    }
}
