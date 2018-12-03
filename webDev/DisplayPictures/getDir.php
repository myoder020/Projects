<?php 
    $dir=dir('M:\Pictures');
    $tar = array();
    $aar = checkContents($dir, $tar);
    $_SESSION['dirs'] = json_encode($aar);
    
    $dir->close();
    // echo $aar[array_search('2017',array_column($aar,'dirName'))]['dirPath'].DIRECTORY_SEPARATOR.$aar[array_search('PlantProject',array_column($aar,'dirName'))]['files'][0];

    function checkContents($d, $t) {
        $nar = array(); 
        $tempA = array();
        // echo "In checkContents function";  
        echo nl2br("\r\n");
        while(($fn = $d->read()) !== false) {
            if($fn === "." || $fn === ".." || $fn[0] === ".")
                continue;
            
            // if(is_file($d->path.DIRECTORY_SEPARATOR.$fn)) {
            //     array_push($t, $fn);
            // }

            if(is_dir($d->path.DIRECTORY_SEPARATOR.$fn)) {
               $nar = makeDirArray($fn, $d->path); 
               array_push($t, $nar);              
            }

        }
        return $t;
    }

    function getFiles($path) {
        $far = array();
        $files = scandir($path);
        foreach($files as $file) {
   
            // if(is_file($path.DIRECTORY_SEPARATOR.$file)) {
            //     array_push($far, $file);
            // }

            if(is_dir($path.DIRECTORY_SEPARATOR.$file) && $file !== "." && $file !== "..") {
                $dar = makeDirArray($file, $path);
                array_push($far, $dar);   
            }         

        }
        return $far;
    }

    function makeDirArray ($f, $p) {
        $dar = array(
            ('dirName') => $f,
            ('dirPath') => $p.DIRECTORY_SEPARATOR.$f,
            ('files') => getFiles($p.DIRECTORY_SEPARATOR.$f)
        );
        return $dar;
    }

    function displayPictures($p) {
        
        echo $p;
    }

    
    ?>
