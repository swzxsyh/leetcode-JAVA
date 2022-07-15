-- 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。


SELECT name AS `Customers`
FROM Customers
WHERE Customers.id NOT IN (SELECT CustomerId FROM Orders);


SELECT Customers.name AS `Customers`
FROM Customers
         LEFT JOIN Orders ON Customers.id = Orders.CustomerId WHERE Orders.CustomerId is null