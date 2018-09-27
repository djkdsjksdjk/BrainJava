<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h4>${sessionScope.CUSTOMER.customerName}님의 구매 내역</h4>
<table border =1>
 <tr>
  <td>순번</td><td>물품명</td><td>개수</td><td>구매액</td>
  <td>구매액</td><td>구매일</td>
 </tr>
 <c:forEach var="BUY" items="${BUY_LIST}" varStatus="buyLoopCount">
  <tr>
   <td>
    ${buyLoopCount.count}</a>
   </td>
   <td>${BUY.good.gname}</td>
   <td>${BUY.qty}</td>
   <td>${BUY.good.price}</td>
   <td>${BUY.buyPrice}</td>
   <td>${BUY.buyDate}</td>
   </tr>
 </c:forEach>
</table>