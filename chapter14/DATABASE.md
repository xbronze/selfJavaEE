
### 1.创建数据库`db_ssm`
```sql
CREATE DATABASE `db_ssm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

```

### 2.创建表`orders`
```sql
-- db_ssm.orders definition

CREATE TABLE `orders` (
  `number` varchar(50) NOT NULL,
  `member_id` varchar(50) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `count` int DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

### 3.向表`orders`中添加几条数据
```sql
INSERT INTO db_ssm.orders (`number`, member_id, product_name, count, money) VALUES('1001', '1', '手机', 1, 4300);
INSERT INTO db_ssm.orders (`number`, member_id, product_name, count, money) VALUES('1002', '2', '净化器', 2, 3500);
INSERT INTO db_ssm.orders (`number`, member_id, product_name, count, money) VALUES('1003', '1', '空调', 3, 3000);
INSERT INTO db_ssm.orders (`number`, member_id, product_name, count, money) VALUES('1004', '1', '电脑', 10, 5000);

```