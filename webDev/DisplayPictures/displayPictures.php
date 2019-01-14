<?php   
include("nav.html");
require_once("./phpThumb-master/phpthumb.class.php");
require_once('./phpThumb-master/phpThumb.config.php');

$path = $_GET['path'];

displayPhotos($path);


function displayPhotos($path) {

    // $picDir = "M:\\Pictures";
    $files = scandir($path);
    $nPath = str_replace('.','',$path);
    $cnt = 0;
    $fCnt = 0;
    foreach($files as $f) {
        $fInfo = pathinfo($f);
        if($f !== "." && $f !== ".." && (isset($fInfo['extension']) && ($fInfo['extension'] == 'jpg' || $fInfo['extension'] == 'JPG'))) {
            if($cnt == 0) {
                echo "<div class = 'row'>";
            }
            echo "<div class = 'column'>";
            echo '<img src ="'.htmlspecialchars(phpThumbURL('src='.$nPath.'/'.$f.'&q=95&w=400&h=400', './phpThumb-master/phpThumb.php')).'">';
            echo "</div>";
            
            $cnt++;

            if($cnt == 3) {
                echo "</div>";
                $cnt = 0;
            }
        }
        $fCnt++;
    }
}
?>

<!-- /phpThumb-master/phpThumb.php?src= -->