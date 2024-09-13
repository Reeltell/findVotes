import java.util.*;

class DanceMarathonVoting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества голосов
        System.out.print("Введите количество пришедших sms-сообщений N: ");
        int N = Integer.parseInt(scanner.nextLine());

        // Создание карты для хранения голосов
        Map<Integer, Integer> votes = new HashMap<>();

        // Чтение голосов
        System.out.println("Введите номера пар (от 1 до 16):");
        for (int i = 0; i < N; i++) {
            int pairNumber = Integer.parseInt(scanner.nextLine());
            if (pairNumber >= 1 && pairNumber <= 16) {
                votes.put(pairNumber, votes.getOrDefault(pairNumber, 0) + 1);
            } else {
                System.out.println("Неверный номер пары: " + pairNumber);
            }
        }

        // Преобразование карты в список для сортировки
        List<Map.Entry<Integer, Integer>> sortedVotes = new ArrayList<>(votes.entrySet());

        // Сортировка по количеству голосов в порядке убывания
        sortedVotes.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Вывод результатов
        System.out.println("Результаты голосования:");
        for (Map.Entry<Integer, Integer> entry : sortedVotes) {
            System.out.println("Пара " + entry.getKey() + ": " + entry.getValue() + " голосов");
        }
    }
}