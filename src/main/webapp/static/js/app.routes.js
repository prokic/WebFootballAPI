WebFootballAPI = angular.module('WebFootballAPI.routes', ['ngRoute']);

WebFootballAPI.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'static/html/home.html',
            controller : "FootballController"
        })
        .when('/home',{
            templateUrl : 'static/html/home.html',
            controller : 'FootballController'
        })
        .when ('/footballSeason/:year', {
            templateUrl: 'static/html/season/league/homeLeagues.html',
            controller: 'LeagueController',
            resolve: {
                "liga" : function($route,LeagueService,$routeParams){
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
            controller : 'TeamController',
            resolve : {
                 "tim" : function($route,TeamService){
                     return TeamService.getTeams($route.current.params.id);
                 }
            }
        })
        // .when('/season/:id/leaguetable',{
        //     templateUrl: 'static/html/league/league.html',
        //     controller: 'TableController',
        //     resolve : {
        //        "table" : function($route,LeagueTableService){
        //            return LeagueTableService.getLeagueTable($route.current.params.id);
        //        }
        //     }
        // })
        .when('/season/:id/leaguetable',{
            templateUrl: 'static/html/league/league.html',
            controller: 'TableController',
            resolve : {
                "table" : function($route,LeagueTableService,$routeParams){
                    if ($routeParams.proba){
                        return LeagueTableService.getLeagueTableGroup($route.current.params.id);
                    }
                    else {
                        return LeagueTableService.getLeagueTable($route.current.params.id);
                    }
                }
            }
        })
        .when ('/error',{
            templateUrl : 'static/html/error/error.html',
            controller : "ErrorController"
        })
        .otherwise({
            redirectTo: '/home'
        });

}]).run(function ($rootScope,$location,ChangingURL) {

    $rootScope.$on("$locationChangeSuccess", function (event,next,current) {

    });
    $rootScope.$on("$routeChangeStart", function (current,next) {
        var s = "dsdsadasd";
    });
    $rootScope.$on("$routeChangeSuccess",function(){

    });
    $rootScope.$on("$routeChangeError", function (current,next){
    });

    $rootScope.$on("$routeChangeError",function(event,next,current,rejection){
        ChangingURL.set(rejection.config.url);
        $location.path('/error');
    });

});