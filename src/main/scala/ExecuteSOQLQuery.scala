object ExecuteSOQLQuery{
	    def main(args: Array[String]): Unit = {
	    	val sObject = new SObject("Account")
	    	val json = """{"name":"Account1"}"""
	    	val soql  = """SELECT+name+from+Account"""
	    	val response = sObject.executeSOQL(soql)
	    	println("response:" + response)
	    }
}
