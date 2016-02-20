angular.module('AcesUp').controller('AcesUpController', function($scope, $http, $interval){
    // Debugging
    window.$scope = $scope;

    $scope.gameState = {};
    $scope.score = 0;
    $scope.colOptions = [0, 1, 2, 3];
    $scope.invalidMove = false;
    $scope.locale = 'Freedom';
    $scope.locales = ['Freedom', 'Spanish'];

    /* --- On page load --- */

    // Get initial game state
    // TODO POST request with locale
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
            if(moveValid($scope.gameState, result.data)){
                setGameState(result.data);
                console.log("Valid move.");
                $scope.score++;
                //$scope.score++;
            }else{
                // flash the screen red and display invalid move
                console.log("Invalid move.");
                $scope.invalidMove = true;
                $interval(error, 1000);
            }
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

    $scope.chooseGame = function(){
        $http.post('/game/' + $scope.locale)
        .then(function(result){
            setGameState(result.data);
        });
    };

    /* --- Helper functions --- */

    function setGameState(state){
        $scope.gameState = state;
    }

    function moveValid(oldState, newState){
         for(var i = 0; i < 4; i++){
             // If old/new game states differ
             if(newState.cols[i].length != oldState.cols[i].length){
                 return true;
             }
         }
         return false;
     }

 	function error (){
 		$scope.invalidMove = false;
 		$interval.cancel(error);
 	}
});
