<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="myutil.Multipart" %>
<%@ page import="java.net.URLEncoder" %>

<%
Multipart multipart = new Multipart(request);

String title = multipart.getParameter("TITLE");
String description = multipart.getParameter("DESCRIPTION");

String fileName = multipart.getFileName("UPLOAD_FILE");
String newPath = application.getRealPath("/product/image/" + fileName);
multipart.saveFile("UPLOAD_FILE", newPath);

String url = String.format("UploadResult.jsp?TITLE=%s&DESCRIPTION=%s&FILE_NAME=%s",
URLEncoder.encode(title, "UTF-8"),
URLEncoder.encode(description, "UTF-8"),
URLEncoder.encode(fileName, "UTF-8"));

response.sendRedirect(url);
%>