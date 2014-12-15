<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="javax.portlet.PortletPreferences" %>


<portlet:defineObjects />

<%

PortletPreferences prefs = renderRequest.getPreferences();
String greeting = (String) prefs.getValue("greeting", "No value for such key.");
%>

<%= greeting %>

<aui:form action="Chat" method="post">
    <aui:input label="greeting" name="greeting" type="text" value="<%= greeting %>" />
    <aui:button type="submit" />
</aui:form>

<div style="height:250px;overflow-y:auto;">
	<div>
		<h5 style="margin-bottom:0px;">Muhammad Harits :</h5>
		<p style="margin-left:15px;">Halo gan, sukses selalu!</p>
	</div>
	<div>
		<h5 style="margin-bottom:0px;">Aldi Doanta :</h5>
		<p style="margin-left:15px;">Websitenya imba!</p>
	</div>
	<div>
		<h5 style="margin-bottom:0px;">Aldy Wirawan :</h5>
		<p style="margin-left:15px;">Websitenya imba!</p>
	</div>
	<div>
		<h5 style="margin-bottom:0px;">Sonny Lazuardi :</h5>
		<p style="margin-left:15px;">Websitenya imba!</p>
	</div>
	<div>
		<h5 style="margin-bottom:0px;">Genta Indra Winata :</h5>
		<p style="margin-left:15px;">Websitenya imba!</p>
	</div>
	<div>
		<h5 style="margin-bottom:0px;">Kelvin Valensius :</h5>
		<p style="margin-left:15px;">Websitenya imba!</p>
	</div>
	<div>
		<h5 style="margin-bottom:0px;">Pandu Kartika Putra :</h5>
		<p style="margin-left:15px;">Websitenya imba!</p>
	</div>
</div>
<hr>
<div>
	<input style="width:95%;" type="text" placeholder="Name"></br>
	<textarea style="width:95%" class="form-control" rows="3" placeholder="Message"></textarea></br>
	<div style="text-align:right"><button type="button" class="btn btn-default">Submit</button>
	</div>
</div>