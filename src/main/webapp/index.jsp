<%@include file="head.jsp"%>
<html>
<style>
    body {
        padding: 10px;
    }
</style>
<body>
    <h1>Search Users</h1>
    <h2>User Display Exercise - Week 1</h2>

    <form action="searchUser" method="get">

        <h3>Search Term (leave blank to search for all users)</h3>

        <input name="queryTerm" id="queryTerm" type="text" />

        <input type="submit"/>
    </form>
</body>
</html>