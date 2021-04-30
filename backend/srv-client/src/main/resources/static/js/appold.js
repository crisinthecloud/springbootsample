var app = angular.module("crisapp", []);

app.controller("TestController", function() {
    this.name = "Jignesh Trivedi";
});


app.controller("VideoClubController", function() {
    this.hola = "Hola";

    console.log("let hola  ee");

    this.peliculas = [{
            "index": 0,
            "title": "Joker",
            "searchTitle": "Joker",
            "image": "movie_0001.png",
            "releaseDate": "04/10/2019",
            "rating": "0",
            "synopsis": "Arthur Fleck es un payaso loco que da patadas a la basura, baila regueton sinfónico en baños de dudosa reputación y hace caras a los periódicos",
            "actors": "Joaquin Phoenix, Robert De Niro, Zazie Beetz",
            "director": "Todd Phillips",
            "genre": "Docudrama",
            "review": undefined,
            "available": true
        }
        /*
        ,{
            "index": 0,
            "title": "Joke 2r",
            "searchTitle": "Joker",
            "image": "movie_0001.png",
            "releaseDate": "04/10/2019",
            "rating": "2",
            "synopsis": "Arthur Fleck es un payaso loco que da patadas a la basura, baila regueton sinfónico en baños de dudosa reputación y hace caras a los periódicos",
            "actors": "Joaquin Phoenix, Robert De Niro, Zazie Beetz",
            "director": "Todd Phillips",
            "genre": "Docudrama",
            "review": undefined,
            "available": true

        }
        */

    ];

    //para el formulario de buscar por ratings
    //sacar a otro controller
    this.ratings = [
        { value: "0", name: "Penosa" },
        { value: "1", name: "\u2606" },
        { value: "2", name: "\u2606\u2606" },
        { value: "3", name: "\u2606\u2606\u2606" },
        { value: "4", name: "\u2606\u2606\u2606\u2606" },
        { value: "5", name: "\u2606\u2606\u2606\u2606\u2606" }
    ];

    this.search = "";
    this.fieldSearch = {
        rating: undefined
    };

});





//ejemplo de filtro
app.filter("ratingToStars", function() {
    return function(input, color, tipo) {

        return out;
    };
});





// sintaxis para directiva de tipo elemento
app.directive("tituloPelicula", function() {
    return {
        restrict: "E",
        //[choice1]
        template: "algo a mostrar",
        //[choice2]
        templateUrl: "titulo-pelicula.html",
        //[opcional]c
        ontroller: function(
            //código de directiva 
        ) {},
        //[opcinal]
        controllerAs: "aliasDelController"
    }
});


//sintaxis de directivas de tipo atributo
app.directive("tituloPelicula", function() {
    return {
        restrict: "A",
        //[choice1]
        template: "algo a mostrar",
        //[choice2]
        templateUrl: "titulo-pelicula.html",
        //[opcional]
        controller: function() {},
        //[opcinal]
        controllerAs: "aliasDelController"
    }
});



app.controller("FormController", function($scope) {
    this.message = "ITSM";
    this.json = "json";
    this.email = "cristobal.gonzalezalmiron.ext@telefonica.com";
    this.result = "uno";

    this.sendJson = function(action, message, json, email) {
        console.log("sendJson 1 --------" + action);
        console.log("message:" + message);
        console.log("email: " + email);
        console.log("json: " + json);

        this.result = "hola devuelvo algo " + message;
    };
});