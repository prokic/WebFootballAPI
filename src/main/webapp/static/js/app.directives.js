WebFootballAPI = angular.module('WebFootballAPI.directives', []);

WebFootballAPI.directive('leagueTableGroup',function(){
    return {
        restrict: 'EA',
        template: '<div ng-include="grupa ? \'static/html/league/leagueGroup.html\' : \'static/html/league/league.html\'"></div>',
        controller : function ($scope) {

            if ($scope.grupa){
                $scope.leagueGroupTeams = $scope.leagues.standings[0];
                $scope.primaryClassIndex = 0;

                $scope.changeGroup = function (index) {
                    $scope.leagueGroupTeams = $scope.leagues.standings[index];
                    $scope.primaryClassIndex = index;
                };
            }
        }
    }
});

WebFootballAPI.directive('equalSelected', function(){
    return{
        require:'ngModel',
        link: function(scope, elem, attrs, ctrl){

            ctrl.$parsers.unshift(function (viewValue) {

                return viewValue !== 'Equal';
            });
        }
    };
});