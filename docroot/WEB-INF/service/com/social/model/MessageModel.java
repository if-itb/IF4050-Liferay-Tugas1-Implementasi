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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Message service. Represents a row in the &quot;socialservice_Message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.social.model.impl.MessageModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.social.model.impl.MessageImpl}.
 * </p>
 *
 * @author alifradityar
 * @see Message
 * @see com.social.model.impl.MessageImpl
 * @see com.social.model.impl.MessageModelImpl
 * @generated
 */
public interface MessageModel extends BaseModel<Message> {
	/**
	 * Returns the primary key of this message.
	 *
	 * @return the primary key of this message
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this message.
	 *
	 * @param primaryKey the primary key of this message
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the message ID of this message.
	 *
	 * @return the message ID of this message
	 */
	public long getMessageId();

	/**
	 * Sets the message ID of this message.
	 *
	 * @param messageId the message ID of this message
	 */
	public void setMessageId(long messageId);

	/**
	 * Returns the title of this message.
	 *
	 * @return the title of this message
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this message.
	 *
	 * @param title the title of this message
	 */
	public void setTitle(String title);

	/**
	 * Returns the content of this message.
	 *
	 * @return the content of this message
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this message.
	 *
	 * @param content the content of this message
	 */
	public void setContent(String content);

	/**
	 * Returns the date of this message.
	 *
	 * @return the date of this message
	 */
	public Date getDate();

	/**
	 * Sets the date of this message.
	 *
	 * @param date the date of this message
	 */
	public void setDate(Date date);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Message message);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Message> toCacheModel();

	@Override
	public Message toEscapedModel();

	@Override
	public Message toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}