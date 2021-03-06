<%@page import="com.test.service.MessageLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="java.util.List" %>
<%@ page import="com.test.model.Message" %>

<portlet:defineObjects />

<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String name = (String)prefs.getValue("name", "");
	String[] names = (String[])renderRequest.getAttribute("names");
	String[] msgs = (String[])renderRequest.getAttribute("msgs");;
	Integer counter = (Integer)renderRequest.getAttribute("counter");
	List<Message> messages = MessageLocalServiceUtil.getMessages();
%>
<portlet:actionURL var="editGreetingURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:actionURL>



<div style="height:250px;overflow-y:auto;">
	<% 
		for(Message m: messages){
			out.println("<div>");
			out.println("<h5 style=\"margin-bottom:0px;\">" + m.getUserName() + "</h5>");
			out.println("<p style=\"margin-left:15px;\">"+ m.getContent() +"</p>");
			out.println("</div>");
		}
/*		for (int i=0;i<names.length;i++){
			out.println("<div>");
			out.println("<h5 style=\"margin-bottom:0px;\">" + names[i] + "</h5>");
			out.println("<p style=\"margin-left:15px;\">"+names[i]+"</p>");
			out.println("<p style=\"margin-left:15px;\">"+msgs[i]+"</p>");
			out.println("</div>");
		}
*/
	%>
</div>
<hr>
<div>

	<aui:form action="<%= editGreetingURL %>" method="post">
	    <input name="<portlet:namespace/>name" id="<portlet:namespace/>name" style="width:95%;" type="text" placeholder="Name" value="<%= name %>"><br>
		<textarea name="<portlet:namespace/>msg" id="<portlet:namespace/>msg" style="width:95%" class="form-control" rows="3" placeholder="Message"></textarea><br>
	    <aui:button type="submit" />
	</aui:form>
</div>