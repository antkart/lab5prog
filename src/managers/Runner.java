package managers;

import commands.*;
import models.View;
import models.*;

import java.io.*;

/**
 * Класс, отвечающий за выполнение пользовательских команд из потока ввода.
 * <p>
 * Может работать в интерактивном режиме или запускать команды из скрипта.
 */
public class Runner {
    BufferedReader buf;
    String fileScript;
    String fileName;
    int depth;

    /**
     * Конструктор для создания объекта {@code Runner}.
     *
     * @param buf        поток ввода, откуда считываются команды
     * @param fileName   имя файла для сохранения коллекции
     * @param fileScript путь к текущему исполняемому скрипту
     * @param depth      глубина рекурсии при выполнении скриптов
     */
    public Runner(BufferedReader buf, String fileName, String fileScript, int depth) {
        this.buf = buf;
        this.fileName = fileName;
        this.fileScript = fileScript;
        this.depth = depth;
    }

    /**
     * Запускает обработку пользовательских команд из заданного потока ввода.
     *
     * @param collectionManager менеджер коллекции, над которой выполняются команды
     */
    public void run(CollectionManager collectionManager) {
        try {
            while (true) {
                String line = buf.readLine();
                if(line == null) {
                    break;
                }
                String[] command = line.split(" ");
                String userCommand = command[0];
                switch (userCommand) {
                    case "":
                        break;
                    case "add":
                        Add add = new Add(collectionManager);
                        add.execute(buf);
                        break;
                    case "update":
                        try {
                            if (command.length > 1) {
                                long id = Long.parseLong(command[1]);
                                UpdateId update = new UpdateId(collectionManager, id);
                                update.execute(buf);
                            } else {
                                System.out.println("Пользователь не ввел id");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Введите существующее id");
                        }
                        break;
                    case "remove_by_id":
                        try {
                            if (command.length > 1) {
                                long id = Long.parseLong(command[1]);
                                RemoveById remove = new RemoveById(collectionManager, id);
                                remove.execute();
                            } else {
                                System.out.println("Пользователь не ввел id");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Введите существующее id(натуральное число)");
                        }
                        break;
                    case "clear":
                        Clear clear = new Clear(collectionManager);
                        clear.execute();
                        break;
                    case "save":
                        Save save = new Save(collectionManager, fileName);
                        save.execute();
                        break;
                    case "exit":
                        Exit exit = new Exit();
                        exit.execute();
                        break;
                    case "add_if_max":
                        AddIfMax addIfMax = new AddIfMax(collectionManager);
                        addIfMax.execute(buf);
                        break;
                    case "remove_greater":
                        RemoveGreater removeGreater = new RemoveGreater(collectionManager);
                        removeGreater.execute(buf);
                        break;
                    case "remove_lower":
                        RemoveLower removeLower = new RemoveLower(collectionManager);
                        removeLower.execute(buf);
                        break;
                    case "average_of_number_of_rooms":
                        AverageOfNumberOfRooms average = new AverageOfNumberOfRooms(collectionManager);
                        average.execute();
                        break;
                    case "filter_less_than_view":
                        try {
                            if (command.length > 1) {
                                View view = View.valueOf(command[1]);
                                FilterLessThanView filter = new FilterLessThanView(collectionManager, view);
                                filter.execute();
                            } else {
                                System.out.println("Пользователь не ввел элемент типа models.View");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка! Введен элемент не из списка [STREET, BAD, GOOD]");
                        }
                        break;
                    case "print_unique_furnish":
                        PrintUniqueFurnish print = new PrintUniqueFurnish(collectionManager);
                        print.execute();
                        break;
                    case "help":
                        Help help = new Help();
                        help.execute();
                        break;
                    case "show":
                        Show show = new Show(collectionManager);
                        show.execute();
                        break;
                    case "info":
                        Info info = new Info(collectionManager);
                        info.execute();
                        break;
                    case "execute_script":
                        try {
                            if (command.length > 1) {
                                String scriptPath = command[1];
                                File scriptFile = new File(scriptPath).getCanonicalFile(); // нормализуем путь
                                String absolutePath = scriptFile.getAbsolutePath();

                                // Если скрипт уже был выполнен
                                if (fileScript != null && fileScript.equals(absolutePath)) {
                                    // Рекурсия обнаружена. Запрашиваем глубину только один раз
                                    if (depth == -1) {
                                        System.out.println("Обнаружена рекурсия. Введите максимальную глубину рекурсии: ");
                                        BufferedReader bufIn = new BufferedReader(new InputStreamReader(System.in));
                                        depth = Integer.parseInt(bufIn.readLine());
                                        if (depth <= 0) {
                                            System.out.println("Глубина должна быть положительной. Команда отменена.");
                                            break;
                                        }
                                    }

                                    // После того как глубина была задана, уменьшаем её и продолжаем выполнение
                                    if (depth > 0) {
                                        depth -= 1; // уменьшаем глубину на 1
                                        BufferedReader scriptReader = new BufferedReader(new FileReader(scriptFile));
                                        Runner recursiveRunner = new Runner(scriptReader, fileName, absolutePath, depth);
                                        recursiveRunner.run(collectionManager);
                                    } else {
                                        System.out.println("Достигнут предел глубины рекурсии, выполнение скрипта остановлено.");
                                    }
                                    break; // Останавливаем текущий case после выполнения
                                }

                                // Если нет рекурсии, выполняем скрипт как обычно
                                BufferedReader scriptReader = new BufferedReader(new FileReader(scriptFile));
                                Runner newRunner = new Runner(scriptReader, fileName, absolutePath, -1);
                                newRunner.run(collectionManager);
                            }

                        } catch (FileNotFoundException e) {
                            System.out.println("Файл не найден");
                        } catch (IOException e) {
                            System.out.println("Ошибка при чтении скрипта: " + e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("Введите корректное число для глубины рекурсии");
                        }
                        break;

                    default:
                        System.out.println("Команда не распознана");
                }

            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения команды");
        }
    }
}
