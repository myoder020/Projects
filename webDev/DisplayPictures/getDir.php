<?php 
    $dir=dir('M:\Pictures');
    $aar = checkContents($dir);
    $_SESSION['dirs'] = $aar;
    $dir->close();

    function checkContents($d) {
        $nar = array(); 
        $tempA = array();
        $finalArray = array();

        echo nl2br("\r\n");
        while(($fn = $d->read()) !== false) {
            if($fn === "." || $fn === ".." || $fn[0] === ".")
                continue;

            if(is_dir($d->path.DIRECTORY_SEPARATOR.$fn)) {
               $nar = makeDirArray($fn, $d->path); 
               array_push($tempA, $nar);              
            }

        }

        $pattern = '/\\\\/';

        foreach($tempA as $dir) {
            $cnt = count($dir);
            for($i=0;$i<$cnt;$i++) {
                if(isset($dir[$i])) {
                    preg_match_all($pattern,$dir[$i]['dirPath'], $matches, PREG_OFFSET_CAPTURE);
                    $dir[$i]['dirName'] = substr($dir[$i]['dirPath'],$matches[0][1][1]);
                    array_push($finalArray, $dir[$i]);
                    unset($dir[$i]);
                }
            }  
            array_push($finalArray, $dir);          
        }

        print_r($finalArray);
        return $finalArray;
    }

    function getFiles($path) {
        $far = array();
        $temp = array();
        $files = scandir($path);
        $cnt = 0;

        foreach($files as $file) {

            if(is_dir($path.DIRECTORY_SEPARATOR.$file) && $file !== "." && $file !== "..") {
                $cnt++;
                $far = makeDirArray($file, $path);  
                array_push($temp, $far);             
            }         

        }

        if($cnt > 0) {
            return $temp;
        } else {
            return null;
        }
    }

    function makeDirArray ($f, $p) {
        $final = array();
        $dar = array(
            ('dirName') => $f,
            ('dirPath') => $p.DIRECTORY_SEPARATOR.$f
        );
        $final = $dar;
        $sub = getFiles($p.DIRECTORY_SEPARATOR.$f);
        if($sub !== null) {
            foreach($sub as $sb) {
                array_push($final, $sb);
            }
        } 
        return $final;
    }

    ?>

