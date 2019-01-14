<?php
session_start();
include("nav.html");
include("getDir.php");

$dirs = $_SESSION['dirs'];
$jsonA = json_encode($dirs);
?>

<script type="text/javascript">

    function seePhotos(event) {
        event.preventDefault();
        var href = event.currentTarget.getAttribute("href");
        window.location='displayPictures.php?path=' + href;
    }
    
    var t = [
        "Matt","Stefanie"
    ]

    t.forEach(function(name, index) {
        console.log(name + " " + index);
    });

    var dirs = <?php echo $jsonA ?>;

    for(var i in dirs) {
        a = document.createElement('a');
        lb = document.createElement('br');
        d = dirs[i].dirPath;
        if(!d.includes("RAW")) {

            // console.log(d.charCodeAt(0));
            // if(d.charCodeAt(0) == 46) {
            //     console.log('First character is a .');
            //     d = dirs[i].dirPath.replace('.', '');
            // } 
            // else {
            //     d = dirs[i].dirPath;
            // }

            
            
            a.setAttribute("class","pics");
            a.setAttribute("onclick","seePhotos(event);");
            a.href=d;
            a.innerHTML = dirs[i].dirName;
            document.body.appendChild(a);
            document.body.appendChild(lb);
        }
        
    }
</script>