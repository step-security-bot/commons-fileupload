package org.apache.commons.fileupload;

/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation" and
 *    "Apache Turbine" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    "Apache Turbine", nor may "Apache" appear in their name, without
 *    prior written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */

import junit.framework.TestCase;
import javax.servlet.http.HttpServletRequest;

/**
 * Unit tests {@link org.apache.commons.fileupload.FileUpload}.
 *
 * @author <a href="mailto:jmcnally@apache.org">John McNally</a>
 * @author Sean C. Sullivan
 * 
 */
public class FileUploadTest extends TestCase
{
	public void testWithInvalidRequest()
    {
    	FileUpload fu = null;
    	
    	fu = new FileUpload();
    	
    	HttpServletRequest req = HttpServletRequestFactory.createInvalidHttpServletRequest();


    	try
    	{
    		fu.parseRequest(req);
    		fail("testWithInvalidRequest: expected exception was not thrown");
    	}
    	catch (FileUploadException expected)
    	{
    		// this exception is expected
    	}
    	
    }


	public void testWithNullContentType()
    {
    	FileUpload fu = new FileUpload();
    	
    	HttpServletRequest req = HttpServletRequestFactory.createHttpServletRequestWithNullContentType();
    	
    	try
    	{
    		fu.parseRequest(req);
    		fail("testWithNullContentType: expected exception was not thrown");
    	}
    	catch (FileUpload.InvalidContentTypeException expected)
    	{
    		// this exception is expected
    	}
        catch (FileUploadException unexpected)
        {
    		fail("testWithNullContentType: unexpected exception was thrown");
        }
    	
    }


    public FileUploadTest(String name)
    {
        super(name);
    }

    public void testParseRequest() throws FileUploadException
    {
    	
    	String[] fileNames = 
    	{ 
			"filename1",
    		"filename2"
    	};
    	
		FileUpload fu = new FileUpload();
    	
		HttpServletRequest req = HttpServletRequestFactory.createValidHttpServletRequest(fileNames);
    	
		// todo java.util.List lst = fu.parseRequest(req);
		// todo assertNotNull(lst);
		
    }
}

