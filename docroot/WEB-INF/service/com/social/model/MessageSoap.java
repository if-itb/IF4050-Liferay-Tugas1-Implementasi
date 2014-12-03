/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.social.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.social.service.http.MessageServiceSoap}.
 *
 * @author alifradityar
 * @see com.social.service.http.MessageServiceSoap
 * @generated
 */
public class MessageSoap implements Serializable {
	public static MessageSoap toSoapModel(Message model) {
		MessageSoap soapModel = new MessageSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setDate(model.getDate());

		return soapModel;
	}

	public static MessageSoap[] toSoapModels(Message[] models) {
		MessageSoap[] soapModels = new MessageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MessageSoap[][] toSoapModels(Message[][] models) {
		MessageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MessageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MessageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MessageSoap[] toSoapModels(List<Message> models) {
		List<MessageSoap> soapModels = new ArrayList<MessageSoap>(models.size());

		for (Message model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MessageSoap[soapModels.size()]);
	}

	public MessageSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	private long _messageId;
	private String _title;
	private String _content;
	private Date _date;
}