<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.briup.app.estore.shoppingcart.ShoppingCart, java.util.*, com.briup.app.estore.bean.Orderline" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
		<%@include file="/header.jsp" %>

<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>FamilyCart电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					购物清单
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>数量</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>合计</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
        
        	<%
    			ShoppingCart sc = (ShoppingCart)session.getAttribute("shoppingCart");
        		double cost = sc.getCost();
        		Map<Integer, Orderline> lines = sc.getLines();
        		session.setAttribute("lines", lines);
        		session.setAttribute("cost", cost);
      
        		/* for (Map.Entry<Integer, Orderline> line1: lines.entrySet()) {
        			out.write("key="+line1.getKey()+"value="+line1.getValue());
        		} */
    		%>
    		
    		<%-- <c:forEach items="${lines}" var="line">
    			<c:out value="${line.key }"></c:out>
    			<c:out value="${line.value}"></c:out>
    			<c:out value="${line.value.book.id}"></c:out>
    			<c:out value="${line.value.book.name}"></c:out>
    			<c:out value="${line.value.book.price}"></c:out>
    		</c:forEach> --%>
    	<c:forEach items="${lines}" var="line">	
        <tr>
			<form method="post" action="EditOrderline" name="f1">
			<input type="hidden" name="line" value="${line.key}">
			<!-- <input type="hidden" name="number" value="1"> -->
			<td class=tablebody2 valign=middle align=center width="">${line.value.book.id}</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="productDetail.jsp?productid=2">${line.value.book.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">${line.value.book.price}</td>
			<td class=tablebody1 valign=middle align=center width=""><input type="text" name="num" value="${line.value.num }" size="4" onblur="javascript:if(this.value<1){alert('对不起，产品数量不能小于 1 ');this.focus();}else{number.value=this.value;}"/></td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;${(line.value.num)*(line.value.book.price) }</td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="删除" onclick="javascript:window.location='DelOrderline?bookId=${line.key}';"> <input type="submit" value="保存修改"></td>
			</form>
		</tr>
		</c:forEach>
                
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">&nbsp;&nbsp;<font color="#ff0000"><b>${cost}</b></font></td>
			<td class=tablebody1 valign=middle align=center width="">　</td>
		</tr>
                
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="6">
			<input type="button" value="提交订单" onclick="javascript:window.location='user/confirmOrder.jsp';"> 
			<input type="button" value="继续购物" onclick="javascript:window.location='index.jsp';"> 
			<input type="button" value="清空购物车" onclick="javascript:window.location='ClearCart';"></td>
		</tr>
                </table><br>
<!--文件尾开始-->
		<%@include file="/footer.jsp" %>
	</body>
</html>
