-- 执行用时: 621 ms
SELECT user_id,MAX(time_stamp) AS last_stamp FROM Logins
WHERE time_stamp REGEXP '2020.*' GROUP BY user_id;


-- 执行用时： 595 ms , 在所有 MySQL 提交中击败了 90.42% 的用户
-- 内存消耗：0 B, 在所有 MySQL 提交中击败了100.00%的用户
SELECT user_id,MAX(time_stamp) AS last_stamp FROM Logins
WHERE time_stamp >= '2020-01-01 00:00:00' AND time_stamp <= '2020-12-31 23:59:59' GROUP BY user_id