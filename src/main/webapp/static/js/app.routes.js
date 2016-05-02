WebFootballAPI = angular.module('WebFootballAPI.routes', ['ngRoute']);

WebFootballAPI.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'static/html/home.html',
            controller : "HomeController"
        })
        .when('/footballSeason',{
            templateUrl:'static/html/season/homeSeasons.html',
            controller: 'FootballController',
            data: {
                message: "hello"
            }
        })
        .when ('/footballSeason/:year', {
            templateUrl: 'static/html/season/league/homeLeagues.html',
            controller: 'LeagueController',
            resolve: {
                "liga" : function($route,LeagueService){
                    return LeagueService.getLeaguee($route.current.params.year);
                }
            }
        })
        .when ('/:id/fixtures',{
               templateUrl: 'static/html/season/league/fixtures/homeFixtures.html',
               controller : 'FootballController'
        })
        .when ('/season/:id/teams',{
            templateUrl: 'static/html/season/league/teams/homeTeams.html',
            controller : 'TeamController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]).run(function ($rootScope,$location,$timeout) {

    var URL = "";
    $rootScope.$on("$locationChangeSuccess", function (event,next,current) {

        var indexX = current.indexOf("#");
        if (indexX != -1){
            URL = current.substr(indexX+2,current.length);
        }
        else {
            URL = current;
        }
    });
    $rootScope.$on("$routeChangeStart", function () {
        var s = "dsadasdas";
    });
    $rootScope.$on("$routeChangeSuccess",function(){
        var r = "dsadsadsa";

    });
    $rootScope.$on("$routeChangeError",function(event,next,current,rejection){
        current.scope.errorMessage = rejection.status.toString()+" "+rejection.statusText;
        $timeout(function(){
             $location.path(URL);
        },5000);
    });
});