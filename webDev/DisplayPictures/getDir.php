<?php 
    $f = is_dir('./pictures');
    
    $dir=dir('./pictures');
    $aar = checkContents($dir);
    $_SESSION['dirs'] = $aar;
    $dir->close();

    function checkContents($d) {
        $nar = array(); 
        $tempA = array();
        $finalArray = array();

        while(($fn = $d->read()) !== false) {
            if($fn === "." || $fn === ".." || $fn[0] === ".")
                continue;

            if(is_dir($d->path.DIRECTORY_SEPARATOR.$fn)) {
               $nar = makeDirArray($fn, $d->path); 
               array_push($tempA, $nar);              
            }

        }

        $pattern = '/\//';

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

        return $finalArray;
    }

    function getFiles($path) {
        $nPath = str_replace('\\', '/', $path);
        $far = array();
        $temp = array();
        $files = scandir($nPath);
        $cnt = 0;

        foreach($files as $file) {

            if(is_dir($nPath.'/'.$file) && $file !== "." && $file !== "..") {
                $cnt++;
                $far = makeDirArray($file, $nPath);  
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
            ('dirPath') => $p.'/'.$f
        );

        $final = $dar;
        $sub = getFiles($p.'/'.$f);
        if($sub !== null) {
            foreach($sub as $sb) {
                array_push($final, $sb);
            }
        } 
        return $final;
    }

    ?>

