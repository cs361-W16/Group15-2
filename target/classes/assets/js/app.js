angular.module('AcesUp', ['ngMaterial'])
    .config(function($mdThemingProvider){
        $mdThemingProvider.theme('default')
            .primaryPalette('indigo')
            .accentPalette('red');
    });
