package hw1;

/**
 * Created by Жека on 12/18/2016.
 */
public class Test {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        System.out.println("Добавление элемнта с ключем 50 : " + treeMap.add(50, "Test1"));
        System.out.println("Добавление элемнта с ключем 35 : " + treeMap.add(35, "Test2"));
        System.out.println("Добавление элемнта с ключем 40 : " + treeMap.add(40, "Test3"));


        System.out.println("Поиск элементов по ключу: ");
        System.out.println("Ищем ключ 35: " + treeMap.find(35));

        System.out.println(treeMap.remove(520));
        System.out.println(treeMap.find(35));
        System.out.println("Извлечение элементов по ключу: ");
       System.out.println("Извлечение элемента под ключем 50: " + treeMap.get(50));
       System.out.println("Извлечение элемента под ключем 40: " + treeMap.get(40));







;
    }


}
