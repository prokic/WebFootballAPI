WebFootballAPI = angular.module('WebFootballAPI.routes', ['ngRoute']);

WebFootballAPI.config(['$routeProvider','$locationProvider', function ($routeProvider,$locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'static/html/home.html',
            controller : "FootballController"
        })
        .when('/home',{
            templateUrl : 'static/html/home.html',
            controller : 'FootballController'
        })
        //ne cackati
        .when ('/footballSeason/:year', {
            templateUrl: 'static/html/season/league/homeLeagues.html',
            controller: 'LeagueController',
            resolve: {
                "liga" : function($route,LeagueService) {
                    return LeagueService.getLeaguee($route.current.params.year);
                }
                // },
                // "proba" : function($route,LeagueService){
                //     var lista = [];
                //     var p = "api/season/" + $route.current.params.year;
                //     var l = "api/team/81" ;
                //     lista.push(p,l);
                //     // lista.push(l);
                //     return LeagueService.novo(lista);
                // }
            }
        })
        .when ('/league/:id/fixtures',{
               controller : 'LeagueFixturesController',
               templateUrl : 'static/html/season/league/fixtures/leagueFixtures.html',
               resolve: {
                   "LeagueFixturesResolve" : function ($route,LeagueFixtureService) {
                       return LeagueFixtureService.getLeagueFixtures($route.current.params.id,1);
                   }
               }
        })
        .when ('/cup/:id/fixtures',{
            controller : 'CupFixturesController',
            templateUrl : 'static/html/season/league/fixtures/cupFixtures.html',
            resolve: {
                "CupFixturesResolve" : function ($route,LeagueFixtureService) {
                    return LeagueFixtureService.getCupFixtures($route.current.params.id);
                }
            }
        })
        .when ('/season/:id/teams',{
            templateUrl: 'static/html/season/league/teams/homeTeams.html',
            controller : 'TeamsController',
            resolve : {
                 "teamsResolve" : function($route,TeamsService){
                     return TeamsService.getTeams($route.current.params.id);
                 }
            }
        })
        .when('/season/:id/team',{
            templateUrl: 'static/html/team/teamHome.html',
            controller: 'TeamController',
            resolve : {
               "teamResolve" : function($route,TeamService){
                   return TeamService.getTeam($route.current.params.id);
               }
            }
        })
        .when('/season/:id/leaguetable',{
            templateUrl : function ($location) {
                return $location.table === "true" ? "static/html/league/leagueGroup.html" : "static/html/league/league.html";
            },
            controller: 'TableController',
            resolve : {
                "LeagueTableResolve" : function($route,LeagueTableService){
                    var table = $route.current.params.table;
                    return LeagueTableService.getLeagueTable($route.current.params.id,table);
                }
            }
        })
        //slobodno
        .when('/season/:id/fixtures' ,{
            template : 'static/html/'

        })
        //sve uradjeno
        .when ('/season/team/:id/players',{
            templateUrl : 'static/html/players/players.html',
            controller : 'PlayersController',
            resolve : {
                "playersResolve" : function ($route, PlayersService) {
                    return PlayersService.getPlayers($route.current.params.id);
                }
            }
        })
        //sve uradjeno
        .when ('/season/team/:id/fixtures',{
            templateUrl : 'static/html/team/fixture/fixture.html',
            controller : 'TeamFixtureController',
            resolve : {
                "playersFixtureResolve" : function ($route, FixtureService) {
                    return FixtureService.getTeamFixtures($route.current.params.id);
                }
            }
        })
        //error page je gotov samo urediti stranicu
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
    $rootScope.$on("$locationChangeError", function (event,next,current) {
         var s = "";
    });
    $rootScope.$on("$routeChangeStart", function (current,next) {
        var s = "dsdsadasd";
    });
    $rootScope.$on("$routeChangeSuccess",function(){

    });
    $rootScope.$on("$routeChangeError",function(event,next,current,rejection){
        ChangingURL.set(rejection.config.url);
        $location.path('/error');
    });

});