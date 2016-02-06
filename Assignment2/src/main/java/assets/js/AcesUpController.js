angular.module('AcesUp').controller('AcesUpController', function($scope, $http){
    // Debugging
    window.$scope = $scope;

    $scope.gameState = {};
    $scope.score = 123456;
    $scope.colOptions = [0, 1, 2, 3];

    /* --- On page load --- */

    // Get initial game state
    $http.get('/game').then(function(result){
        setGameState(result.data);
    });

    /* --- Actions --- */

    $scope.dealCards = function(){
        $http.post('/dealGame', $scope.gameState).then(function(result){
            setGameState(result.data);
        });
    };

    $scope.removeCard = function(column){
        $http.post('/removeCard/' + column, $scope.gameState).then(function(result){
            setGameState(result.data);
        });
    };

    $scope.moveCard = function(src, dest){
        $http.post('/moveCard/' + src + '/' + dest, $scope.gameState).then(function(result){
            setGameState(result.data);
        });
    };

    $scope.resetGame = function(){
        $http.get('/game').then(function(result){
            setGameState(result.data);
        });
    };

    /* --- Helper functions --- */

    function setGameState(state){
        $scope.gameState = state;
    }
});
