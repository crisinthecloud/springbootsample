import groovy.json.JsonOutput;

println "REST Groovy Script"
println "arg0:" + args[0]
if (args.length > 1)
	println "arg1:" + args[1]

def doPost(Map params) {
	//def connection = new URL( "http://localhost:9092/resources/deliverys" +
	//"http://localhost:9091/resources/artifactSWs?numPage=0&pageSize=10&filters=id[eq]1&order=idDes"
	def connection = new URL( params.url +
			URLEncoder.encode(
					"",
					'UTF-8' ) )
		.openConnection() as HttpURLConnection

	// set some headers
	connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
	connection.setRequestProperty( 'Accept', 'application/json' )
	println "Method: " + params.method
	connection.requestMethod = params.method
    connection.setRequestProperty("charset", "utf-8");

	if (params.method == "POST" || params.method == "PUT") {
		println "Sending body..."
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Content-Length", Integer.toString( params.body.getBytes("UTF-8").length))
		connection.doOutput = true
		connection.outputStream.write(params.body.getBytes("UTF-8"))
	}

	def responseCode = connection.responseCode
	println "Response code: $responseCode"
	if (responseCode >= 300)
	  println "Error" + connection.errorStream.text
	if (responseCode < 300) {
	    def resultText = connection.inputStream.text
	    println JsonOutput.prettyPrint(resultText) 
	}

}


def jsons = [
crc : [
    desc : "Create client",
    url : "http://localhost:9091/resources/clients",
    method : "POST",
    body : '''
{
  "client" : {
    "name" : "Joe",
    "surname" : "Lee",
	"credit" : "2000"
  }
}
    '''
], //------------------
lic : [
    desc : "list Client",
    url : "http://localhost:9092/resources/accounts?numPage=0&pageSize=10&filters=name.eq.Joe&order=nameAsc",
	method : "GET",
	body : '''
{
}
    '''
], //------------------
cra : [
    desc : "Create Account",
    url : "http://localhost:9092/resources/accounts",
    method : "POST",
    body : '''
{
  "dtoAccount" : {
    "amount" : "3000",
	"dtoClient" : {
	    "id" : 1
	}
  }
}
    '''
], //------------------
lia : [
    desc : "list accounts",
    url : "http://localhost:9092/resources/accounts?numPage=0&pageSize=10&filters=&order=idAsc",
    method : "GET",
	body : '''
{
 
}
    '''
], //------------------
lit : [
    desc : "list transaction",
    url : "http://localhost:9093/resources/transactions?numPage=0&pageSize=10&filters=&order=idAsc",
    method : "GET",
	body : '''
{
 
}
    '''
], //------------------
crt : [
    desc : "Create Transaction",
    url : "http://localhost:9093/resources/transactions",
    method : "POST",
    body : '''
{
  "dtoTransaction" : {
    "amount" : "3000",
	"type" : "IN",
	"dtoAccount" : {
		"id" : 1,
		"dtoClient" : {
			"id" : 1
		}
	}
  }
}
    '''
], //------------------
gc1 : [
    desc : "Get Client 1",
    url : "http://localhost:9091/resources/clients/1",
	method : "GET",
	body : '''
{
}
    '''
] //------------------
   
] // End Use cases


switch (args[0]) {
	case "CU" : 
	    println "Uee case: " + args[1]
		println "Request:" 
		println jsons[args[1]]
		doPost(url: jsons[args[1]].url, body: jsons[args[1]].body, method : jsons[args[1]].method)
	    break;
	case "HELP":
		println "List of Use Cases:"
		jsons.each { entry ->
			println entry.key + "  " + entry.value.desc
		}
}



