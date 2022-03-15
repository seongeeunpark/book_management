<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<script type="text/javascript">

</script>
</head>
<body>
<h2>등록하기</h2>
<h2>도서정보관리-도서추가</h2>
<form:form commandName="formData" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<td rowspan="6"><img id="image" height="300" width="300"/></td>
			
		</tr>
		<tr>
			<td>BOOK ISBN</td>
			<td><form:input path="isbn"/><form:errors path ="isbn"/></td>
		</tr>
		
		<tr>
			<td>도서명</td>
			<td><form:input path="name"/>
			<form:errors path = "name"/></td>
		</tr>
		
		
		<tr>
			<td>저자</td>
			<td><form:input path="author"/>
			<form:errors path = "author"/></td>
		</tr>
		
		
		<tr>
			<td>출판사</td>
			<td><form:input path="publisher"/>
			<form:errors path = "publisher"/></td>
		</tr>
		
		
		<tr>
			<td>도서 가격</td>
			<td><form:input path="price"/>
				<form:errors path = "price"/>
			</td>
		</tr>
		
		<tr>
			<td>이미지</td>
			<td><form:input path="image" id="img" type="file" accept="image/*"/>
			<form:errors path = "image"/>
			</td>			
		</tr>

		<tr>
			<td>책 소개</td>
			<td><form:textarea path="introduction"/>
					<form:errors path = "introduction"/>
			</td>			
		</tr>    
		
 </table>
 <input type="submit" value="도서정보 추가" />
 <input type="button" value="도서정보 목록" onclick="window:location='<c:url value ='/list' />'">
  
  <script>
	document.getElementById("img").onchange=function(){
		var reader = new FileReader();
		reader.onload = function(e){
			document.getElementById("image").src = e.target.result;
		};
		reader.readAsDataURL(this.files[0]);
	};
	
	
</script>
   </form:form>
</html>