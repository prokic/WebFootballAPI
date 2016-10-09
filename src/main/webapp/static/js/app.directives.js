WebFootballAPI = angular.module('WebFootballAPI.directives', [])

WebFootballAPI.directive('leagueTableGroup',function(){
    return {
        restrict: 'EA',
        template: '<div ng-include="grupa ? \'static/html/league/leagueGroup.html\' : \'static/html/league/league.html\'"></div>',
        controller : function ($scope) {

            if ($scope.grupa){

                $scope.leagueGroupTeams = $scope.leagues.standings[0];
                $scope.prvi = 0;

                $scope.broj = function () {
                    return ( $scope.leagues.standings.length);
                };

                $scope.makeAClass = function (index) {
                    return ($scope.prvi === index) ? "btn btn-primary" : "btn btn-default";
                };

                $scope.changeGroup = function (index) {
                    $scope.leagueGroupTeams = $scope.leagues.standings[index];
                    $scope.prvi = index;
                };
            }
        }
    }
});

WebFootballAPI.directive('inputNumberAge', function(){
    return{
        require:'ngModel',
        link: function(scope, elem, attrs, ctrl){
            ctrl.$parsers.unshift(function (viewValue) {

                if (isNaN(parseInt(viewValue))){
                    return undefined;
                }
                var getNumber = parseInt(viewValue);
                if (getNumber >= 15 && getNumber <= 50 ) {
                    ctrl.$setValidity('inputNumberAge',true);
                    return viewValue;
                } else {
                    ctrl.$setValidity('inputNumberAge', false);
                    return undefined;
                }
            });
        }
    };

});

WebFootballAPI.directive('inputNumberMarketValue', function(){
    return{
        require:'ngModel',
        link: function(scope, elem, attrs, ctrl){
            ctrl.$parsers.unshift(function (viewValue) {

                if (isNaN(parseInt(viewValue)) || (viewValue.indexOf("-") !== -1) ){
                    ctrl.$setValidity('inputNumberMarketValue', false);
                    return undefined;
                }
                var getNumber = parseInt(viewValue);
                if (getNumber >= 0 ) {
                    ctrl.$setValidity('inputNumberMarketValue',true);
                    return viewValue;
                } else {
                    ctrl.$setValidity('inputNumberMarketValue', false);
                    return undefined;
                }
            });
        }
    };
});

WebFootballAPI.directive('inputNameValue', function(){
    return{
        require:'ngModel',
        link: function(scope, elem, attrs, ctrl){
            ctrl.$parsers.unshift(function (viewValue) {

                if (viewValue != "") {
                    ctrl.$setValidity('inputNumberAge',true);
                    return viewValue;
                } else {
                    ctrl.$setValidity('inputNumberAge', false);
                    return undefined;
                }
            });
        }
    };
});

