# OracleDBConnect
This is a sample JAVA project that shows how to connect to ORACLE XE local database and running simple CRUD queries.

CRUD: Create, Update, Delete, Insert operations

Project runs on oracle driver which is ojdbc14.jar.

There is a table on oracle XE local db called eduman.operand_config_test with
-OPERAND_ID,
-OPERAND_NAME,
-OPERAND_SYMBOL columns

All operations will be done on this table, it looks like:
![](https://user-images.githubusercontent.com/11629459/31339838-de81dffe-ad0c-11e7-9362-af595379a4d8.png)

### Search on Database

After SEARCH executed on table Android studio OUTPUT:
```
INFO> Database Connection is successful!

INFO> DB VALUES:
1.  1 Add	  +
2.  2 Subtract	  -
3.  3 Multiply	  *
4.  4 Divide	  /
5.  5 Power	  p
6.  7 Module	  M
```
All table's inputs are listed successfully:)

### Insertion on Database

After INSERT executed on table Android studio OUTPUT:
```
INFO> Database Connection is successful!

INFO> 1 row(s) inserted!

```
OUTPUT after insertion
```
INFO> DB VALUES:
1.  1 Add	  +
2.  2 Subtract	  -
3.  3 Multiply	  *
4.  4 Divide	  /
5.  5 Power	  p
6.  8 NEW SQUARE	  N
7.  7 Module	  M
```
A new input (NEW SQUARE) added successfully:)

### Update on Database

After UPDATE executed on table Android studio OUTPUT:
```
INFO> Database Connection is successful!

INFO> 1 row(s) updated!

```
OUTPUT after update
```
INFO> DB VALUES:
1.  1 Add	  +
2.  2 Subtract	  -
3.  3 Multiply	  *
4.  4 Divide	  /
5.  5 Power	  p
6.  8 Square	  S
7.  7 Module	  M
```
"NEW SQUARE" updated to "Square" successfully.

![image](https://user-images.githubusercontent.com/11629459/31438028-1c7a574e-ae90-11e7-93b7-ac7e64eb127d.png)


### Deletion on Database

After DELETE executed on table Android studio OUTPUT:
```
INFO> Database Connection is successful!

INFO> 1 row(s) deleted!

INFO> Database Connection closed!
```
OUTPUT after Delete
```
INFO> DB VALUES:
1.  1 Add	  +
2.  2 Subtract	  -
3.  3 Multiply	  *
4.  4 Divide	  /
5.  5 Power	  p
6.  7 Module	  M
```
"Square" with operand_id = 8 deleted successfully.

![image](https://user-images.githubusercontent.com/11629459/31438975-1c4e9d18-ae93-11e7-9f69-1b53d73a8747.png)

Project can be tested simply/easily with changing executionType value as (S)Search, (U)Update, (D)Delete, (I)Insert.

(Android Studio 2.3.3 IDE and PLSQL DEVELOPER 12.0.4 tools had been used while working on this project.)