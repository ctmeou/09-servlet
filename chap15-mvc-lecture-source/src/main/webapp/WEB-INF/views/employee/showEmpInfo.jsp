<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원 정보</title>
</head>
<body>
    <h1>${ param.empId }번 사원의 정보</h1>
    <h4>사원명 : ${ selectedEmp.empName }</h4>
    <h4>부서 코드 : ${ selectedEmp.deptCode }</h4>
    <h4>직급 코드 : ${ selectedEmp.jobCode }</h4>
    <h4>월급 : ${ selectedEmp.salary }</h4>
</body>
</html>
