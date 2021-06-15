# Project description!

В данном проетке были реализованы команды:
- --resize  resize the image                                      (требуемые параметры: -he, -w, inputFile, outputFile)
- --quality PEG/PNG compression level                             (требуемые параметры: -q, inputFile, outputFile; возможны доп параметры: -w, -he)
- --crop    сut out one or more rectangular regions of the image  (требуемые параметры: -he, -w, -x, -y, inputFile, outputFile)
- --blur    reduce image noise and reduce detail levels           (требуемые параметры: -b, inputFile, outputFile)
- --format  output formatted image characteristics                (требуемые параметры: -f, inputFile, outputFile)

Необходимые параметры для выполнения команд:
-  -he  height      (defaultValue = 0) 
-  -w   width       (defaultValue = 0) 
-  -q   quality     (defaultValue = 0) - допустимые зачения: 0 - 100
-  -b   blur radius (defaultValue = 0)
-  -x   x           (defaultValue = 0)
-  -y   y           (defaultValue = 0)
-  -f   formats     (defaultValue = 0)
-  inputFile путь к файлу картинки         (defaultValue = "File not found")      -   обязательный параметр
-  outputFile путь к файлу для сохранения  (defaultValue = "File not found")      -   обязательный параметр

Примеры запроса:
-  --resize  -he 500 -w 500 src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg src/main/java/mts/teta/resizer/picture/123.jpg
-  --quality -q 50 src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg src/main/java/mts/teta/resizer/picture/123.jpg
-  --crop -he 500 -w 500 -x 200 -y 300 src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg src/main/java/mts/teta/resizer/picture/123.jpg
-  --blur -b 10 src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg src/main/java/mts/teta/resizer/picture/123.jpg
-  --format -f PNG src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg src/main/java/mts/teta/resizer/picture/123

Для расширеня проекта или изменения реализации существует интерфейс "OperationService". Для добовления новой команды необходимо добавить её в интерфейс и реализовать в "ValidOperation" 
и "OperationServiceImpl". Если для команды требуется патаметр, которого нету в существющих, добавте его в классе "ConsoleAttributes".

