WebFootballAPI = angular.module('WebFootballAPI.directives', [])

WebFootballAPI.directive('leagueTable',function(){
    return {
        restrict: 'E',
        templateUrl: 'static/html/league/league.html',
    }
});
WebFootballAPI.directive('leagueTableGroup',function(){
    return {
        restrict: 'E',
        templateUrl: 'static/html/league/leagueGroup.html',
    }
});