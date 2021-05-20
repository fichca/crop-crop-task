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

P.S. Я понимаю что отошел с данной реализацей запроса от ТЗ, но все же решил сделать так. Если это никуда не годиться, напишете пожалуста, постараюсь успеть переделать.


# Greetings, traveller

Второй этап отбора на направление «Бэкенд разработка» в Летнюю школу [МТС.Тета](http://teta.mts.ru/).

## Сrop-crop-resize-resize

В качестве задания предлагается выполнить проект «crop-crop». Эта утилита позволит ресайзить изображение для остальных сервисов МТС: изменение изображений рекламных баннеров, превью для альбомов и обложки фильмов в маленьком разрешении и другие.

## Используемые технологии

- Код приложения пишется на Java.
- Библиотеки, которые можно использовать:
    - Работа с консольными параметрами [picocli.info](https://picocli.info/).
    - Работа с изображением [thumbnailator](https://github.com/coobird/thumbnailator). Рекомендуем взять из неё функции обрезки  и изменения параметров картинки.
    - Библиотека для работы с изображениями и видео [marvin project](https://github.com/gabrielarchanjo/marvin-framework). Рекомендуем взять из неё  GaussianBlur и Crop.
    - Библиотека, необходимая для запуска тестов [junit5](https://github.com/junit-team/junit5).

## Интерфейс взаимодействия

```bash
Version: name version https://gitlab.com/link/
Available formats: jpeg png webp
Usage: convert input-file [options ...] output-file
Options Settings:
  --resize width height       resize the image
  --quality value             PEG/PNG compression level
  --crop width height x y     сut out one or more rectangular regions of the image
  --blur {radius}             reduce image noise and reduce detail levels 
  --format "outputFormat"     output formatted image characteristics
```

## Описание параметров

**--resize width height** — уменьшает, увеличивает картинку или задает необходимый размер для изображения. [Пример в документации](https://imagemagick.org/script/command-line-options.php#resize).

**--quality value** — задает уровень сжатия файлов JPEG / PNG. Форматы изображений могут быть JPEG и PNG, качество от 1 (самое низкое качество изображения и самое высокое сжатие) до 100 (лучшее качество, но наименее эффективное сжатие). [Пример в документации](https://imagemagick.org/script/command-line-options.php#quality).

**--crop width height x y** —  Вырезает прямоугольную область изображения. Обработанное изображения должно иметь ширину(**width**) и высоту(**height**). Точка отсчета задаётся значениями **x** и **y.** [Пример из документации](https://imagemagick.org/script/command-line-options.php#crop).

**--blur radius** — добавляет размытие или увеличивает резкость. [Пример в документации](https://imagemagick.org/script/command-line-options.php#blur).

**--format "outputFormat"** — конвертирует изображение в "outputFormat". Параметр "outputFormat" может быть JPEG / PNG / WEBP. [Пример в документации](https://imagemagick.org/script/command-line-options.php#format).

Валидация входных параметров должна быть реализована. 

## Требования к проекту

1. Код проекта должен быть аккуратным, без дублирования. Наличие больших повторяющихся фрагментов кода может быть причиной снижения баллов.
2. Проект не должен отдавать изображение более, чем за 350 миллисекунд.

## Полная версия технического задания
Ты сможешь её найти [по ссылке](https://www.notion.so/edtech17/public-4a6da22b5a36489c99b9b986a4c9d7cb).
