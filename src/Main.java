import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> books = List.of("Война и мир",
                "Матрица",
                "Муму",
                "Зомби",
                "Самоучитель сербского языка",
                "Ясен клен",
                "Роботы");
        sortingByShelves(books)
                .forEach(System.out::println);
    }

    public static List<List<String>> sortingByShelves(List<String> books) {
        books = books.stream()
                .sorted(String::compareTo)
                .toList();
        int booksPerShelve = books.size() / 5;
        int shelvesWithExtraBooks = books.size() % 5;
        int count = 0;
        List<List<String>> sortedList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            sortedList.add(new ArrayList<>());
            if (i < shelvesWithExtraBooks) {
                for (int j = 0; j <= booksPerShelve; j++) {
                    sortedList.get(i).add(books.get(count));
                    count++;
                }
            } else {
                for (int j = 0; j < booksPerShelve; j++) {
                    sortedList.get(i).add(books.get(count));
                    count++;
                }
            }
        }
        return sortedList;
    }
}


















//
//Задача
//        Необходимо реализовать следующий метод:
//        На вход получаем список названий книг
//        Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
//        Все книги должны быть отсортированы по алфавиту с первой до последней полки
//        Количество полок константное - 5 штук
//        Вернуть книги распределенные по полкам
