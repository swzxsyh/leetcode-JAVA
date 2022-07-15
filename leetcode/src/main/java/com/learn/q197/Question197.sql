-- 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
-- 返回结果 不要求顺序 。

SELECT w1.`id`
FROM Weather AS w1
         LEFT JOIN Weather w2
                   ON w1.recordDate = date_add(w2.recordDate, interval 1 day)
WHERE w1.Temperature > w2.Temperature
ORDER BY w1.recordDate ASC;