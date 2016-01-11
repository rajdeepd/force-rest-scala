object DeleteAccount{
	    def main(args: Array[String]): Unit = {
	    	val sObject = new SObject("Account")
	    	val objectId = "0012800000DR2Ko"
	    	sObject.deleteSObject(objectId)
	    }
}
