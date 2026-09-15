CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT

BEGIN
  RETURN (
      # Write your MySQL query statement below.
      WITH SALARY_RANK AS(
        SELECT salary,
        DENSE_RANK() OVER (ORDER BY salary DESC)
       AS rnf 
      
      FROM Employee)

      SELECT DISTINCT salary FROM SALARY_RANK WHERE rnf=N
  );
END