<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h4>${sessionScope.CUSTOMER.customerName}님의 구매 내역</h4>
<table border =1>
 <tr>
  <td>순번</td><td>구매날짜</td><td>구매가격</td></tr>
 <c:forEach var="BUY" items="${PRODUCT}" varStatus="buyLoopCount">
  <tr>
   <td>
    <c:url value="/product" var="viewDetailURL">
     <c:param name="method" value="viewBuyDetailList"/>
     <c:param name="buyId" value="${BUY.buyId}"/>
    </c:url>
    <a href="${viewDetailURL}">${buyLoopCount.count}</a>
    </td>
    <td>${BUY.buyDate}</td>
    <td>${BUY.buyPrice} 원</td>
   </tr>
 </c:forEach>
</table>