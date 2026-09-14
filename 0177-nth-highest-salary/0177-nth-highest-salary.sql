CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

  RETURN (
   select distinct salary from(select salary,DENSE_RANK() over(order by salary desc) as rnk from Employee) as ranked where rnk=N

  );
END