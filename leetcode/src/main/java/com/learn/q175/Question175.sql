SELECT `Person`.`FirstName` ,
       `Person`.`LastName`  ,
       `Address`.City       ,
       `Address`.State
FROM `Person`
         INNER JOIN `Address`
                   ON `Person`.PersonId = `Address`.PersonId