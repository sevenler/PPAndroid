package com.xququ.audio2dcodedemo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.mashape.client.authentication.Authentication;
import com.mashape.client.authentication.MashapeAuthentication;
import com.mashape.client.http.ContentType;
import com.mashape.client.http.HttpClient;
import com.mashape.client.http.HttpMethod;
import com.mashape.client.http.MashapeCallback;
import com.mashape.client.http.MashapeResponse;
import com.mashape.client.http.ResponseType;

public class Audio2DCode
{

	private final static String PUBLIC_DNS = "zhulianxing-audio-2d-code.p.mashape.com";
	private List<Authentication> authenticationHandlers;

	public Audio2DCode(String mashapeKey)
	{
		authenticationHandlers = new LinkedList<Authentication>();
		authenticationHandlers.add(new MashapeAuthentication(mashapeKey));

	}

	/**
	 * Synchronous call with optional parameters.
	 */
	public MashapeResponse<String> download(String dataToken)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (dataToken != null && !dataToken.equals(""))
		{
			parameters.put("dataToken", dataToken);
		}

		return (MashapeResponse<String>) HttpClient.doRequest(String.class,
				HttpMethod.POST, "https://" + PUBLIC_DNS + "/download.php",
				parameters, ContentType.FORM, ResponseType.STRING,
				authenticationHandlers);
	}

	/**
	 * Asynchronous call with optional parameters.
	 */
	public Thread download(String dataToken, MashapeCallback<String> callback)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (dataToken != null && !dataToken.equals(""))
		{

			parameters.put("dataToken", dataToken);
		}

		return HttpClient.doRequest(String.class, HttpMethod.POST, "https://"
				+ PUBLIC_DNS + "/download.php", parameters, ContentType.FORM,
				ResponseType.STRING, authenticationHandlers, callback);
	}

	/**
	 * Synchronous call with optional parameters.
	 */
	public MashapeResponse<String> getWave(String dataToken)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (dataToken != null && !dataToken.equals(""))
		{
			parameters.put("dataToken", dataToken);
		}

		return (MashapeResponse<String>) HttpClient.doRequest(String.class,
				HttpMethod.POST, "https://" + PUBLIC_DNS + "/getwave.php",
				parameters, ContentType.FORM, ResponseType.STRING,
				authenticationHandlers);
	}

	/**
	 * Asynchronous call with optional parameters.
	 */
	public Thread getWave(String dataToken, MashapeCallback<String> callback)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (dataToken != null && !dataToken.equals(""))
		{

			parameters.put("dataToken", dataToken);
		}

		return HttpClient.doRequest(String.class, HttpMethod.POST, "https://"
				+ PUBLIC_DNS + "/getwave.php", parameters, ContentType.FORM,
				ResponseType.STRING, authenticationHandlers, callback);
	}

	/**
	 * Synchronous call with optional parameters.
	 */
	public MashapeResponse<String> upload(String dataContent)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (dataContent != null && !dataContent.equals(""))
		{
			parameters.put("dataContent", dataContent);
		}

		return (MashapeResponse<String>) HttpClient.doRequest(String.class,
				HttpMethod.POST, "https://" + PUBLIC_DNS + "/upload.php",
				parameters, ContentType.FORM, ResponseType.STRING,
				authenticationHandlers);
	}

	/**
	 * Asynchronous call with optional parameters.
	 */
	public Thread upload(String dataContent, MashapeCallback<String> callback)
	{
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (dataContent != null && !dataContent.equals(""))
		{

			parameters.put("dataContent", dataContent);
		}

		return HttpClient.doRequest(String.class, HttpMethod.POST, "https://"
				+ PUBLIC_DNS + "/upload.php", parameters, ContentType.FORM,
				ResponseType.STRING, authenticationHandlers, callback);
	}

}