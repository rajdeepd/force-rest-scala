import java.io._
import org.apache.commons._
import org.apache.http._
import org.apache.http.client._
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import java.util.ArrayList
import org.apache.http.message.BasicNameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.client.ResponseHandler
import org.json.JSONObject
import org.json.JSONTokener
import com.typesafe.config._
import com.google.gson.Gson
import org.apache.http.client.methods.HttpGet
import org.apache.http.entity.StringEntity

class SObject(sObjectN : String) {
	var sObjectName: String = sObjectN

	def getList() : String = {
		val host = "https://ap2.salesforce.com"
		val baseUrl = "/services/data/v35.0/sobjects/"
		val util = new Util()

		val access_token = util.getAccessToken()
		println(access_token)
	    val url = host + baseUrl + sObjectName
		val request = new HttpGet(url)

		request.addHeader("Authorization", "Bearer " + access_token)
		request.addHeader("Content-type", "application/json")
		val client = new DefaultHttpClient
		val response = client.execute(request)
		val handler = new BasicResponseHandler()
		val body = handler.handleResponse(response)
		return body
    }

    def createSObject(jsonData : String)  =  {
    	/*
    	access_token = get_access_token()['access_token']
	    access_token_header = {'Authorization': 'Bearer ' + access_token,
	                           'Content-type': 'application/json'}

	    url = base_url + object_name
	    json_data = json.dumps(data)

	    conn = get_connection()
	    conn.request("POST", url, json_data, access_token_header)
    	*/
    	val host = "https://ap2.salesforce.com"
		val baseUrl = "/services/data/v35.0/sobjects/"
		val util = new Util()

		val access_token = util.getAccessToken()
		println(access_token)
		val url = host + baseUrl + sObjectName
		val post = new HttpPost(url)
 
		// set the Content-type
		post.addHeader("Authorization", "Bearer " + access_token)
		post.setHeader("Content-type", "application/json")
		 
		// add the JSON as a StringEntity
		post.setEntity(new StringEntity(jsonData))
	
		// send the post request
		val response = (new DefaultHttpClient).execute(post)
		println(response)
		//return response

    }

    def deleteSObject() {

    }


}