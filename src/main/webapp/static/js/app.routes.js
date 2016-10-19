WebFootballAPI = angular.module('WebFootballAPI.routes', ['ngRoute']);

WebFootballAPI.config(['$routeProvider', function ($routeProvider,table) {
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
                "liga" : function($route,LeagueService){
                    return LeagueService.getLeaguee($route.current.params.year);
                }
            }
        })
        .when ('/:id/fixture',{
               templateUrl: 'static/html/season/league/fixture/homeFixtures.html',
               controller : 'FootballController'
        })
        .when ('/season/:id/teams',{
            templateUrl: 'static/html/season/league/teams/homeTeams.html',
            controller : 'TeamsController',
            resolve : {
                 "tim" : function($route,TeamsService){
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
            template: '<league-table-group></league-table-group>',
            controller: 'TableController',
            resolve : {
                "table" : function($route,LeagueTableService){
                    return LeagueTableService.getLeagueTable($route.current.params.id);
                }
            }
        })
        .when ('/season/team/:id/players',{
            templateUrl : 'static/html/players/players.html',
            controller : 'PlayersController',
            resolve : {
                "playersResolve" : function ($route, PlayersService) {
                    return PlayersService.getPlayers($route.current.params.id);
                }
            }
        })
        .when ('/season/team/:id/fixtures',{
            templateUrl : 'static/html/team/fixture/fixture.html',
            controller : 'TeamFixtureController',
            resolve : {
                "playersFixtureResolve" : function ($route, FixtureService) {
                    return FixtureService.getTeamFixtures($route.current.params.id);
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