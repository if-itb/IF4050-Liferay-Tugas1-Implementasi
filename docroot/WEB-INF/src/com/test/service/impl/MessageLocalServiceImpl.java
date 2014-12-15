/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.test.model.Message;
import com.test.service.base.MessageLocalServiceBaseImpl;

/**
 * The implementation of the message local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.test.service.MessageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author alifradityar
 * @see com.test.service.base.MessageLocalServiceBaseImpl
 * @see com.test.service.MessageLocalServiceUtil
 */
public class MessageLocalServiceImpl extends MessageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.test.service.MessageLocalServiceUtil} to access the message local service.
	 */
	
	public void addMessage(String name, String content){
		try {
			Message message = createMessage(CounterLocalServiceUtil.increment());
			message.setUserName(name);
			message.setContent(content);
			addMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Message> getMessages(){
		List<Message> messages = null;
		try {
			messages = getMessages(0, getMessagesCount());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return messages;
	}
	
}