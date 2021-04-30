var app = angular.module("crisapp", []);

app.controller("TestController", function() {
    this.name = "Jignesh Trivedi";
});


app.controller("ClientController", ['$scope','$http', function($scope,$http) {
    this.hola = "Hola";

    console.log("Load ClientController");

    this.clients = [
		{
			"id" : 1,
			"firstname" : "Joe",
			"lastname" : "Lee (sample data)",
			"credit" : 1000
		},
		{
			"id" : 2,
			"firstname" : "Lis",
			"lastname" : "Dean (sample data)",
			"credit" : 2000
		}
    ];
	$scope.clients = this.clients;
	
	
	this.accounts = [
        //empty list
    ];
	$scope.accounts = this.accounts;
	
	this.transactions = [
        //empty list
    ];
	$scope.transactions = this.transactions;
    
	this.getClients = function(){
		console.log("read data...");
		$http.get("http://localhost:9091/resources/clients?filters=none")
		.then(function(response) {
			console.log("listclients request ok");
			console.log("clients: " + JSON.stringify(response));
			console.log(response.data);
			if (response.data.clients.length >0){
				console.log("There are clients");
				$scope.clients = response.data.clients;
			}
		}, function(error){
			$log.error("Request failed: "+JSON.stringify(error));
		});
	};
	this.getClients();
	
	this.createClient = function(){
		console.log("create...");
		var json = { 
			"client" : {
				"name" : $scope.firstname,
				"surname" : $scope.lastname,
				"credit" : $scope.credit
			}
		}
		$http.post("http://localhost:9091/resources/clients", json)
		.then(function(response) {
			console.log("createclient request ok");
		}, function(error){
			$log.error("create client failed: " + JSON.stringify(error));
		});
	};
	
	
	this.getAccounts = function(){
		console.log("read data...");
		$http.get("http://localhost:9092/resources/accounts?filters=none")
		.then(function(response) {
			console.log("listaccounts request ok");
			console.log("clients: " + JSON.stringify(response));
			console.log(response.data);
			if (response.data.accounts.length >0){
				console.log("There are accounts");
				$scope.accounts = response.data.accounts;
			}
		}, function(error){
			$log.error("Request failed: "+JSON.stringify(error));
		});
	};
	
	this.createAccount = function(){
		console.log("create...");
		var json = { 
			"dtoAccount" : {
				"amount" : $scope.accountCredit,
				"dtoClient" : {
					"id" : $scope.idClient
				}
			}
		}
		$http.post("http://localhost:9092/resources/accounts", json)
		.then(function(response) {
			console.log("createclient request ok");
		}, function(error){
			$log.error("create client failed: " + JSON.stringify(error));
		});
	};
	
	
	this.getTransactions = function(){
		console.log("read data...");
		$http.get("http://localhost:9093/resources/transactions?filters=none")
		.then(function(response) {
			console.log("listtransactions request ok");
			console.log("clients: " + JSON.stringify(response));
			console.log(response.data);
			if (response.data.transactions.length >0){
				console.log("There are transactions");
				$scope.transactions = response.data.transactions;
			}
		}, function(error){
			$log.error("Request failed: "+JSON.stringify(error));
		});
	};
	
	this.createTransaction = function(){
		console.log("create...");
		var json = { 
		  "dtoTransaction" : {
			"amount" : $scope.ammount,
			"type" : $scope.type,
			"dtoAccount" : {
				"id" : $scope.idAccount,
				"dtoClient" : {
					"id" : $scope.idClient
				}
			}
		  }
		}
		$http.post("http://localhost:9092/resources/accounts", json)
		.then(function(response) {
			console.log("createclient request ok");
		}, function(error){
			$log.error("create client failed: " + JSON.stringify(error));
		});
	};
	
	
	console.log("end load");

}]);




