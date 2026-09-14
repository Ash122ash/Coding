# Write your MySQL query statement below
select a.firstname,a.lastname,b.city,b.state from Person a Left JOIN Address b ON a.personId=b.personId;