-- 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
SELECT email
FROM `Person`
GROUP BY `Email`
HAVING COUNT(`Email`) > 1