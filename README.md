# Student Record System (Java)

A simple console application to manage Student and Teacher records.
Made for Java Programming (22ITC02N) - Assignment II.

## Concepts Used

| Concept | Where |
|---|---|
| Inheritance | `Student` and `Teacher` extend `Person` |
| Method Overriding | `describe()`, `getRole()`, `toFileLine()` |
| Interface | `Describable` |
| Collections | `HashMap` and `ArrayList` in `RecordManager` |
| Multithreading | `AutoSaver` thread saves data every 10 seconds |
| Exception Handling | `RecordNotFoundException`, `NumberFormatException`, `IOException` |
| Java NIO | `Path`, `Paths`, `Files` in `FileHandler` |

## Project Structure

```
src/
  Describable.java           interface
  Person.java                abstract base class
  Student.java               child class
  Teacher.java               child class
  RecordNotFoundException.java  custom exception
  RecordManager.java         stores records (collections)
  FileHandler.java           save/load using NIO
  AutoSaver.java             background thread
  Main.java                  menu
screenshots/                 add your output screenshots here
```

## How to Run

```bash
mkdir out
javac -d out src/*.java
java -cp out Main
```

Records are saved in `data/records.csv` and loaded again on the next run.

## Features
1. Add Student
2. Add Teacher
3. View all records
4. Search by ID
5. Delete by ID
6. Exit (auto-saves)

## Screenshots
Add your screenshots in the `screenshots/` folder.
