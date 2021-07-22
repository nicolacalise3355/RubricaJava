<?php

$connessione = new mysqli("localhost", "root", "", "schema_rubrica");
// verifica su eventuali errori di connessione
if ($connessione->connect_errno) {
    echo "Connessione fallita: ". $connessione->connect_error . ".";
    exit();
}

function addContact($connessione, $nome, $cognome, $telefono){
    $query = "INSERT INTO contatti(nome, cognome, telefono) VALUES ('$nome','$cognome','$telefono')";
    $result = $connessione->query($query);
    echo $result;
}

function getContact($connessione){
    $findalData = [];
    $query = "SELECT * FROM contatti";
    //echo $query_find_mission . "<br>";
    $results = $connessione->query($query);
    if($results->num_rows > 0){
        while($row = $results->fetch_assoc()){ 
            $data = [];
            $data['id'] = $row['id'];
            $data['nome'] = $row['nome'];
            $data['cognome'] = $row['cognome'];
            $data['telefono'] = $row['telefono'];
            $finalData[] = $data;
        }
    }
    $finalArray = [];
    $finalArray['contatti'] = $finalData;
    $string = json_encode($finalArray);
    return $string;
}

function findCommand($codice,$connessione){
    switch($codice){
        case 1:
            echo getContact($connessione);
            break;
        case 2:
            addContact($connessione, $_POST['nome'],$_POST['cognome'],$_POST['telefono']);
            break;
        default:
            echo "nocmdfound";
            break;
    }
}

if($_POST){
    $request = $_POST['codice'];
    //echo var_export($_POST,true);
    findCommand($request,$connessione);
}else{
    echo "null";
}

?>