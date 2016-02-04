angular.module('AcesUp').controller('AcesUpController', function($scope, $http){
    // Debugging
    window.$scope = $scope;

    $scope.gameState = {};
    $scope.score = 123;
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
            var newState = JSON.parse(angular.toJson($scope.gameState));

            if(gameStateChanged(newState, result.data) == true){
                setGameState(result.data);
                console.log("Valid move!");
            }else{
                console.log("Invalid move!");
            }
        });
    };

    $scope.moveCard = function(src, dest){
        $http.post('/moveCard/' + src + '/' + dest, $scope.gameState).then(function(result){
            setGameState(result.data);
        });
    };

    /* --- Helper functions --- */

    function setGameState(state){
        $scope.gameState = state;
    }
});
