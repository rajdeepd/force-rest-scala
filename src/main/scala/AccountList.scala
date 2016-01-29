object AccountList{
	def main(args: Array[String]): Unit = {
	    val sObject = new SObject("Account")
	    val body = sObject.getList()
		println(body)
	}
}
