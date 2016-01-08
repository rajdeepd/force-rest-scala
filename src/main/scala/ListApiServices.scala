    object ListApiServices {
	    def main(args: Array[String]): Unit = {
	    	//println("Hello, world!")
	    	try {
			  val content = get("https://ap2.salesforce.com/services/data")
			  println(content)
			} catch {
			  case ioe: java.io.IOException =>  // handle this
			  case ste: java.net.SocketTimeoutException => // handle this
			}
	    }
	    def get(url: String) = scala.io.Source.fromURL(url).mkString
    }