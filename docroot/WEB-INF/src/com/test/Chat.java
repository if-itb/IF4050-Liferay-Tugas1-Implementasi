package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Chat
 */
public class Chat extends MVCPortlet {
 
	public int counter = 0;
	public List<String> names;
	public List<String> msgs;
	
	void first(){
		names = new ArrayList<String>();
		msgs = new ArrayList<String>();
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute("counter", counter);
		if (names == null){
			first();
		}
		String[] ar1 = names.toArray(new String[names.size()]);
		String[] ar2 = msgs.toArray(new String[msgs.size()]);
		renderRequest.setAttribute("names", ar1);
		renderRequest.setAttribute("msgs", ar2);
	    super.doView(renderRequest, renderResponse);
	}
	
	@Override
    public void processAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException {
		PortletPreferences prefs = actionRequest.getPreferences();
        String name = actionRequest.getParameter("name");
        String msg = actionRequest.getParameter("msg");
        if (name == null)
        	name = "";
        if (msg == null)
        	msg = "";
        if (names == null)
        	first();
        System.out.println(name + ": " + msg);
        names.add(name);
        msgs.add(msg);
		counter++;
        super.processAction(actionRequest, actionResponse);
    }
}
