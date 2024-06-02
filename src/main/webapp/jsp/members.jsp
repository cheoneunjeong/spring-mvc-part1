<%--
  Created by IntelliJ IDEA.
  User: 0102s
  Date: 2024-06-02
  Time: 오후 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> memberList = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
        <th>id</th>
        <th>username</th>
        <th>age</th>
    </thead>
    <tbody>
<%--    <% for(Member member : memberList) { %>
        <tr>
            <td><%=member.getId()%></td>
            <td><%=member.getUsername()%></td>
            <td><%=member.getAge()%></td>
        </tr>
    <% } %>--%>
    <%
        for (Member member : memberList) {
            out.write("<tr>");
            out.write("<td>" + member.getId() + "</td>");
            out.write("<td>" + member.getUsername() + "</td>");
            out.write("<td>" + member.getAge() + "</td>");
            out.write("</tr>");
        }
    %>
    </tbody>
</table>
<a href="/index.html">메인</a>
</body>
</html>
