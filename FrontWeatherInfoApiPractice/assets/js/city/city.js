const GET_LON_LAT = "http://localhost:8080/api/getLonLat?";

function getCities(){
    return ["Madrid", "Barcelona", "Zaragoza", "Lugo", "Las Palmas", "Oviedo", "Bilbao"];
}

function getLonLat(aCity){
    const param = "city=" + aCity;
    return get(GET_LON_LAT + param);
}
