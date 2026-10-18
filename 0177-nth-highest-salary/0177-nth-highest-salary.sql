create function getNthHighestSalary(N int) returns int
begin
return(

select distinct salary from(select salary,DENSE_RANK() over(order by salary desc) as rnk from Employee) ranked where rnk=N);
end

 