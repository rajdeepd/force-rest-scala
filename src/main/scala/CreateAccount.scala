object CreateAccount{
	def main(args: Array[String]): Unit = {
	    val sObject = new SObject("Account")
	    val json = """{"name":"Account1"}"""
	    sObject.createSObject(json)
	}
}
