app.service("addressService", function ($http) {

    this.findAreas = function (citiesId) {
        return $http.get("../address/findAreas?citiesId=" + citiesId)
    }
    this.findCities = function (provincesId) {
        return $http.get("../address/findCities?provincesId=" + provincesId);
    }
    this.findProvince = function (provincesId) {
        return $http.get("../address/findProvince?provincesId=" + provincesId);
    }
    this.findProvincesAll = function () {
        return $http.get("../address/findProvincesAll");
    }
    this.findAreasAll = function () {
        return $http.get("../address/findAreasAll");
    }
    this.findCitieAll = function () {
        return $http.get("../address/findCitieAll");
    }

})