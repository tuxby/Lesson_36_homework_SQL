# Lesson_36_homework_SQL

Test CODE:
```java
public static void main(String[] args) throws Exception {

        Users users160 =new Users();
        users160.createTable();
        users160.addUser("Vasya","Pupkin");
        users160.addUser("Ivan","Kyklochev");
        users160.addUser("Masha","Rykikryki");
        users160.addUser("Ostap","Bender");
        users160.addUser("Britney","Spears");

        Pets pets160 = new Pets();
        pets160.createTable();
        pets160.addPet("Tom","cat",2,5,1);
        pets160.addPet("Jerry","mouse",1,1,4);
        pets160.addPet("Duck","goose",1,3,5);
        pets160.addPet("Goofy","dog",4,11,5);

        System.out.println(users160.toString());
        System.out.println(pets160.toString());

        users160.deleteUser("Britney","Spears");
        System.out.println(users160.toString());
        System.out.println(pets160.toString());

    }
```   
Output:

+---------------------------------------+
|            Table users160             |
+----+-----------------+----------------+
| ID |   FIRST NAME    |   LAST NAME    |
+----+-----------------+----------------+
| 1  | Vasya           | Pupkin         |
| 2  | Ivan            | Kyklochev      |
| 3  | Masha           | Rykikryki      |
| 4  | Ostap           | Bender         |
| 5  | Britney         | Spears         |
+----+-----------------+----------------+

+----+------------+------------+------+------+------------------+
|                       Table pets160                           |
+----+------------+------------+------+------+------------------+
| ID |    NAME    |   TYPE     | AGE  |WEIGHT|       USER       |
+----+------------+------------+------+------+------------------+
| 1  | Tom        | cat        | 2    | 5    | Vasya Pupkin     |
| 2  | Jerry      | mouse      | 1    | 1    | Ostap Bender     |
| 3  | Duck       | goose      | 1    | 3    | Britney Spears   |
| 4  | Goofy      | dog        | 4    | 11   | Britney Spears   |
+----+------------+------------+------+------+------------------+

+---------------------------------------+
|            Table users160             |
+----+-----------------+----------------+
| ID |   FIRST NAME    |   LAST NAME    |
+----+-----------------+----------------+
| 1  | Vasya           | Pupkin         |
| 2  | Ivan            | Kyklochev      |
| 3  | Masha           | Rykikryki      |
| 4  | Ostap           | Bender         |
+----+-----------------+----------------+

+----+------------+------------+------+------+------------------+
|                       Table pets160                           |
+----+------------+------------+------+------+------------------+
| ID |    NAME    |   TYPE     | AGE  |WEIGHT|       USER       |
+----+------------+------------+------+------+------------------+
| 1  | Tom        | cat        | 2    | 5    | Vasya Pupkin     |
| 2  | Jerry      | mouse      | 1    | 1    | Ostap Bender     |
+----+------------+------------+------+------+------------------+


Process finished with exit code 0
