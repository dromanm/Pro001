package lesson02;

/**
 * Created by IEvgen Boldyr on 18.12.16.
 */
public class TreeMapTets {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        System.out.println("Добавление элемнта с ключем 50 : " + treeMap.add(50, "Test1"));
        System.out.println("Добавление элемнта с ключем 35 : " + treeMap.add(35, "Test2"));
        System.out.println("Добавление элемнта с ключем 40 : " + treeMap.add(40, "Test3"));
        System.out.println("Добавление элемнта с ключем 75 : " + treeMap.add(75, "Test4"));
        System.out.println("Добавление элемнта с ключем 65 : " + treeMap.add(65, "Test5"));
        System.out.println("Добавление элемнта с ключем 10 : " + treeMap.add(10, "Test6"));
        System.out.println("Добавление элемнта с ключем 40 : " + treeMap.add(40, "Test7"));
        System.out.println("Добавление элемнта с ключем 75 : " + treeMap.add(75, "Test7"));

        System.out.println("Поиск элементов по ключу: ");
        System.out.println("Ищем ключ 40: " + treeMap.find(40));
        System.out.println("Ищем ключ 10: " + treeMap.find(10));
        System.out.println("Ищем ключ 55: " + treeMap.find(55));

        System.out.println("Извлечение элементов по ключу: ");
        System.out.println("Извлечение элемента под ключем 40: " + treeMap.get(40));
        System.out.println("Извлечение элемента под ключем 55: " + treeMap.get(55));
        System.out.println("Извлечение элемента под ключем 10: " + treeMap.get(10));
    }
}
